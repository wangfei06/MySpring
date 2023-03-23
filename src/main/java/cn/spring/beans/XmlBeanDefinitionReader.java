package cn.spring.beans;

import cn.spring.core.Resource;
import org.dom4j.Element;

import java.util.List;

public class XmlBeanDefinitionReader {
    private final BeanFactory bf;

    public XmlBeanDefinitionReader(BeanFactory bf) {
        this.bf = bf;
    }

    /**
     * 根据从XML中获取的Bean配置资源，注册Bean，将BeanDefinition注册到列表中
     * @param res Bean定义信息
     */
    public void loadBeanDefinitions(Resource res) {
        while (res.hasNext()) {
            Element element = (Element)res.next();
            String beanID=element.attributeValue("id");
            String beanClassName=element.attributeValue("class");

            BeanDefinition beanDefinition=new BeanDefinition(beanID,beanClassName);

            //获取配置文件中的property属性
            List<Element> propertyElements = element.elements("property");
            PropertyValues PVS = new PropertyValues();
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                PVS.addPropertyValue(new PropertyValue(pType, pName, pValue));
            }
            beanDefinition.setPropertyValues(PVS);

            //获取配置文件中的构造方法参数
            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues AVS = new ArgumentValues();
            for (Element e : constructorElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                AVS.addArgumentValue(new ArgumentValue(pType,pName,pValue));
            }
            beanDefinition.setConstructorArgumentValues(AVS);

            //注册BeanDefinition，获取到创建Bean的依赖信息
            this.bf.registerBeanDefinition(beanID,beanDefinition);
        }

    }
}
