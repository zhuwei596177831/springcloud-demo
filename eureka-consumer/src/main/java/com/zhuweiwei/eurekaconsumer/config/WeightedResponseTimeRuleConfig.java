package com.zhuweiwei.eurekaconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.zhuweiwei.eurekaconsumer.annotation.RibbonAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
