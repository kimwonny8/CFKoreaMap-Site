package com.crossfit.server.controller;

import com.crossfit.server.dto.member.LoginRequestDto;
import com.crossfit.server.dto.member.LoginResponseDto;
import com.crossfit.server.dto.member.MemberDto;
import com.crossfit.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final MemberService memberService;

    @PostMapping("")
    public ResponseEntity<?> register(@RequestBody MemberDto dto) {
        try {
            memberService.register(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("중복된 아이디입니다.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto, HttpServletResponse response) {
        LoginResponseDto loginResponseDto = memberService.login(dto);

        Cookie refreshTokenCookie = new Cookie("refreshToken", loginResponseDto.getRefreshToken());
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setSecure(false);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setDomain("localhost");
        refreshTokenCookie.setMaxAge(14 * 24 * 60 * 60);
        response.addCookie(refreshTokenCookie);

        return new ResponseEntity<>(loginResponseDto.getAccessToken(), HttpStatus.OK);
    }

    @GetMapping("")
    public void logout(HttpServletResponse response){
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}