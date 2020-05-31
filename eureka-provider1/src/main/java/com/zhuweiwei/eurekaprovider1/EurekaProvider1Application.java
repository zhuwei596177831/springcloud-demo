package com.zhuweiwei.eurekaprovider1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.zhuweiwei.eurekaprovider1.mapper"})
public class EurekaProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider1Application.class, args);
    }

}
