package com.zhuweiwei.eurekaprovider1.controller;

import com.zhuweiwei.eurekaprovider1.service.DeptInfoService;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${server.port}")
    private String port;

    @Autowired
    DeptInfoService deptInfoService;

    @GetMapping("/list")
    public List<DeptInfo> list() {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId(port);
        List<DeptInfo> list = deptInfoService.list();
        list.add(deptInfo);
        return list;
    }

    @PostMapping("/add")
    public Integer add(@RequestBody DeptInfo deptInfo) {
        return deptInfoService.add(deptInfo);
    }

}
