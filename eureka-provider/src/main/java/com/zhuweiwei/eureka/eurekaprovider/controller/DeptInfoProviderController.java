package com.zhuweiwei.eureka.eurekaprovider.controller;

import com.zhuweiwei.eureka.eurekaprovider.service.DeptInfoService;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-25 15:26
 * @description
 */
@RestController
@RequestMapping("/deptInfoProvider")
public class DeptInfoProviderController {

    @Autowired
    DeptInfoService deptInfoService;

    @GetMapping("/list")
    public List<DeptInfo> list() {
        System.out.println("list...........");
        return deptInfoService.list();
    }

    @PostMapping("/add")
    public Integer add(@RequestBody DeptInfo deptInfo) {
        return deptInfoService.add(deptInfo);
    }

}
