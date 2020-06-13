package com.zhuweiwei.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        /**
         * eureka-provider EUREKA-PROVIDER都可以
         */
        discoveryClient.getInstances("eureka-provider").stream().forEach(
                instance -> {
                    logger.info(instance.getHost());//127.0.0.1
                    logger.info(instance.getInstanceId());//127.0.0.1:8001:eureka-provider:V1.0 127.0.0.1:8002:eureka-provider:V1.0
                    logger.info(instance.getScheme());//http
                    logger.info(instance.getServiceId());//EUREKA-PROVIDER
                    logger.info(String.valueOf(instance.getPort()));//8001 8002
                    logger.info(instance.getUri().toString());// http://127.0.0.1:8001 http://127.0.0.1:8002
                    String response = restTemplate.getForEntity("http://" + instance.getServiceId() + "/eurekaProvider/deptInfoProvider/list", String.class).getBody();
//                    String response = restTemplate.getForEntity("http://127.0.0.1:8002/deptInfoProvider/list", String.class).getBody();
                    logger.info("响应内容：{}", response);
                }
        );
        return "成功";
    }

    @GetMapping("/list")
    @SuppressWarnings(value = "unchecked")
    public List<DeptInfo> list() {
        /**
         * eureka-provider EUREKA-PROVIDER都可以
         */
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("EUREKA-PROVIDER", false);
        instances.forEach(i -> {
            System.out.println(i.getAppName());//EUREKA-PROVIDER
            System.out.println(i.getId());//127.0.0.1:8001:eureka-provider:V1.0
            System.out.println(i.getInstanceId());//127.0.0.1:8001:eureka-provider:V1.0
            System.out.println(i.getPort());//8001
            System.out.println(i.getHostName());//127.0.0.1
        });
        int i = ThreadLocalRandom.current().nextInt(instances.size());
        logger.info("随机数：{}", i);
        InstanceInfo instanceInfo = instances.get(i);
        List<DeptInfo> data = restTemplate.getForObject("http://" + instanceInfo.getAppName() + "/eurekaProvider/deptInfoProvider/list", List.class);
        return data;
    }

    /**
     * 负载均衡策略测试
     *
     * @return
     */
    @GetMapping("/ribbonTest")
    @SuppressWarnings(value = "unchecked")
    public List<DeptInfo> ribbonTest() {
        List<DeptInfo> data = restTemplate.getForObject("http://eureka-provider/eurekaProvider/deptInfoProvider/list", List.class);
        return data;
    }

}
