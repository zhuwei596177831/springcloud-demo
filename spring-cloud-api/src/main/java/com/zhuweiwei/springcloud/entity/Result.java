package com.zhuweiwei.springcloud.entity;

import java.io.Serializable;

/**
 * @author zww
 * @date 2020-06-06 17:26
 * @description
 **/
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -1962326443405322008L;
    private String errMsg;
    private Integer errStat;
    private T data;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrStat() {
        return errStat;
    }

    public void setErrStat(Integer errStat) {
        this.errStat = errStat;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public Result(String errMsg, Integer errStat, T data) {
        this.errMsg = errMsg;
        this.errStat = errStat;
        this.data = data;
    }
}
