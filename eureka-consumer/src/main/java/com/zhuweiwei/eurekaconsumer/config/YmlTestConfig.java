package com.zhuweiwei.eurekaconsumer.config;

import com.zhuweiwei.eurekaconsumer.entity.YmlTest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zww
 * @date 2020-05-28 14:51
 * @description
 */
@ConfigurationProperties(value = "yml-test")
@Component
public class YmlTestConfig {
    private YmlTest ymlTest;
    private boolean flag;
    private Date testDate;
    private Map<String, Object> objectMap;
    private Map<String, Object> objectMap1;
    private String[] arr;
    private String[] arr1;
    private List<String> testList;
    private List<String> testList1;
    private List<YmlTest> ymlTestList;
    private List<Map<String, Object>> mapList;

    public YmlTest getYmlTest() {
        return ymlTest;
    }

    public void setYmlTest(YmlTest ymlTest) {
        this.ymlTest = ymlTest;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Map<String, Object> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, Object> objectMap) {
        this.objectMap = objectMap;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public List<String> getTestList() {
        return testList;
    }

    public void setTestList(List<String> testList) {
        this.testList = testList;
    }

    public List<YmlTest> getYmlTestList() {
        return ymlTestList;
    }

    public void setYmlTestList(List<YmlTest> ymlTestList) {
        this.ymlTestList = ymlTestList;
    }

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    public Map<String, Object> getObjectMap1() {
        return objectMap1;
    }

    public void setObjectMap1(Map<String, Object> objectMap1) {
        this.objectMap1 = objectMap1;
    }

    public String[] getArr1() {
        return arr1;
    }

    public void setArr1(String[] arr1) {
        this.arr1 = arr1;
    }

    public List<String> getTestList1() {
        return testList1;
    }

    public void setTestList1(List<String> testList1) {
        this.testList1 = testList1;
    }

}
