package com.example.test2.feature.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by napat on 11/7/2017 AD.
 */
@Component
public class Interceptor extends HandlerInterceptorAdapter {

    @Autowired
    ApplicationContext applicationContext;

    @Value("${status.outtage}")
    private String[] outageStatus;

    @Value("${status.not.outtage}")
    private String[] nonOutageStatus;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handler");
        System.out.println(String.format("Request :: %s | Response :: %s | Handler :: %s ",request.toString(), response.toString(), handler.toString()));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        MetricPublishData metricPublishData = applicationContext.getBean(MetricPublishData.class);
        String statusCode = metricPublishData.getStatusCode();
        System.out.println("After Handler");
        System.out.println("GenericStatus Code :: "+statusCode);
        System.out.println("Expected GenericStatus :: "+getExpectLevel(statusCode));
    }

    private int getExpectLevel(String statusCode){
        int expectLevel = 0;
        if(Arrays.asList(outageStatus).indexOf(statusCode)>0){
            expectLevel = 1;
        }else if (Arrays.asList(nonOutageStatus).indexOf(statusCode)>0){
            expectLevel = 2;
        }
        return expectLevel;
    }
}
