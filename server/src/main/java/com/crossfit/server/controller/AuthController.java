package com.crossfit.server.controller;

import com.crossfit.server.dto.member.LoginRequestDto;
import com.crossfit.server.dto.member.LoginResponseDto;
import com.crossfit.server.dto.member.MemberDto;
import com.crossfit.server.service.GymService;
import com.crossfit.server.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Auth API", description = "로그인, 회원가입, 로그아웃 API")
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final MemberService memberService;
    private final GymService gymService;

    @PostMapping("")
    @Operation(summary = "회원 가입")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "중복된 이메일일 때"),
    })
    public ResponseEntity<?> register(@RequestBody MemberDto dto) {
        memberService.register(dto);
        return ResponseEntity.status(HttpStatus.OK).body("회원가입이 완료되었습니다.\n로그인 후 이용해주세요!");
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 사용자"),
    })
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto, HttpServletResponse response) {
        LoginResponseDto loginResponseDto = memberService.login(dto);

        Cookie refreshTokenCookie = new Cookie("refreshToken", loginResponseDto.getRefreshToken());
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(false);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setDomain("localhost");
        refreshTokenCookie.setMaxAge(14 * 24 * 60 * 60);
        response.addCookie(refreshTokenCookie);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails)principal;
        loginResponseDto.setRoles(userDetails.getAuthorities().toString());
        //log.debug("===========login user"+userDetails.getAuthorities().toString());
        loginResponseDto.setRefreshToken(null);

        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    @GetMapping("")
    @Operation(summary = "로그아웃")
    public void logout(HttpServletResponse response){
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    // 추후 AdminController 로 이동
    @GetMapping("/coach")
    @Operation(summary = "코치 등급 추가")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "코치 등급 추가 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 사용자"),
    })
    public void addRoleCoach(@RequestParam String email){
        memberService.addRoleCoach(email);
        gymService.deleteOrUpdateRole(email);
    }

}