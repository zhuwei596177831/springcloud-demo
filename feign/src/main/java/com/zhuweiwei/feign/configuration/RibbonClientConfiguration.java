package com.zhuweiwei.feign.configuration;

import com.zhuweiwei.feign.irule.config.WeightedResponseTimeRuleConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author zww
 * @date 2020-05-29 18:56
 * @description
 **/
@RibbonClients({
//        @RibbonClient(value = "eureka-provider", configuration = RandomRuleConfig.class),
        @RibbonClient(value = "eureka-provider", configuration = WeightedResponseTimeRuleConfig.class)
})
public class RibbonClientConfiguration {
}
