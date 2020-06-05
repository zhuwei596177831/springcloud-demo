package com.zhuweiwei.feign.configuration;

import irule.RandomRuleConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author zww
 * @date 2020-05-29 18:56
 * @description
 **/
@RibbonClients({
        @RibbonClient(value = "EUREKA-PROVIDER", configuration = RandomRuleConfig.class),
})
public class RibbonClientConfiguration {
}
