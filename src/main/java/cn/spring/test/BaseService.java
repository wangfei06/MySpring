package cn.spring.test;

public class BaseService {
    private String name;
    private String age;

    public void say(){
        System.out.println("I am BaseService");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
