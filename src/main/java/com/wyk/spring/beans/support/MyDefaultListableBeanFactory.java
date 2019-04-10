package com.wyk.spring.beans.support;

import com.wyk.spring.beans.MyBeanFactory;
import com.wyk.spring.beans.config.MyBeanDefinition;
import com.wyk.spring.context.support.MyAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/4/10 21:05
 * @Modified By:
 */
public class MyDefaultListableBeanFactory extends MyAbstractApplicationContext {

    /** Map of bean definition objects, keyed by bean name. */
    public final Map<String, MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, MyBeanDefinition>(256);


}
