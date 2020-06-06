package com.zhuweiwei.eurekaconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuweiwei.eurekaconsumer.component.YmlTestConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@MapperScan(basePackages = {"com.zhuweiwei.eurekaconsumer.mapper"})
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
