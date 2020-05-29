package com.zhuweiwei.eurekaconsumer.irule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author zww
 * @date 2020-05-28 11:01
 * @description
 */
public class RibbonConfig {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
