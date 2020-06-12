package com.zhuweiwei.eureka.eurekaserver;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zww
 * @date 2020-06-12 9:34
 * @description
 */
public class TestJackSon {

    @Test
    public void test() throws JsonProcessingException {
        Person person = new Person();
        person.setAge(25);
        person.setDate(new Date());
        person.setLocalDate(LocalDate.now());
        person.setLocalDateTime(LocalDateTime.now());
        person.setName("朱伟伟");
        person.setLocalTime(LocalTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setTimeZone(TimeZone.getDefault());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        objectMapper.setDateFormat(dateFormat);

        LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalTimeSerializer localTimeSerializer = new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss"));
        DateSerializer dateSerializer = new DateSerializer(false, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, localDateTimeSerializer);
        javaTimeModule.addSerializer(localTimeSerializer);
        javaTimeModule.addSerializer(dateSerializer);
        objectMapper.registerModule(javaTimeModule);
        String value = objectMapper.writeValueAsString(person);
        System.out.println(value);
//        value = JSON.toJSONString(person);
//        System.out.println(value);
    }

}
