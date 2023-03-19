package cn.spring.beans;

public interface BeanFactory {
    /**
     * 根据Bean名称获取Bean
     * @param beanName Bean的名字
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    Object getBean(String beanName) throws BeansException;

    void registerBeanDefinition(String name, BeanDefinition bd);

    void registerBean(String beanName, Object obj);

    boolean containsBean(String beanName);

    boolean isSingleton(String name);
    boolean isPrototype(String name);
    Class<?> getType(String name);

}
