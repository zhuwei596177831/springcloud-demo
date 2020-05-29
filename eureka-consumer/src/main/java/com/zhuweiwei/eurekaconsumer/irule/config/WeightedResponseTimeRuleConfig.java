package com.zhuweiwei.eurekaconsumer.irule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;

/**
 * @author zww
 * @date 2020-05-28 18:07
 * @description
 */
public class WeightedResponseTimeRuleConfig {
    @Bean
    public IRule iRule() {
        return new WeightedResponseTimeRule();
    }
}
