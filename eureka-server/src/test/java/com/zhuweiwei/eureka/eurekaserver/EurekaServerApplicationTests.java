package com.zhuweiwei.eureka.eurekaserver;

import com.zhuweiwei.eureka.eurekaserver.component.TestComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaServerApplicationTests {

    @Autowired
    TestComponent testComponent;

    @Test
    void contextLoads() {
        System.out.println(testComponent);
    }

}
