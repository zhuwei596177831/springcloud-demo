package com.zhuweiwei.feign.controller;

import com.zhuweiwei.springcloud.feignclient.DeptClient;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-28 16:53
 * @description
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    DeptClient deptClient;

    @GetMapping("/list")
    public List<DeptInfo> list() {
        return deptClient.getDeptList();
    }

}
