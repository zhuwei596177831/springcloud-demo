package com.zhuweiwei.feign.configuration.irule;

import com.netflix.loadbalancer.*;
import com.zhuweiwei.feign.annotation.IRuleAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zww
 * @date 2020-05-28 17:35
 * @description
 */
public class RandomRuleConfiguration {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
