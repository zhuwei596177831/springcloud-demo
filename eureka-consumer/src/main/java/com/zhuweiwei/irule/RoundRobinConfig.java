package com.zhuweiwei.irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zww
 * @date 2020-05-28 18:36
 * @description 轮询策略配置类
 */
@Configuration
public class RoundRobinConfig {

    @Bean
    public IRule iRule() {
        return new RoundRobinRule();
    }

}
