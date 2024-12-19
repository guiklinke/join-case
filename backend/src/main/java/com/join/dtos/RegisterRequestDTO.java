package com.join.dtos;


import com.join.entities.RoleName;

public record RegisterRequestDTO(String login,
                                 String password
) {
}
