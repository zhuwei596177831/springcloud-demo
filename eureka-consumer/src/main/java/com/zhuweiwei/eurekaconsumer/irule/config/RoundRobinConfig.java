package com.zhuweiwei.eurekaconsumer.irule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;

/**
 * @author zww
 * @date 2020-05-28 18:36
 * @description
 */
public class RoundRobinConfig {
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}
