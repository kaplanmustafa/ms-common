package com.example.mscommon.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ErrorAdvice.class);

    @Autowired
    private ErrorConfig errconfig;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return this.errconfig.buildBaseErrorObj().setMessage(exp.getMessage()).setErrorCode(10203);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        ErrorObj rootError = this.errconfig.buildBaseErrorObj().setMessage("Validation error").setErrorCode(12300);

        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(this.errconfig.buildBaseErrorObj().setMessage("" + objectErrorLoc).setErrorCode(12301));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(final Exception exp) {
        logger.error("[ErrorAdvice][handleException]-> *Error* : " + exp.getMessage(), exp);
        return this.errconfig.buildBaseErrorObj().setMessage(exp.getMessage()).setErrorCode(15000);
    }

}
