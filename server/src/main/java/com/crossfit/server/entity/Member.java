package com.crossfit.server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Member{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = true, length = 50)
    private String name;

    @Column(nullable = true, length = 100)
    private String gym;

    @Column(name = "activated")
    private boolean activated;

    @Column
    private String refreshToken;

    @ManyToMany
    @JoinTable(
            name = "member_authority",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @Builder
    public Member(Long id, String email, String password, String name, String gym, Set<Authority> authorities, boolean activated, String refreshToken) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.gym = gym;
        this.authorities = authorities;
        this.activated = activated;
        this.refreshToken = refreshToken;
    }

    public void updateToken(String email, String refreshToken){
        this.email=email;
        this.refreshToken=refreshToken;
    }
}