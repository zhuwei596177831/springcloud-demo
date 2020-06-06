package com.zhuweiwei.eurekaconsumer.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuweiwei.springcloud.entity.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zww
 * @date 2020-06-06 17:09
 * @description
 **/
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {MyException.class})
    public void myException(MyException e, HttpServletResponse response) {
        responseJson(e.getMessage(), response);
    }

    private void responseJson(String message, HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            writer.write(objectMapper.writeValueAsString(new Result<>(message, 999, null)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
