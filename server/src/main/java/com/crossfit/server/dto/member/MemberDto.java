package com.crossfit.server.dto.member;

import com.crossfit.server.entity.Authority;
import com.crossfit.server.entity.Member;
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
    private String gym;
    private boolean activated;

    private Set<Authority> authorities;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .gym(gym)
                .activated(activated)
                .authorities(authorities)
                .build();
    }
}
