package com.example.test2.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by napat on 10/4/2017 AD.
 */
@Configuration
public class RestTemplateConfig {

    private  int timeOut = 20000;
    private  int readTimeout = 20000;

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        HttpComponentsClientHttpRequestFactory httpComponetFactory = new HttpComponentsClientHttpRequestFactory();

        httpComponetFactory.setConnectTimeout(timeOut);
        httpComponetFactory.setReadTimeout(readTimeout);

        restTemplate.setRequestFactory(httpComponetFactory);

        return restTemplate;
    }



}
