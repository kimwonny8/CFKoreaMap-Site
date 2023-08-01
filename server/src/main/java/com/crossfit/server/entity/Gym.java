package com.crossfit.server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Gym {

    @Id
    @Column(name = "gym_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String kakaoId;

    @Column(length = 50)
    private String zoneCode;

    @Column
    private String roadAddress;

    @Column(length = 5)
    private String status;

    @Column
    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Gym(Long id, String name, String kakaoId, String zoneCode, String roadAddress, String status, String fileName, Member member) {
        this.id = id;
        this.name = name;
        this.kakaoId = kakaoId;
        this.zoneCode = zoneCode;
        this.roadAddress = roadAddress;
        this.status = status;
        this.fileName = fileName;
        this.member = member;
    }
}