package com.zhuweiwei.eurekaconsumer.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zww
 * @date 2020-06-05 15:35
 * @description
 */
@RestController
@RequestMapping("/hystrixConsumer")
public class HystrixConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(HystrixConsumerController.class);

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    @Qualifier(value = "eurekaClient")
    EurekaClient eurekaClient;
    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 服务降级
     *
     * @return
     */
    @GetMapping("/list")
    @SuppressWarnings(value = "unchecked")
    @HystrixCommand(fallbackMethod = "deptFallbackMethod",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2")
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")
            })
    public List<DeptInfo> list() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("eureka-provider");
        Random random = new Random();
        int i = ThreadLocalRandom.current().nextInt(instanceList.size());
        ServiceInstance serviceInstance = instanceList.get(random.nextInt(instanceList.size()));
        String serviceId = serviceInstance.getServiceId();
        return restTemplate.getForObject("http://" + serviceId + "/eurekaProvider/deptInfoProvider/list", List.class);
    }

    private List<DeptInfo> deptFallbackMethod() {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId("651531321");
        deptInfo.setDeptName("服务被降级");
        deptInfo.setEmail("11111111@qq.com");
        List<DeptInfo> list = new ArrayList<>();
        list.add(deptInfo);
        return list;
    }

}
