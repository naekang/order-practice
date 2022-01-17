package com.naekang.orderdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "Username not found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "Email not found"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),

    INVALID_JSON_FORMAT(HttpStatus.BAD_REQUEST, "Invalid json format"),

    UNEXPECTED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");

    private final HttpStatus httpStatus;

    private final String message;

}