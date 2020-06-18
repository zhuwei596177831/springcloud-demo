package com.zhuweiwei.eureka.eurekaprovider.controller;

import com.zhuweiwei.eureka.eurekaprovider.service.DeptInfoService;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zww
 * @date 2020-06-16 10:36
 * @description
 */
@RestController
public class HandlerMethodArgumentResolverController {

    @Autowired
    DeptInfoService deptInfoService;

    @GetMapping("/argumentResolver")
    public List<DeptInfo> argumentResolver(String name, Integer age) {
        return deptInfoService.list();
    }

}
