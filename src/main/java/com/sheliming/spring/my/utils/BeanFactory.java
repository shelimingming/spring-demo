package com.sheliming.spring.my.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {
    private List<BeanDefined> beanDefinedList;
    //保存单例对象
    private Map<String, Object> singletonObject = new HashMap<String, Object>();
    //后置处理对象
    private BeanPostProcessor beanPostProcessor;

    public BeanFactory(List<BeanDefined> beanDefinedList) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.beanDefinedList = beanDefinedList;
        for (BeanDefined beanDefined : beanDefinedList) {
            String scope = beanDefined.getScope();
            if ("singleton".equals(scope)) {
                String classPath = beanDefined.getClassPath();
                Class<?> aClass = Class.forName(classPath);
                Object instance = aClass.newInstance();

                isPostProcessor(instance, aClass);

                singletonObject.put(beanDefined.getBeanId(), instance);
            }
        }
    }

    private void isPostProcessor(Object instance, Class classFile) {
        Class interfaceArray[] = classFile.getInterfaces();
        if (interfaceArray == null) {
            return;
        }

        for (int i = 0; i < interfaceArray.length; i++) {
            Class interfaceType = interfaceArray[i];
            if (interfaceType == BeanPostProcessor.class) {//证明当前实例对象是后置处理器
                this.beanPostProcessor = (BeanPostProcessor) instance;
            }
        }
    }

    public Object getBean(String beanId) throws Exception {
        Object instance = null;
        Object proxyObj = null;//当前实例对象的代理监控对象
        for (BeanDefined beanDefined : beanDefinedList) {
            if (beanDefined.getBeanId().equals(beanId)) {
                //判断是不是单例对象
                if ("singleton".equals(beanDefined.getScope())) {
                    return singletonObject.get(beanId);
                }

                String classPath = beanDefined.getClassPath();
                Class<?> aClass = Class.forName(classPath);
                instance = aClass.newInstance();

                if (this.beanPostProcessor != null) {
                    proxyObj = this.beanPostProcessor.postProcessBeforeInitialization(instance, beanId);
                    //实例对象初始化。Spring依赖注入
                    proxyObj = this.beanPostProcessor.postProcessAfterInitialization(instance, beanId);
                    //此时返回proxyObj可能就是原始bean对象，也有可能就是代理对象
                    return proxyObj;
                } else {
                    return instance;
                }
            }
        }
        return instance;
    }

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }
}
