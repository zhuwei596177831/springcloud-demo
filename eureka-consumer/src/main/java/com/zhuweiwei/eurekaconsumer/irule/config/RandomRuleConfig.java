package com.zhuweiwei.eurekaconsumer.irule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author zww
 * @date 2020-05-28 11:05
 * @description
 */
public class RandomRuleConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

}
