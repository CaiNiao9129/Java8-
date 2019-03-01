package com.cduestc.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.cduestc.java8.Employee;
import com.cduestc.java8.Employee.Status;

public class TestStreamAPI3 {
	List<Employee> employees = Arrays.asList(new Employee("roy",10,10000,Status.FREE),
			new Employee("Jack",11,9000,Status.BUSY),
			new Employee("Marry",47,38000,Status.VOCATION),
			new Employee("Marry1",39,28000,Status.VOCATION),
			new Employee("Marry2",14,18000,Status.BUSY),
			new Employee("Marry2",14,18000,Status.FREE)
	);
	
	/*
	 * 查找与匹配
	 * allMatch-检查是否匹配所有元素
	 * anyMatch-检查是否至少匹配一个元素
	 * noneMatch-检查是否没有匹配所有元素
	 * findFirst-返回第一个元素
	 * findAny-返回当前流中的任意元素
	 * count-返回流中元素的总个数
	 * max--返回流中的最大值
	 * min--返回流中的最小值
	 */
	@Test
	public void test1(){
		Boolean boolean1 = employees.stream()
									.allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(boolean1);
		
		Boolean boolean2 = employees.stream()
									.anyMatch((e) -> e.getStatus().equals(Status.FREE));
		System.out.println(boolean2);
		
		Boolean boolean3 = employees.stream()
									.noneMatch((e) -> e.getStatus().equals(Status.VOCATION));
		System.out.println(boolean3);
		
		Optional<Employee> optional = employees.stream()
										.sorted((e1,e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
										.findAny();
		System.out.println(optional.get());								
			
		Optional<Employee> optional2 = employees.stream()
												.filter((e) -> e.getStatus().equals(Status.FREE))
												.findAny();
		System.out.println(optional2.get());
	}
	
	@Test
	public void test2(){
		Long count = employees.stream()
								.count();
		System.out.println(count);
		Optional<Employee> optional	= employees.stream()
								.max((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(optional.get());
		
		Optional<Double> optional2 = employees.stream()
												.map(Employee::getSalary)
												.min(Double::compareTo);
//		解释：用map将employee的Salary属性映射出来，在Salary中进行比较
		System.out.println(optional2);
	}
}
