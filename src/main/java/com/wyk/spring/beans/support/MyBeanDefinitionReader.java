package com.wyk.spring.beans.support;

import com.wyk.spring.beans.config.MyBeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @Author: wyk
 * @Description:
 * @Date: Create in 2019/4/10 21:44
 * @Modified By:
 */
public class MyBeanDefinitionReader {

    private List<MyBeanDefinition> result = new ArrayList<MyBeanDefinition>();

    private List<String> registerBeanClasses = new ArrayList<String>();

    private String[] configLocations;

    private Properties config = new Properties();

    private final String SCANNER_PACKAGE = "scannerPackage";

    public MyBeanDefinitionReader(String[] configLocations) {
        this.configLocations = configLocations;

        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.configLocations[0].replace("classpath:", ""));

        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //
        doScanner(config.getProperty(SCANNER_PACKAGE));

    }

    public Properties getConfig(){
        return this.config;
    }

    private void doScanner(String scannerPackage) {

        URL url = this.getClass().getClassLoader().getResource("/" + scannerPackage.replaceAll("", ""));

    }

    /**
     * 封装Befinition对象
     * @return
     */
    public List<MyBeanDefinition> loadBeanDefinitions(){

        try {
            for (String className : registerBeanClasses){

                MyBeanDefinition beanDefinition = doCreateBeanfinition(className);
                if (null != beanDefinition){
                    result.add(beanDefinition);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }



        return Collections.EMPTY_LIST;
    }

    private MyBeanDefinition doCreateBeanfinition(String className) throws ClassNotFoundException {
        Class<?> beanClass = Class.forName(className);

        // 如果是一个接口, 用它的实现类作为beanClassName
        if (!beanClass.isInstance(beanClass)){
            MyBeanDefinition beanDefinition = new MyBeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryName(beanClass.getSimpleName());
            return beanDefinition;
        }
        return null;
    }

}
