package com.zhuweiwei.eurekaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuweiwei.eurekaconsumer.annotation.RibbonAnnotation;
import com.zhuweiwei.eurekaconsumer.config.RibbonProviderAnnotationConfig;
import com.zhuweiwei.eurekaconsumer.config.YmlTestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient(name = "eureka-provider", configuration = {RibbonProviderAnnotationConfig.class})
})
@ComponentScan(basePackages = {"com.zhuweiwei"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RibbonAnnotation.class})
})
public class EurekaConsumerApplication {

    public static void main(String[] args) throws JsonProcessingException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(EurekaConsumerApplication.class, args);
        YmlTestConfig ymlTestConfig = applicationContext.getBean(YmlTestConfig.class);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(ymlTestConfig));
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
