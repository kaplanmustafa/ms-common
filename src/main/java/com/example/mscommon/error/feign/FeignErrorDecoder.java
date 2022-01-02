package com.example.mscommon.error.feign;

import com.example.mscommon.error.ErrorObj;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class FeignErrorDecoder implements ErrorDecoder {

    private static final Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);

    private ErrorDecoder.Default defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            InputStream inputStream = response.body().asInputStream();
            ObjectMapper mapper = new ObjectMapper();
            ErrorObj errorObj = mapper.readValue(inputStream, ErrorObj.class);
            return new MyFeignClientException(errorObj);
        } catch (Exception exp) {
            logger.error("[FeignErrorDecoder][decode]-> *Error* : " + exp.getMessage(), exp);
        }

        return defaultDecoder.decode(methodKey, response);
    }
}
