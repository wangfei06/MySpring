package cn.spring.beans;

public interface BeanFactory {
    /**
     * 根据Bean名称获取Bean
     * @param beanName Bean的名字
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 注册Bean定义信息
     * @param name 名称
     * @param bd BeanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition bd);

    /**
     * 注册Bean
     * @param beanName Bean名称
     * @param obj 实例对象
     */
    void registerBean(String beanName, Object obj);

    /**
     * 判断是否包含Bean
     * @param beanName Bean名称
     * @return
     */
    boolean containsBean(String beanName);

    boolean isSingleton(String name);
    boolean isPrototype(String name);
    Class<?> getType(String name);

}
