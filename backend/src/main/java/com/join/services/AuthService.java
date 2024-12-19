package com.join.services;

import com.join.config.SecurityConfig;
import com.join.dtos.LoginRequestDTO;
import com.join.dtos.LoginResponseDTO;
import com.join.dtos.RegisterRequestDTO;
import com.join.entities.Role;
import com.join.entities.RoleName;
import com.join.entities.Usuario;
import com.join.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final SecurityConfig securityConfig;
    private final TokenService tokenService;

    @Transactional
    public Usuario registrar(RegisterRequestDTO registerRequestDTO) {
        String encodedPassword = securityConfig.passwordEncoder().encode(registerRequestDTO.password());

        Usuario newUsuario = Usuario.builder()
                .login(registerRequestDTO.login())
                .password(encodedPassword)
                .roles(List.of(Role.builder().name(RoleName.valueOf("ROLE_ADMIN")).build()))
                .build();

        try {
            return usuarioRepository.save(newUsuario);
        } catch (Exception exception) {
            throw new ServiceException("Falha ao registrar usuário");
        }

    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.login(), loginRequestDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateAccessToken((Usuario) auth.getPrincipal());
        return new LoginResponseDTO(token);
    }

}
