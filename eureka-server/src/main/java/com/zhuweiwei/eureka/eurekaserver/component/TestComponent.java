package com.zhuweiwei.eureka.eurekaserver.component;

import com.zhuweiwei.eureka.eurekaserver.annotation.CustomComponent;
import lombok.Data;

/**
 * @author zww
 * @date 2020-06-18 13:45
 * @description
 */
@CustomComponent
@Data
public class TestComponent {
    private String name = "111";
}
