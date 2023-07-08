package com.crossfit.server.global.security.jwt.service;

import com.crossfit.server.domain.member.entity.Member;
import com.crossfit.server.domain.member.repository.MemberRepository;
import com.crossfit.server.global.security.MemberAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        Member member = memberRepository.findOneWithAuthoritiesByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));

        if(!member.isActivated()) throw new RuntimeException(member.getName() + " -> 활성화되어 있지 않습니다.");
        return new MemberAdapter(member);
    }
}