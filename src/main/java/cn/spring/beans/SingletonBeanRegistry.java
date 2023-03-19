package cn.spring.beans;

/**
 * 通过定义接口的形式，保证单例模式的规范性
 */
public interface SingletonBeanRegistry {
    /**
     * 注册单例Bean
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 根据Bean名称获取Bean实例
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 判断是否存在Bean
     * @param beanName
     * @return
     */
    boolean containsSingleton(String beanName);

    /**
     * 获取Bean的名称数组
     * @return
     */
    String[] getSingletonNames();
}
