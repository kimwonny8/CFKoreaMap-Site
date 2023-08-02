package com.crossfit.server.controller;

import com.crossfit.server.dto.gym.MyPageRequestDto;
import com.crossfit.server.dto.gym.MyPageResponseDto;
import com.crossfit.server.service.GymService;
import com.crossfit.server.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "GYM API", description = "GYM API")
@RequestMapping("/api/v1/gym")
public class GymController {

    private final GymService gymService;
    private final MemberService memberService;

    @GetMapping("/role")
    @Operation(summary = "회원 등급 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "코치등급이거나 대기중"),
            @ApiResponse(responseCode = "404", description = "코치등급이 아닐 때"),
    })
    public MyPageResponseDto memberRoleCheck(@RequestParam String email) {
        return gymService.memberRoleCheck(email);
    }

    @PostMapping("/role")
    @Operation(summary = "코치 등업")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "코치 등업"),
            @ApiResponse(responseCode = "409", description = "이미 다른 아이디로 되어 있을 때"),
    })
    public ResponseEntity<?> addRoleCoach(@RequestBody MyPageRequestDto dto) {
        gymService.updateRole(dto, "wait");
        return ResponseEntity.status(HttpStatus.OK).body("코치 신청이 완료되었습니다.");
    }

    @PutMapping("/role")
    @Operation(summary = "코치 권한 제거")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "코치 권한 제거"),
            @ApiResponse(responseCode = "404", description = "등록된 센터가 아님"),
    })
    public ResponseEntity<?> removeRoleCoach(@RequestBody MyPageRequestDto dto) {
        gymService.deleteOrUpdateRole(dto.getEmail());
        memberService.removeRoleCoach(dto.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body("코치와 센터 연결이 해제되었습니다.");
    }
}
