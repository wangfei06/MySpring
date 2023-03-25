package cn.spring.beans;

/**
 * Bean的构造方法参数
 */
public class ArgumentValue {
    //参数值
    private Object value;
    //参数类型
    private String type;
    //参数名称
    private String name;

    public ArgumentValue(String type, Object value) {
        this.value = value;
        this.type = type;
    }
    public ArgumentValue(String type, String name, Object value) {
        this.value = value;
        this.type = type;
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
