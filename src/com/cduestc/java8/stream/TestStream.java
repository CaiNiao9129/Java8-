package com.cduestc.java8.stream;
/*
 * 一：Stream的三个操作步骤
 * 		1:创建流
 * 
 * 		2:中间操作
 * 
 * 		3：
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.cduestc.java8.Employee;

public class TestStream {
	@Test
	public void test1(){
//		可以通过Collection系列集合提供的stream()或parallelStream
		List<String> list = new ArrayList<String>();
		Stream<String> stream1 = list.stream();
		
//		通过Arrays中的静态方法stream()获取数组流
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);
		
//		通过stream类中的静态方法OF()
		Stream<String> stream3 = Stream.of("aa","bb","vv");
		
//		创建无限流  通过迭代
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		stream4.limit(10).forEach(System.out::println);
//		生成
		Stream.generate(() ->Math.random())
				.limit(5)
				.forEach(System.out::println);
	}
}
