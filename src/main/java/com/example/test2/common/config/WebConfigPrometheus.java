package com.example.test2.common.config;

import com.example.test2.feature.interceptor.Interceptor;
import com.example.test2.feature.interceptor.MetricPublishData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfigPrometheus extends WebMvcConfigurerAdapter {
    @Autowired
    private Interceptor interceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }

    @Bean
    @Qualifier("metricPublish")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST)
    public MetricPublishData metricPublishDataBean() {
        return new MetricPublishData();
    }

}