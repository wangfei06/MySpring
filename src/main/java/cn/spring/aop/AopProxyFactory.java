package cn.spring.aop;

public interface AopProxyFactory {
    AopProxy createAopProxy(Object target);
}
