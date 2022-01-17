package com.naekang.orderdemo.util;

import com.naekang.orderdemo.exception.CustomException;
import com.naekang.orderdemo.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintLogAndThrowException {

    public static void printLogAndThrowCustomException(ErrorCode errorCode) {

        log.error(errorCode.getMessage());

        throw new CustomException(errorCode);
    }

    public static void printLogAndThrowException(Exception e) throws Exception {

        log.error(e.getMessage());

        throw new Exception(e.getMessage());
    }

}
