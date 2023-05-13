package cn.spring.beans.factory.support;

import cn.spring.beans.BeansException;
import cn.spring.beans.DefaultSingletonBeanRegistry;
import cn.spring.beans.factory.FactoryBean;

public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    protected Class<?> getTypeForFactoryBean(final FactoryBean<?> factoryBean) {
        return factoryBean.getObjectType();
    }

    protected Object getObjectFromFactoryBean(FactoryBean<?> factory, String beanName) {
        Object object = doGetObjectFromFactoryBean(factory, beanName);
        try {
            object = postProcessObjectFromFactoryBean(object, beanName);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return object;
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean<?> factory, final String beanName) {

        Object object = null;
        try {
            object = factory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    protected Object postProcessObjectFromFactoryBean(Object object, String beanName) throws BeansException {
        return object;
    }

    protected FactoryBean<?> getFactoryBean(String beanName, Object beanInstance) throws BeansException {
        if (!(beanInstance instanceof FactoryBean)) {
            throw new BeansException(
                    "Bean instance of type [" + beanInstance.getClass() + "] is not a FactoryBean");
        }
        return (FactoryBean<?>) beanInstance;
    }
}
