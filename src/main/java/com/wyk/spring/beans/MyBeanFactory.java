package com.wyk.spring.beans;

/**
 * @Author: wyk
 * @Description:  单例工厂的顶级实现
 * @Date: Create in 2019/4/10 20:56
 * @Modified By:
 */
public interface MyBeanFactory {

    Object getBean(String beanName);

}
