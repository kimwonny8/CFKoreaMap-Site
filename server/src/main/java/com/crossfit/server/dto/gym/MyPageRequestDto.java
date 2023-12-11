package com.crossfit.server.dto.gym;

import com.crossfit.server.entity.Gym;
import com.crossfit.server.entity.Member;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyPageRequestDto {

    private Long id;

    private String email;

    private String gymName;

    private String zoneCode;

    private String roadAddress;

    private String status;

    private String fileName;

    private Member member;

    public Gym toEntity() {
        return Gym.builder()
                .id(id)
                .gymName(gymName)
                .zoneCode(zoneCode)
                .roadAddress(roadAddress)
                .status(status)
                .fileName(fileName)
                .member(member)
                .build();
    }


}
