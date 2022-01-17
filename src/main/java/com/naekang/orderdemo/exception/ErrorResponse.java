package com.naekang.orderdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();

    private final int status;

    private final String error;

    private final String message;

    private final String path;

    public static ResponseEntity<ErrorResponse> getResponseEntity(ErrorCode errorCode, String path) {
        new DefaultErrorAttributes();
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(new ErrorResponse(
                        errorCode.getHttpStatus().value(),
                        errorCode.name(),
                        errorCode.getMessage(),
                        path
                    )
                );
    }

}