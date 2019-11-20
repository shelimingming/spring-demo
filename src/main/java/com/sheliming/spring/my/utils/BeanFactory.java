package com.sheliming.spring.my.utils;

import java.util.List;

public class BeanFactory {
    private List<BeanDefined> beanDefinedList;

    public Object getBean(String beanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object instance = null;
        for (BeanDefined beanDefined:beanDefinedList) {
            if(beanDefined.getBeanId().equals(beanId)) {
                String classPath = beanDefined.getClassPath();
                Class<?> aClass = Class.forName(classPath);
                instance = aClass.newInstance();
                return instance;
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
