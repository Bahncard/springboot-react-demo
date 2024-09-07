package github.bahncard.demo.todo.service;

import github.bahncard.demo.todo.dto.JwtAuthResponse;
import github.bahncard.demo.todo.dto.LoginDto;
import github.bahncard.demo.todo.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);
}
