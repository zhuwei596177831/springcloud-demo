package com.zhuweiwei.eurekaconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.zhuweiwei.eurekaconsumer.annotation.RibbonAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
