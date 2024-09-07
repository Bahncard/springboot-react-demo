package github.bahncard.demo.todo.controller;

import lombok.AllArgsConstructor;
import github.bahncard.demo.todo.dto.JwtAuthResponse;
import github.bahncard.demo.todo.dto.LoginDto;
import github.bahncard.demo.todo.dto.RegisterDto;
import github.bahncard.demo.todo.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Define REST API for authentication
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService; //Inject AuthService to handle business logic of authentication

    // Build Register REST API, map request to /api/auth/register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}
