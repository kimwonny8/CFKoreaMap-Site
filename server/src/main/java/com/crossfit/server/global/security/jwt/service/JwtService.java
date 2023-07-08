package com.crossfit.server.global.security.jwt.service;

import com.crossfit.server.domain.member.dto.LoginResponseDto;
import com.crossfit.server.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtTokenProvider jwtTokenProvider;

    public ResponseEntity<LoginResponseDto> reToken(String refreshToken) {
        try {
            if (!jwtTokenProvider.validateRefreshToken(refreshToken)) {
                throw new RuntimeException("Refresh token expired");
            }

            String accessToken = jwtTokenProvider.generateAccessToken(refreshToken);
            LoginResponseDto loginResponseDto = LoginResponseDto.builder()
                    .grantType("Bearer")
                    .accessToken(accessToken)
                    .build();
            return ResponseEntity.ok(loginResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
