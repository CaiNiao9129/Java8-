package com.cduestc.java8.lambda2;
/*
 * 方法引用:若Lambda体中的内容方法已经实现了，我们可以用“方法引用”
 * 主要有三种语法格式
 * 	对象::实例方法名
 * 	类::静态方法名
 * 	类::实例方法名
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.cduestc.java8.Employee;

public class TestMethodRef {
	
	@Test
	public void test(){
		Consumer<String> consumer = (x) -> System.out.println(x);
		consumer.accept("what is fuck?");
		PrintStream pStream = System.out;
		Consumer<String> consumer2 = pStream::println;
		consumer2.accept("aaaaaa");
//		注意这里使用方法引用的前提是consumer的accept方法的返回值类型和参数类型
//		和println的类型是一致的
		
	}
	
	@Test
	public void test2(){
		Employee employee = new Employee("aobama",47,100000);
		Supplier<String> supplier = () -> employee.getName();
		System.out.println(supplier.get());
//		对象名::实例名
		Supplier<Integer> supplier2 = employee::getAge;
		System.out.println(supplier2.get());
	}
	
//	静态方法名
	@Test
	public void test3(){
		Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
		
		System.out.println(comparator.compare(11, 12));
		Comparator<Integer> comparator2 = Integer::compare;
		System.out.println(comparator2.compare(12, 10));
	}
//	类::实例方法名
	@Test
	public void test4(){
		BiPredicate<String, String> bPredicate = (x,y) -> x.equals(y);
		System.out.println(bPredicate.test("123","234"));
//		当x，y这俩个参数，第一个参数(x)本身的一个x.equals方法中实现另一个参数y的引用，
//		这里可以用参数类型名::方法名ClassName::method
		BiPredicate<String, String> bPredicate2 = String::equals;
		System.out.println(bPredicate2.test("123","123"));
	}
	
//	构造器引用
	@Test
	public void test5(){
		Supplier<Employee> supplier = () -> new Employee();
		System.out.println(supplier.get());
//		构造器引用(无参构造器)
		Supplier<Employee> supplier2 = Employee::new;
		System.out.println(supplier2.get());
//		有参构造器 一个参数
		Function<String, Employee> function = (x) -> new Employee(x);
		System.out.println(function.apply("delaiwen"));
		
		Function<String, Employee> function2 = Employee::new;
		System.out.println(function2.apply("盲僧"));
		
//		俩个参数构造器
		BiFunction<String, Integer, Employee> biFunction = (x,y) -> new Employee(x,y);
		System.out.println(biFunction.apply("酒桶", 22));
		BiFunction<String, Integer, Employee> biFunction2 = Employee::new;
		System.out.println(biFunction2.apply("马尔扎哈", 199));
		
	}
	
//	数组引用
	@Test
	public void test6(){
		Function<Integer, String[]> function = (x) -> new String[x];
		System.out.println(function.apply(10).length);
		
		Function<Integer, String[]> function2 = String[]::new;
		System.out.println(function2.apply(20).length);
		
		Function<Integer, List<Integer>> function3 = ArrayList::new;
		List<Integer> list =function3.apply(10);
		list.add(11);
		System.out.println(list.isEmpty());
		
	}
}
