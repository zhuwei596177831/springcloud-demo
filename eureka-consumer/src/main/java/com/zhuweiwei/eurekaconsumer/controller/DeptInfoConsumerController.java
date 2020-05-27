package com.zhuweiwei.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-25 15:51
 * @description
 */
@RestController
@RequestMapping("/deptInfoConsumer")
public class DeptInfoConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(DeptInfoConsumerController.class);

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    EurekaClient eurekaClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public void test() {
        discoveryClient.getInstances("eureka-provider").stream().forEach(
                instance -> {
                    logger.info(instance.getHost());//192.168.1.117
                    logger.info(instance.getInstanceId());//192.168.1.117:eureka-provider:8002:V1.0
                    logger.info(instance.getScheme());//http
                    logger.info(instance.getServiceId());//EUREKA-PROVIDER
                    logger.info(String.valueOf(instance.getPort()));//8002
                    logger.info(instance.getUri().toString());//http://192.168.1.117:8002
                    String response = restTemplate.getForEntity("http://" + instance.getServiceId() + "/deptInfoProvider/list", String.class).getBody();
//                    String response = restTemplate.getForEntity("http://127.0.0.1:8002/deptInfoProvider/list", String.class).getBody();
                    logger.info("响应内容：{}", response);
                }
        );
    }

    @GetMapping("/list")
    @SuppressWarnings(value = "unchecked")
    public List<DeptInfo> list() {
//        ServiceInstance serviceInstance = discoveryClient.getInstances("eureka-provider").stream().findFirst().get();
//        List<DeptInfo> data = restTemplate.getForObject("http://" + serviceInstance.getServiceId() + "/deptInfoProvider/list", List.class);

        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-provider", true);
//        logger.info(instanceInfo.getInstanceId());//192.168.1.117:eureka-provider:8002:V1.0
//        logger.info(instanceInfo.getHomePageUrl());//http://192.168.1.117:8002/
//        logger.info(instanceInfo.getId());//192.168.1.117:eureka-provider:8002:V1.0
//        logger.info(instanceInfo.getIPAddr());//192.168.1.117
//        logger.info(instanceInfo.getHostName());//192.168.1.117
//        logger.info(instanceInfo.getAppName());//EUREKA-PROVIDER
        List<DeptInfo> data = restTemplate.getForObject("http://" + instanceInfo.getAppName() + "/deptInfoProvider/list", List.class);
        return data;
    }

}
