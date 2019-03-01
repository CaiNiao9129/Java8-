package com.cduestc.java8.TestOptional;

import java.util.Optional;

import org.junit.Test;

import com.cduestc.java8.Employee;
import com.cduestc.java8.Employee.Status;

public class TestOptional {
	/*
	 * Optional��������ĳ��÷���
	 * 	Optional.of(T t):����һ��Optionalʵ��
	 * 	Optional.empty()������һ���յ�Optionalʵ��
	 * 	Optional.ofNullable(T t):��t��Ϊnull,����Optionalʵ�������򴴽���ʵ��
	 * 	isPresent():�ж��Ƿ����ֵ
	 * 	orElse(T t):������ö������ֵ�����ظ�ֵ�����򷵻�t
	 * 	orElseGet(Supplier s):������øö������ֵ�����ظ�ֵ�����򷵻�s��ȡ��ֵ
	 * 	map(Function f):�����ֵ���䴦�������ش�����Optional,���򷵻�Optional.empty()
	 *  map(Function f):�����ֵ���䴦�������ش�����Optional,���򷵻�Optional.empty()
	 *  flatMap(Function mapper):��map���ƣ�Ҫ�󷵻�ֵȫ��Optional
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
		
		Employee employee = optional.orElse(new Employee("����",18,888.88,Status.FREE));
		
		System.out.println(employee);
		
		Employee employee2 = optional2.orElse(new Employee("����",18,888.88,Status.FREE));
		
		System.out.println(employee2);
		
		Employee employee3 = optional2.orElseGet(() -> new Employee("����",19,777.77,Status.VOCATION));
		
		System.out.println(employee3);
	}
	
	@Test
	public void test4(){
		Optional<Employee> optional = Optional.ofNullable(new Employee("����",20,666.66,Status.BUSY));
		
		Optional<String> str = optional.map((e) -> e.getName());
		
		System.out.println(str.get());
		
		Optional<String> stOptional = optional.flatMap((e) -> Optional.of(e.getName()));
//		 ���䣺Optional.of(e.getName()) �ǽ�������Ϣ��װ��һ��Optional
		System.out.println(stOptional.get());
	}
}
