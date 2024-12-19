package com.join.exceptions;

import com.join.dtos.ErroDTO;
import com.join.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroDTO> notFoundException(NotFoundException exception) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return buildCustomErrorMessage(httpStatus, exception);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErroDTO> handleAllExceptions(Exception exception) {
//        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
//        return buildCustomErrorMessage(httpStatus, exception);
//    }

    public static ResponseEntity<ErroDTO> buildCustomErrorMessage(
            HttpStatus httpStatus,
            Exception exception
            ) {

        return ResponseEntity.status(httpStatus).body(
                new ErroDTO(
                        httpStatus,
                        DateUtils.instantToStringDetailed(Instant.now()),
                        exception.getMessage()
                )
        );
    }


}
