package com.zhuweiwei.eurekaconsumer.configuration;

import com.zhuweiwei.irule.RandomRuleConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author zww
 * @date 2020-05-29 18:59
 * @description
 **/
@RibbonClients({
        @RibbonClient(name = "EUREKA-PROVIDER", configuration = {RandomRuleConfig.class})
})
public class RibbonClientConfiguration {
}
