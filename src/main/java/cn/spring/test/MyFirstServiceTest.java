package cn.spring.test;

import cn.spring.beans.BeansException;
import cn.spring.context.ClassPathXmlApplicationContext;

public class MyFirstServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        MyFirstService myFirstService;
        try {
            myFirstService = (MyFirstService) ctx.getBean("myFirstService");
            myFirstService.sayHello();
            myFirstService.getBaseService().say();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
