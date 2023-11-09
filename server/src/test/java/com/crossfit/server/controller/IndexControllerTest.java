package com.crossfit.server.controller;

import com.crossfit.server.config.security.SecurityConfig;
import com.crossfit.server.jwt.JwtAccessDeniedHandler;
import com.crossfit.server.jwt.JwtAuthenticationEntryPoint;
import com.crossfit.server.jwt.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IndexController.class)
@Import(SecurityConfig.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @MockBean
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Test
    public void index() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome Crossfit Page!")); // 수정된 부분
    }
}
