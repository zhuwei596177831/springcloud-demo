package com.zhuweiwei.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author zww
 * @date 2020-05-25 15:22
 * @description
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName(value = "dept")
public class DeptInfo {
    private String id;
    private String deptName;
    private String email;
}
