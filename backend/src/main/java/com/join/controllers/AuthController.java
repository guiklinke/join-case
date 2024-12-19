package com.join.controllers;

import com.join.dtos.LoginRequestDTO;
import com.join.dtos.LoginResponseDTO;
import com.join.dtos.RegisterRequestDTO;
import com.join.dtos.RegisterResponseDTO;
import com.join.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> createUsuario(@Validated @RequestBody RegisterRequestDTO registerRequestDto) {
        authService.registrar(registerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new RegisterResponseDTO("Usuário registrado com sucesso!"));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticateUsuario(@Validated @RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok().body(authService.login(loginRequestDTO));
    }
}
