package com.wyk.spring.context;

/**
 * @Author: wyk
 * @Description:    通过解耦的方式注入IOC顶级容器
 *                  后面将通过监听器去扫描实现该接口的类
 * @Date: Create in 2019/4/10 21:20
 * @Modified By:
 */
public interface MyApplicationContextAware  {

    void setApplicationContext(MyApplicationContext applicationContext);

}
