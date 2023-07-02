package com.crossfit.server.domain.member.dto;

import com.crossfit.server.domain.member.entity.Authority;
import com.crossfit.server.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long id;

    private String email;
    private String password;

    private String name;
    private String birth;
    private boolean activated;

    private Set<Authority> authorities;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .birth(birth)
                .activated(activated)
                .authorities(authorities)
                .build();
    }
}
