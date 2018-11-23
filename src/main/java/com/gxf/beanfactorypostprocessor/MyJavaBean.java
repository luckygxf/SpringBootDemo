package com.gxf.beanfactorypostprocessor;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: <guanxiangfei@meituan.com>
 * @Description:
 * @Date: Created in : 2018/11/14 5:41 PM
 **/
@Component
public class MyJavaBean implements InitializingBean {
    private String desc;
    private String remark;

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    this.desc = "哈哈哈";
    System.out.println("MyJavaBean afterPropertiesSet: " + this);
  }

  @PostConstruct
  public void postConstruct(){
    System.out.println("MyJavaBean postConstruct: " + this);
  }

  @Override
  public String toString() {
    return "MyJavaBean{" +
        "desc='" + desc + '\'' +
        ", remark='" + remark + '\'' +
        '}';
  }
}
