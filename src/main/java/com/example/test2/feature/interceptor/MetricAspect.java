package com.example.test2.feature.interceptor;

import com.example.test2.common.domain.GenericResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
public class MetricAspect {

    @Autowired
    private ApplicationContext applicationContext;

    @AfterReturning(pointcut = "@annotation(requestMapping)", returning = "result")
    public void controllerAfterReturning(JoinPoint joinPoint, RequestMapping requestMapping, Object result) {

        System.out.println("controllerAfterReturning");

        if(result instanceof HttpEntity){
            HttpEntity httpEntity = (HttpEntity) result;
            Object body = httpEntity.getBody();
            MetricPublishData metricPublishData = applicationContext.getBean(MetricPublishData.class);
            metricPublishData.setStatusCode(getStatusCode(body));
        }
    }

    private String getStatusCode(Object object) {
        String statusCode = "";
        if(object instanceof GenericResponse) {
            GenericResponse res = (GenericResponse) object;
            statusCode = String.valueOf(res.getStatus().getCode());
        }
        return statusCode;
    }

}
