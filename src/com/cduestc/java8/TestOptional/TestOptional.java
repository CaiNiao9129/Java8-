package com.cduestc.java8.TestOptional;

import java.util.Optional;

import org.junit.Test;

import com.cduestc.java8.Employee;
import com.cduestc.java8.Employee.Status;

public class TestOptional {
	/*
	 * Optional：容器类的常用方法
	 * 	Optional.of(T t):创建一个Optional实例
	 * 	Optional.empty()：创建一个空的Optional实例
	 * 	Optional.ofNullable(T t):若t不为null,创建Optional实例，否则创建空实例
	 * 	isPresent():判断是否包含值
	 * 	orElse(T t):如果调用对象包含值，返回该值，否则返回t
	 * 	orElseGet(Supplier s):如果调用该对象包含值，返回该值，否则返回s获取的值
	 * 	map(Function f):如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
	 *  map(Function f):如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
	 *  flatMap(Function mapper):与map类似，要求返回值全是Optional
	 * 
	 */
	
	@Test
	public void test1(){
		Optional<Employee> optional = Optional.of(new Employee());
		
		Employee employee = optional.get();
		
		System.out.println(employee);
		
	}
	@Test
	public void test2(){
		Optional<Employee> optional = Optional.empty();
		System.out.println(optional.get());
	}
	
	@Test
	public void test3(){
		Optional<Employee> optional = Optional.ofNullable(new Employee());
		
//		if(optional.isPresent()){
//			
//			System.out.println(optional.get());
//		}
		
		Optional<Employee> optional2 = Optional.ofNullable(null);
//		System.out.println(optional2.get());
		
		Employee employee = optional.orElse(new Employee("张三",18,888.88,Status.FREE));
		
		System.out.println(employee);
		
		Employee employee2 = optional2.orElse(new Employee("张三",18,888.88,Status.FREE));
		
		System.out.println(employee2);
		
		Employee employee3 = optional2.orElseGet(() -> new Employee("李四",19,777.77,Status.VOCATION));
		
		System.out.println(employee3);
	}
	
	@Test
	public void test4(){
		Optional<Employee> optional = Optional.ofNullable(new Employee("王二",20,666.66,Status.BUSY));
		
		Optional<String> str = optional.map((e) -> e.getName());
		
		System.out.println(str.get());
		
		Optional<String> stOptional = optional.flatMap((e) -> Optional.of(e.getName()));
//		 补充：Optional.of(e.getName()) 是将名字信息封装成一个Optional
		System.out.println(stOptional.get());
	}
}
