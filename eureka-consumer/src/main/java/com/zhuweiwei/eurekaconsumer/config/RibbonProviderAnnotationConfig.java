package com.zhuweiwei.eurekaconsumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.zhuweiwei.eurekaconsumer.annotation.RibbonAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zww
 * @date 2020-05-28 11:05
 * @description
 */
@Configuration
@RibbonAnnotation
public class RibbonProviderAnnotationConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
//        return new RetryRule();
    }

}
