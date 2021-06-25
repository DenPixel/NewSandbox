package com.denpixel.akvelon_task.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:openweathermap.properties")
public class RestConfiguration {

    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public RestConfiguration(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.build();
    }
}


