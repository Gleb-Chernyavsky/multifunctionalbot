package com.chernyavskii.multifunctionalbot.config;

import com.chernyavskii.multifunctionalbot.service.CallbackHandleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CallbackHandleService callbackHandleService() {
        return new CallbackHandleService(restTemplate());
    }
}
