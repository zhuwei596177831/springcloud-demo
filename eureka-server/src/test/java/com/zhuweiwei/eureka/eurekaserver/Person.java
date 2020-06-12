package com.zhuweiwei.eureka.eurekaserver;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zww
 * @date 2020-06-12 9:35
 * @description
 */
@Data
public class Person {
    private String name;
    private Integer age;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
    private LocalDate localDate;
//    @JSONField(format = "HH:mm:ss")
    private LocalTime localTime;
}
