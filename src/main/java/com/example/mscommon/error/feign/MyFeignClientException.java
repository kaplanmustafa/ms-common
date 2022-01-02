package com.example.mscommon.error.feign;

import com.example.mscommon.error.ErrorObj;

public class MyFeignClientException extends Exception {

    private ErrorObj errorObj;

    public MyFeignClientException() {
    }

    public MyFeignClientException(ErrorObj errorObj) {
        this.errorObj = errorObj;
    }

    public ErrorObj getErrorObj() {
        return errorObj;
    }

    public void setErrorObj(ErrorObj errorObj) {
        this.errorObj = errorObj;
    }
}
