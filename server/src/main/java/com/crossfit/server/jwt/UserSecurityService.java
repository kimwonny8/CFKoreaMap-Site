package com.crossfit.server.jwt;

import com.crossfit.server.entity.Member;
import com.crossfit.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        Member member = memberRepository.findOneWithAuthoritiesByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 사용자를 찾을 수 없습니다."));

        if(!member.isActivated()) throw new RuntimeException(member.getName() + " -> 활성화되어 있지 않습니다.");
        return new MemberAdapter(member);
    }
}