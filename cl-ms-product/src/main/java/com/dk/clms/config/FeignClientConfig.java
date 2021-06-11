package com.dk.clms.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class FeignClientConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
//            requestTemplate.header("Authorization", "Bearer " + context.getTokenString());
        };
    }
}
