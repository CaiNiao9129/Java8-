package com.cduestc.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.cduestc.java8.Employee;

public class TestStreamAPI2 {

	List<Employee> employees = Arrays.asList(new Employee("roy",10,10000),
			new Employee("Jack",11,9000),
			new Employee("Marry",47,38000),
			new Employee("Marry1",39,28000),
			new Employee("Marry2",14,18000),
			new Employee("Marry2",14,18000),
			new Employee("Marry2",14,18000)
	);
	
	//中间操作
	/*
	 * 筛选与切片
	 * 	filter-接收Lambda，从该中排除某些元素
	 * 	limit-截断流，使其元素不超过给定数量
	 * 	skip(n) -跳过元素，返回一个扔掉前n个元素的流，若流中元素不足n个《则
	 * 返回一个空流，与limit(n)互补
	 * distinct-筛选，通过流所生成元素的hashcoade()和equals()去除重复元素
	 */
	
//	内部迭代：迭代操作由Stream API完成
	@Test
	public void test1(){
		Stream<Employee> stream = employees.stream()
											.filter((e) -> {
												System.out.println("中间操作");
												return e.getAge() > 35;
											});
/*
		中间操作
		中间操作
		中间操作
		Employee [name=Marry, age=47, salary=38000.0]
		中间操作
		Employee [name=Marry1, age=39, salary=28000.0]
		中间操作
 */
//		终止操作
		stream.forEach(System.out::println);
//		补充：当没有终止操作时，光有中间操作是不会执行任何中间处理的，
//		在有终止void操作时的，一次性全部处理，这被称为“惰性求值”后者“延迟加载”
	}
	
//	limit:截断流
	@Test
	public void test2(){
		employees.stream()
					.filter((e) -> e.getSalary() > 8000)
					.limit(2)
					.forEach(System.out::println);
	//		Employee [name=roy, age=10, salary=10000.0]
	//		Employee [name=Jack, age=11, salary=9000.0]
					
	}
//	短路截断
	@Test
	public void test3(){
		employees.stream()
		.filter((e) -> {
			System.out.println("短路");
			return e.getSalary() >8000;
		})
		.limit(2)//当找到俩条数据后，就不执行查询了
		.forEach(System.out::println);
		//		Employee [name=roy, age=10, salary=10000.0]
		//		Employee [name=Jack, age=11, salary=9000.0]
		
	}
	
	@Test
	public void test4(){
		employees.stream()
				.filter((e) -> e.getSalary()>8000)
				.skip(2)
				.distinct()
	//这里去不掉重复是因为根据hashcode，employee类中没重写hashcode方法时，即使构造器生成俩个相同对象，哈希码值也不同，所以这里不能去重复
				.forEach(System.out::println);
	}
	
	@Test
	public void test5(){
		List<String> list = Arrays.asList("aa","bb","qq","rrr");
		
		list.stream()
			.map((str) -> str.toUpperCase())
			.forEach(System.out::println);
		
		System.out.println("..........................");
		
		employees.stream()
				.map(Employee::getName)
				.forEach(System.out::println);
		
		System.out.println("**************************");
		Stream<Character> sm = list.stream()
									.flatMap(TestStreamAPI2::filterCharacter);
//		flatMap是将一个个流中的元素加入新的流中
									//		a a b b q q r r r
		sm.forEach(System.out::println);
		
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<Character>();
		
		for(Character ch:str.toCharArray()){
			list.add(ch);
		}
		return list.stream();
	}
	
//	排序：sorted()自然排序(Comparable) sorted(Comparator com)-定制排序(Comparator)
	
	@Test
	public void test7(){
		employees.stream()
					.sorted((e1,e2) -> {
						if(e1.getAge().equals(e2.getAge())){
							return e1.getName().compareTo(e2.getName());
						}else {
							return -e1.getAge().compareTo(e2.getAge());
						}
					}).forEach(System.out::println);
	}
	
}
