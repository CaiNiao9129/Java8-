package com.cduestc.java8;
/*
 * 重复注解与类型注解
 */

import java.lang.reflect.Method;

import org.junit.Test;

public class TestAnnotation {
	
	@Test
	public void test1() throws Exception{
		Class<TestAnnotation> clazzClass = TestAnnotation.class;
		
		Method m1 = clazzClass.getMethod("show");
		MyAnnotation1[] mas = m1.getAnnotationsByType(MyAnnotation1.class);
		
		for(MyAnnotation1 myAnnotation1 : mas){
			System.out.println(myAnnotation1.value());
		}
	}	
	
	@MyAnnotation1("Hello")
	@MyAnnotation1("World")
	public void show(){
		
	}
}
