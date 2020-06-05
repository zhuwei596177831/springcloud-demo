package com.zhuweiwei.springcloud.feignclient.callback;

import com.zhuweiwei.springcloud.entity.DeptInfo;
import com.zhuweiwei.springcloud.feignclient.DeptClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zww
 * @date 2020-06-05 16:38
 * @description
 */
@Component
public class DeptClientCallBack implements DeptClient {
    @Override
    public List<DeptInfo> getDeptList() {
        System.out.println(".........");
        return new ArrayList<>();
    }
}
