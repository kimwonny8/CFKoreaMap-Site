package com.crossfit.server.domain.member.repository;

import com.crossfit.server.domain.member.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    @EntityGraph(attributePaths = "authorities") // 엔티티그래프 통해 EAGER로 가져온다.
    Optional<Member> findOneWithAuthoritiesByEmail(String email); // user를 기준으로 유저를 조회할 때 권한정보도 가져온다.


    Optional<Member> findByRefreshToken(String refreshToken);
}