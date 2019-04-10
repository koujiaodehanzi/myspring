package com.wyk.spring.beans.config;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/4/10 21:09
 * @Modified By:
 */
public class MyBeanDefinition {

    private String beanClassName;

    private boolean isLazyInit = false;

    private String factoryName;




    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return isLazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        isLazyInit = lazyInit;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}
