package com.crossfit.server.dto.member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginResponseDto {

    private String gym;
    private String roles;
    private String grantType;
    private String accessToken;
    private String refreshToken;
}