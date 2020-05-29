package com.zhuweiwei.eurekaconsumer.configuration;

import com.zhuweiwei.eurekaconsumer.irule.config.WeightedResponseTimeRuleConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author zww
 * @date 2020-05-29 18:59
 * @description
 **/
@RibbonClients(value = {
//        @RibbonClient(name = "eureka-provider", configuration = {RoundRobinConfig.class})
//        @RibbonClient(name = "eureka-provider", configuration = {RandomRuleConfig.class})
        @RibbonClient(name = "eureka-provider", configuration = {WeightedResponseTimeRuleConfig.class})
})
public class RibbonClientConfiguration {
}
