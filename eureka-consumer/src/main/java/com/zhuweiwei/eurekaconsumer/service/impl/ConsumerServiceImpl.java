package com.zhuweiwei.eurekaconsumer.service.impl;

import com.zhuweiwei.eurekaconsumer.mapper.ConsumerMapper;
import com.zhuweiwei.eurekaconsumer.service.ConsumerService;
import com.zhuweiwei.springcloud.entity.DeptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zww
 * @date 2020-06-06 16:34
 * @description
 **/
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;

    @Override
    @Transactional
    public DeptInfo save(DeptInfo deptInfo) {
        consumerMapper.insert(deptInfo);
        System.out.println(1 / 0);
        return deptInfo;
    }
}
