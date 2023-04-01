package cn.spring.context;

import cn.spring.beans.BeansException;
import cn.spring.beans.ListableBeanFactory;
import cn.spring.beans.factory.config.BeanFactoryPostProcessor;
import cn.spring.beans.factory.config.ConfigurableBeanFactory;
import cn.spring.beans.factory.config.ConfigurableListableBeanFactory;
import cn.spring.core.env.Environment;
import cn.spring.core.env.EnvironmentCapable;

public interface ApplicationContext
		extends EnvironmentCapable, ListableBeanFactory, ConfigurableBeanFactory, ApplicationEventPublisher{
	String getApplicationName();
	long getStartupDate();
	ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;
	void setEnvironment(Environment environment);
	Environment getEnvironment();
	void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);
	void refresh() throws BeansException, IllegalStateException;
	void close();
	boolean isActive();

}
