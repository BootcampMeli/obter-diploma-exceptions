package com.digitalhouse.obtenerdiploma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleConflict(MethodArgumentNotValidException ex, HttpServletRequest httpServletRequest){
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        List<ErrorDetail> errorDetails = fieldErrorList
                .stream()
                .map(fe -> new ErrorDetail(fe.getDefaultMessage(), fe.getField(), fe.getRejectedValue().toString()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorDetails);
    }

}