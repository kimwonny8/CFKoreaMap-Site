package com.crossfit.server.domain.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginResponseDto {

    private String grantType;
    private String accessToken;
    private String refreshToken;
}