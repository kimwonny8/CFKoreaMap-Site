package com.crossfit.server.controller;

import com.crossfit.server.dto.member.LoginRequestDto;
import com.crossfit.server.dto.member.MemberDto;
import com.crossfit.server.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest extends AbstractControllerTest {

    @Autowired
    private AuthController authController;

    @Autowired
    private MemberService memberService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected Object controller() {
        return authController;
    }

    @Test
    void register() throws Exception {
        MemberDto dto = new MemberDto();
        dto.setEmail("test@test.com");
        dto.setPassword("password_test");
        dto.setName("name_test");

        mockMvc.perform(
                        post("/api/v1/auth")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    void login_success() throws Exception {
        MemberDto member = new MemberDto();
        member.setEmail("test@test.com");
        member.setPassword("password");
        memberService.register(member);

        LoginRequestDto dto = new LoginRequestDto();
        dto.setEmail("test@test.com");
        dto.setPassword("password");

        mockMvc.perform(
                        post("/api/v1/auth/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void login_fail() throws Exception {
        LoginRequestDto dto = new LoginRequestDto();
        dto.setEmail("없는 아이디");
        dto.setPassword("password");

        mockMvc.perform(
                        post("/api/v1/auth/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

}
