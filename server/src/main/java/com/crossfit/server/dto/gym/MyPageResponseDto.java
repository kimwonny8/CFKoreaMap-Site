package com.crossfit.server.dto.gym;

import com.crossfit.server.entity.Gym;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPageResponseDto {

    private String gymName;
    private String status;
    private String kakaoId;
    private String zoneCode;
    private String roadAddress;

}
