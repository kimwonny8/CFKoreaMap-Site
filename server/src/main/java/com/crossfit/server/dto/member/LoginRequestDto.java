package com.crossfit.server.dto.member;

import com.crossfit.server.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;

}