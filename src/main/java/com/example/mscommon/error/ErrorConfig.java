package com.example.mscommon.error;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ErrorConfig {

    //@Value("${app.sub-domain}")
    private String subDomain;
    private String boundedContext;
    private String microservice;

    @Bean
    public ErrorAdvice errorAdvice() {
        return new ErrorAdvice();
    }

    public String getSubDomain() {
        return this.subDomain;
    }

    public void setSubDomain(final String subDomainParam) {
        this.subDomain = subDomainParam;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public void setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
    }

    public ErrorObj buildBaseErrorObj() {
        return new ErrorObj().setSubDomain(this.subDomain)
                             .setBoundedContext(this.boundedContext)
                             .setMicroservice(this.microservice);
    }


}
