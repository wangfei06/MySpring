package cn.spring.beans.factory.xml;

import cn.spring.beans.*;
import cn.spring.beans.factory.config.ConstructorArgumentValue;
import cn.spring.beans.factory.config.ConstructorArgumentValues;
import cn.spring.beans.factory.support.AbstractBeanFactory;
import cn.spring.beans.factory.support.DefaultListableBeanFactory;
import cn.spring.core.Resource;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 从XML中读取Bean配置信息，生成BeanDefinition
 */
public class XmlBeanDefinitionReader {
    private AbstractBeanFactory bf;

    public XmlBeanDefinitionReader(AbstractBeanFactory bf) {
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

            List<Element> constructorElements = element.elements("constructor-arg");
            ConstructorArgumentValues AVS = new ConstructorArgumentValues();
            for (Element e : constructorElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                AVS.addArgumentValue(new ConstructorArgumentValue(pType,pName,pValue));
            }
            beanDefinition.setConstructorArgumentValues(AVS);

            List<Element> propertyElements = element.elements("property");
            PropertyValues PVS = new PropertyValues();
            List<String> refs = new ArrayList<>();
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                String pRef = e.attributeValue("ref");
                String pV = "";
                boolean isRef = false;
                if (pValue != null && !pValue.equals("")) {
                    isRef = false;
                    pV = pValue;
                } else if (pRef != null && !pRef.equals("")) {
                    isRef = true;
                    pV = pRef;
                    refs.add(pRef);
                }
                PVS.addPropertyValue(new PropertyValue(pType, pName, pV, isRef));
            }

            beanDefinition.setPropertyValues(PVS);
            String[] refArray = refs.toArray(new String[0]);
            beanDefinition.setDependsOn(refArray);

            System.out.println(res.hasNext());
            this.bf.registerBeanDefinition(beanID,beanDefinition);
        }

    }
}
