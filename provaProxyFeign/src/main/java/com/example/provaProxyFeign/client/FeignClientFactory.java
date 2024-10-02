package com.example.provaProxyFeign.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public <T> T createFeignClient(Class<T> feignClientClass, String serviceName) throws InstantiationException, IllegalAccessException {
        FeignClientFactoryBean factoryBean = applicationContext.getBean(FeignClientFactoryBean.class);

        // Set properties for the factory bean
        factoryBean.setUrl(getServiceUrl(serviceName));

        // Create and return the Feign client
        return (T) factoryBean.getType().newInstance();
    }

    private String getServiceUrl(String serviceName) {
        // Logic to retrieve the base URL for the service from properties or configuration
        return String.format("http://%s", serviceName); // Replace with your actual logic
    }
}