package com.wyk.spring.context;

import com.wyk.spring.beans.MyBeanFactory;
import com.wyk.spring.beans.MyBeanWrapper;
import com.wyk.spring.beans.config.MyBeanDefinition;
import com.wyk.spring.beans.support.MyBeanDefinitionReader;
import com.wyk.spring.beans.support.MyDefaultListableBeanFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/4/10 20:56
 * @Modified By:
 */
public class MyApplicationContext extends MyDefaultListableBeanFactory implements MyBeanFactory {


    private String[] configLocations;

    private MyBeanDefinitionReader beanDefinitionReader;

    public MyApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
    }



    public Object getBean(String beanName) {

        // 1.初始化
        instantiateBean(beanName, new MyBeanDefinition());

        // 2.注入属性
        populatetion(beanName, new MyBeanDefinition(), new MyBeanWrapper());

        return null;
    }

    private void populatetion(String beanName, MyBeanDefinition myBeanDefinition, MyBeanWrapper myBeanWrapper) {
        

    }

    private void instantiateBean(String beanName, MyBeanDefinition myBeanDefinition) {



    }

    @Override
    protected void refresh() {
        // 1.定位配置文件
        beanDefinitionReader = new MyBeanDefinitionReader(this.configLocations);
        List<MyBeanDefinition> beanDefinitions = beanDefinitionReader.loadBeanDefinitions();


        // 2.加载配置文件，扫描相关的类，将类信息封装到MyBeanDefinition
        doRegisterBeanDefinition(beanDefinitions);

        // 3.注册，把配置信息放到容器里面
        doAutowired();

        // 4.提前初始化非懒加载的单例bean



    }


    private void doAutowired() {
        for (Map.Entry<String, MyBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()){
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()){
                getBean(beanName);
            }
        }
    }

    private void doRegisterBeanDefinition(List<MyBeanDefinition> beanDefinitions) {

        for (MyBeanDefinition beanDefinition : beanDefinitions){
            super.beanDefinitionMap.put(beanDefinition.getFactoryName(), beanDefinition);
        }

    }
}
