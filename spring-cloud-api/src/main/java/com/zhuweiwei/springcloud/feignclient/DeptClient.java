package com.zhuweiwei.springcloud.feignclient;

import com.zhuweiwei.springcloud.entity.DeptInfo;
import com.zhuweiwei.springcloud.feignclient.callback.DeptClientCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-28 16:49
 * @description
 */
@FeignClient(name = "eureka-provider", fallback = DeptClientCallBack.class)
public interface DeptClient {

    @GetMapping("/eurekaProvider/deptInfoProvider/list")
    List<DeptInfo> getDeptList();

}
