package com.cduestc.java8.stream;
/*
 * һ��Stream��������������
 * 		1:������
 * 
 * 		2:�м����
 * 
 * 		3��
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
//		����ͨ��Collectionϵ�м����ṩ��stream()��parallelStream
		List<String> list = new ArrayList<String>();
		Stream<String> stream1 = list.stream();
		
//		ͨ��Arrays�еľ�̬����stream()��ȡ������
		Employee[] employees = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(employees);
		
//		ͨ��stream���еľ�̬����OF()
		Stream<String> stream3 = Stream.of("aa","bb","vv");
		
//		����������  ͨ������
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		stream4.limit(10).forEach(System.out::println);
//		����
		Stream.generate(() ->Math.random())
				.limit(5)
				.forEach(System.out::println);
	}
}
