package com.blocky.backend.service;

import com.blocky.backend.dto.request.LoginRequestDto;
import com.blocky.backend.dto.request.SignupRequestDto;

public interface AuthService {
    void signUp(SignupRequestDto signupRequestDto);
    String login(LoginRequestDto loginRequestDto);
}
