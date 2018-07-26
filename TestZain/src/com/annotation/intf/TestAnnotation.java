/*
 * @(#)TestAnnotation.java
 * Author : zixian.luo001
 * Created Date: 2017年9月21日 
 */
package com.annotation.intf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title 测试注解 
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 2017年9月21日 zixian.luo001 create file<br>
 * Id:TestAnnotation.java,v1.0 2017年9月21日 下午5:36:40
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestAnnotation {
	public boolean showTime() default false;
}
