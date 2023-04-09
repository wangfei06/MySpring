package cn.spring.context;


import cn.spring.beans.BeanDefinition;
import cn.spring.beans.BeansException;
import cn.spring.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import cn.spring.beans.factory.config.BeanFactoryPostProcessor;
import cn.spring.beans.factory.config.ConfigurableListableBeanFactory;
import cn.spring.beans.factory.support.DefaultListableBeanFactory;
import cn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import cn.spring.core.ClassPathXmlResource;
import cn.spring.core.Resource;

import java.util.ArrayList;
import java.util.List;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
	DefaultListableBeanFactory beanFactory;
	private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors =
			new ArrayList<BeanFactoryPostProcessor>();

	public ClassPathXmlApplicationContext(String fileName){
		this(fileName, true);
	}

	public ClassPathXmlApplicationContext(String fileName, boolean isRefresh){
		Resource res = new ClassPathXmlResource(fileName);
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
		reader.loadBeanDefinitions(res);

		this.beanFactory = bf;

		if (isRefresh) {
			try {
				refresh();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (BeansException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public
	void registerListeners() {
		ApplicationListener listener = new ApplicationListener();
		this.getApplicationEventPublisher().addApplicationListener(listener);

	}

	@Override
	public
	void initApplicationEventPublisher() {
		ApplicationEventPublisher aep = new SimpleApplicationEventPublisher();
		this.setApplicationEventPublisher(aep);
	}

	@Override
	public
	void postProcessBeanFactory(ConfigurableListableBeanFactory bf) {
	}

	@Override
	public
	void registerBeanPostProcessors(ConfigurableListableBeanFactory bf) {
		this.beanFactory.addBeanPostProcessor(new AutowiredAnnotationBeanPostProcessor());
	}

	@Override
	public
	void onRefresh() {
		this.beanFactory.refresh();
	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		return this.beanFactory;
	}

	@Override
	public void addApplicationListener(ApplicationListener listener) {
		this.getApplicationEventPublisher().addApplicationListener(listener);

	}

	@Override
	public
	void finishRefresh() {
		publishEvent(new ContextRefreshEvent("Context Refreshed..."));

	}

	@Override
	public void publishEvent(ApplicationEvent event) {
		this.getApplicationEventPublisher().publishEvent(event);

	}

	@Override
	public void registerBean(String beanName, Object obj) {

	}
}
