package cn.spring.beans.factory.config;


import cn.spring.beans.BeanFactory;
import cn.spring.beans.BeansException;

public interface BeanFactoryPostProcessor {
	void postProcessBeanFactory(BeanFactory beanFactory) throws BeansException;
}
