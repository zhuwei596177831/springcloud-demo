package com.zhuweiwei.feign.irule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author zww
 * @date 2020-05-28 17:35
 * @description
 */
public class RandomRuleConfig {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
