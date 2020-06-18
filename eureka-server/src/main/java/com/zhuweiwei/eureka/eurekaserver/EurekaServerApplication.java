package com.zhuweiwei.eureka.eurekaserver;

import com.zhuweiwei.eureka.eurekaserver.component.TestComponent;
import com.zhuweiwei.eureka.eurekaserver.customizeComponent.CustomizeBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(EurekaServerApplication.class, args);
        System.out.println(applicationContext.getBean(TestComponent.class));
        CustomizeBean customizeBean = applicationContext.getBean(CustomizeBean.class);
        customizeBean.print();
    }

}
