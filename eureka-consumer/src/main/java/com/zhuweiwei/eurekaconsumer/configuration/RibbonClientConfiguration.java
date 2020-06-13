package com.zhuweiwei.eurekaconsumer.configuration;

import irule.RandomRuleConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author zww
 * @date 2020-05-29 18:59
 * @description
 **/
@RibbonClients({
        /**
         * name：ribbon client's name
         * restTemplate调用时serviceId与此name保持一致 指定的负载均衡策略才会生效
         */
        @RibbonClient(name = "eureka-provider", configuration = {RandomRuleConfig.class})
})
public class RibbonClientConfiguration {
}
