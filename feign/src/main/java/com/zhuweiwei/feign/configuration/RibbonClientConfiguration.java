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
        /**
         * name：The name of the ribbon client
         * @FeignClient的name与此name保持一致 指定的负载均衡策略才会生效
         * see {@link org.springframework.cloud.openfeign.FeignClient}
         */
        @RibbonClient(name = "eureka-provider", configuration = RandomRuleConfig.class),
})
public class RibbonClientConfiguration {
}
