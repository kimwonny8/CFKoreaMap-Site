package com.crossfit.server.dto.gym;

import com.crossfit.server.entity.Gym;
import com.crossfit.server.entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class MyPageRequestDto {

    private Long id;

    private String email;

    private String name;

    private String zoneCode;

    private String roadAddress;

    private String status;

    private String fileName;

    private Member member;

    public Gym toEntity() {
        return Gym.builder()
                .id(id)
                .name(name)
                .zoneCode(zoneCode)
                .roadAddress(roadAddress)
                .status(status)
                .fileName(fileName)
                .member(member)
                .build();
    }


}
