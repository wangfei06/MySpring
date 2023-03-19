package cn.spring.test;

import cn.spring.beans.BeansException;
import cn.spring.context.ClassPathXmlApplicationContext;

public class MyFirstBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        MyFirstBean myFirstBean;
        try {
            myFirstBean = (MyFirstBean) ctx.getBean("myFirstBean");
            myFirstBean.sayHello();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

}
