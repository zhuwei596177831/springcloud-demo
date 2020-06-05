package com.zhuweiwei.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    EurekaClient eurekaClient;
    @Autowired
    DiscoveryClient discoveryClient;

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
        ServiceInstance serviceInstance = instanceList.get(random.nextInt(instanceList.size()));
        String serviceId = serviceInstance.getServiceId();
        return restTemplate.getForObject("http://" + serviceId + "/eurekaProvider/deptInfoProvider/list", List.class);
    }

    private List<DeptInfo> deptFallbackMethod() {
        logger.info("。。。。。。。");
        return new ArrayList<>();
    }

}
