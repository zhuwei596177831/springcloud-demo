package com.zhuweiwei.eurekaprovider1.service;

import com.zhuweiwei.springcloud.entity.DeptInfo;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-25 15:25
 * @description
 */
public interface DeptInfoService {
    List<DeptInfo> list();

    Integer add(DeptInfo deptInfo);
}
