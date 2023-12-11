package com.crossfit.server.service;

import com.crossfit.server.dto.gym.MyPageRequestDto;
import com.crossfit.server.dto.gym.MyPageResponseDto;
import com.crossfit.server.entity.Gym;
import com.crossfit.server.entity.Member;
import com.crossfit.server.exception.gym.GymDuplicationException;
import com.crossfit.server.exception.gym.GymNotFoundException;
import com.crossfit.server.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MyPageService {

    private final GymRepository gymRepository;
    private final MemberService memberService;

    public MyPageResponseDto memberRoleCheck(String email) {
        Member member = memberService.findId(email);

        Gym gym = gymRepository.findByMemberId(member.getId())
                .orElseThrow(GymNotFoundException::new);

        MyPageResponseDto dto = new MyPageResponseDto();
        dto.setGymName(gym.getGymName());
        dto.setStatus(gym.getStatus());
        dto.setZoneCode(gym.getZoneCode());
        dto.setRoadAddress(gym.getRoadAddress());
        dto.setKakaoId(gym.getKakaoId());

        return dto;
    }

    public Gym updateRole(MyPageRequestDto dto, String status) {
        Member member = memberService.findId(dto.getEmail());

        Optional<Gym> optionalGym = gymRepository.findByGymName(dto.getGymName());
        if (optionalGym.isPresent()) {
            throw new GymDuplicationException();
        } else {
            dto.setMember(member);
            dto.setStatus(status);
            return gymRepository.save(dto.toEntity());
        }
    }

    public Gym deleteOrUpdateRole(String email) {
        Member member = memberService.findId(email);

        Gym gym = gymRepository.findByMemberId(member.getId())
                .orElseThrow(() -> new GymNotFoundException());

        if (gym.getStatus().equals("wait")) {
            gym.updateStatus("true");
        } else {
            gym.deleteCoach(null, null);
        }
        return gymRepository.save(gym);
    }
}
