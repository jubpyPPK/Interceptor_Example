package com.example.test2.common.exception;

import com.example.test2.common.constans.ResultCode;
import com.example.test2.common.domain.GenericResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by napat on 11/9/2017 AD.
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpEntity systemError(){
        return new ResponseEntity<>(new GenericResponse(ResultCode.FAIL.get()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public HttpEntity NumberError(){
        return new ResponseEntity<>(new GenericResponse(ResultCode.NUMBER.get()), HttpStatus.OK);
    }

}
