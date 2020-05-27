package com.zhuweiwei.eureka.eurekaprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuweiwei.eureka.eurekaprovider.mapper.DeptInfoMapper;
import com.zhuweiwei.eureka.eurekaprovider.service.DeptInfoService;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zww
 * @date 2020-05-25 15:26
 * @description
 */
@Service
public class DeptInfoServiceImpl implements DeptInfoService {

    @Autowired
    DeptInfoMapper deptInfoMapper;

    @Override
    public List<DeptInfo> list() {
        return deptInfoMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public Integer add(DeptInfo deptInfo) {
        return deptInfoMapper.insert(deptInfo);
    }
}
