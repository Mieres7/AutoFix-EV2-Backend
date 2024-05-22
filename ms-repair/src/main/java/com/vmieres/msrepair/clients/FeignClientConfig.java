package com.vmieres.msrepair.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() { return Logger.Level.FULL; }
}
