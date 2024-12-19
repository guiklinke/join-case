package com.join.dtos;

import org.springframework.http.HttpStatus;

public record ErroDTO(
        HttpStatus httpStatus,
        String timestamp,
        String message
) {
}
