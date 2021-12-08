package com.example.mscommon.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         message;
    private Integer        errorCode;
    private String         subDomain;
    private String         boundedContext;
    private String         microservice;

    public static void main(final String[] args) {
        ErrorObj setBoundedContextLoc = ErrorObj.build()
                                                .setMessage("validation error")
                                                .setErrorCode(1000)
                                                .setSubDomain("subdommain")
                                                .setMicroservice("ms")
                                                .setBoundedContext("bd");

    }

    public static ErrorObj build() {
        return new ErrorObj();
    }

    public ErrorObj addSubError(final ErrorObj subErrorParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(subErrorParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public ErrorObj setErrorCode(final Integer errorCodeParam) {
        this.errorCode = errorCodeParam;
        return this;
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public ErrorObj setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObj setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObj setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }


}
