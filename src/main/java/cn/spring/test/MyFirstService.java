package cn.spring.test;

import cn.spring.beans.factory.annotation.Autowired;

public class MyFirstService {
    private String name;
    private int level;
    private String property1;
    private String property2;

    @Autowired
    private BaseService baseService;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public MyFirstService() {
    }

    public MyFirstService(String name, int level) {
        this.name = name;
        this.level = level;
        System.out.println(this.name + "," + this.level);
    }

    public void sayHello() {
        System.out.println(this.property1 + "," + this.property2);
    }
}
