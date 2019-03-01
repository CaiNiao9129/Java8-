package com.cduestc.java8.lambda2;
/*
 * ��������:��Lambda���е����ݷ����Ѿ�ʵ���ˣ����ǿ����á��������á�
 * ��Ҫ�������﷨��ʽ
 * 	����::ʵ��������
 * 	��::��̬������
 * 	��::ʵ��������
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
//		ע������ʹ�÷������õ�ǰ����consumer��accept�����ķ���ֵ���ͺͲ�������
//		��println��������һ�µ�
		
	}
	
	@Test
	public void test2(){
		Employee employee = new Employee("aobama",47,100000);
		Supplier<String> supplier = () -> employee.getName();
		System.out.println(supplier.get());
//		������::ʵ����
		Supplier<Integer> supplier2 = employee::getAge;
		System.out.println(supplier2.get());
	}
	
//	��̬������
	@Test
	public void test3(){
		Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
		
		System.out.println(comparator.compare(11, 12));
		Comparator<Integer> comparator2 = Integer::compare;
		System.out.println(comparator2.compare(12, 10));
	}
//	��::ʵ��������
	@Test
	public void test4(){
		BiPredicate<String, String> bPredicate = (x,y) -> x.equals(y);
		System.out.println(bPredicate.test("123","234"));
//		��x��y��������������һ������(x)�����һ��x.equals������ʵ����һ������y�����ã�
//		��������ò���������::������ClassName::method
		BiPredicate<String, String> bPredicate2 = String::equals;
		System.out.println(bPredicate2.test("123","123"));
	}
	
//	����������
	@Test
	public void test5(){
		Supplier<Employee> supplier = () -> new Employee();
		System.out.println(supplier.get());
//		����������(�޲ι�����)
		Supplier<Employee> supplier2 = Employee::new;
		System.out.println(supplier2.get());
//		�вι����� һ������
		Function<String, Employee> function = (x) -> new Employee(x);
		System.out.println(function.apply("delaiwen"));
		
		Function<String, Employee> function2 = Employee::new;
		System.out.println(function2.apply("äɮ"));
		
//		��������������
		BiFunction<String, Integer, Employee> biFunction = (x,y) -> new Employee(x,y);
		System.out.println(biFunction.apply("��Ͱ", 22));
		BiFunction<String, Integer, Employee> biFunction2 = Employee::new;
		System.out.println(biFunction2.apply("�������", 199));
		
	}
	
//	��������
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
