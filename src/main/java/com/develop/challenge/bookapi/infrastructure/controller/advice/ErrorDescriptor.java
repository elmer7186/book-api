package com.develop.challenge.bookapi.infrastructure.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDescriptor {

    private Class<? extends Throwable> exceptionType;
    private HttpStatus httpStatus;

}
