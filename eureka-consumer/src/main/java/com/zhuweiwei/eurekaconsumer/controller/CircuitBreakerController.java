package com.zhuweiwei.eurekaconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhuweiwei.eurekaconsumer.exception.MyException;
import com.zhuweiwei.eurekaconsumer.service.ConsumerService;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zww
 * @date 2020-06-06 16:36
 * @description 服务熔断
 **/
@RestController
@RequestMapping("/circuitBreaker")
public class CircuitBreakerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/save")
    @HystrixCommand(fallbackMethod = "circuitBreakerFallbackMethod", ignoreExceptions = {MyException.class})
    public DeptInfo save(DeptInfo deptInfo) {
        if (deptInfo == null || StringUtils.isBlank(deptInfo.getDeptName()) || StringUtils.isBlank(deptInfo.getEmail())) {
            throw new MyException("请求参数不完整");
        }
        return consumerService.save(deptInfo);
    }

    private DeptInfo circuitBreakerFallbackMethod(DeptInfo deptInfo) {
        deptInfo = new DeptInfo();
        deptInfo.setId("651531321");
        deptInfo.setDeptName("服务被熔断");
        deptInfo.setEmail("11111111@qq.com");
        return deptInfo;
    }

}
