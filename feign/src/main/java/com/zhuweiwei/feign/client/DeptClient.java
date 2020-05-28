package com.zhuweiwei.feign.client;

import com.zhuweiwei.feign.configuration.irule.RandomRuleConfiguration;
import com.zhuweiwei.feign.configuration.irule.WeightedResponseTimeRuleConfig;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-28 16:49
 * @description
 */
//@FeignClient(name = "eureka-provider", configuration = {RandomRuleConfiguration.class})
@FeignClient(name = "eureka-provider", configuration = {WeightedResponseTimeRuleConfig.class})
public interface DeptClient {

    @GetMapping("/eurekaProvider/deptInfoProvider/list")
    List<DeptInfo> getDeptList();

}
