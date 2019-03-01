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
	
	//�м����
	/*
	 * ɸѡ����Ƭ
	 * 	filter-����Lambda���Ӹ����ų�ĳЩԪ��
	 * 	limit-�ض�����ʹ��Ԫ�ز�������������
	 * 	skip(n) -����Ԫ�أ�����һ���ӵ�ǰn��Ԫ�ص�����������Ԫ�ز���n������
	 * ����һ����������limit(n)����
	 * distinct-ɸѡ��ͨ����������Ԫ�ص�hashcoade()��equals()ȥ���ظ�Ԫ��
	 */
	
//	�ڲ�����������������Stream API���
	@Test
	public void test1(){
		Stream<Employee> stream = employees.stream()
											.filter((e) -> {
												System.out.println("�м����");
												return e.getAge() > 35;
											});
/*
		�м����
		�м����
		�м����
		Employee [name=Marry, age=47, salary=38000.0]
		�м����
		Employee [name=Marry1, age=39, salary=28000.0]
		�м����
 */
//		��ֹ����
		stream.forEach(System.out::println);
//		���䣺��û����ֹ����ʱ�������м�����ǲ���ִ���κ��м䴦��ģ�
//		������ֹvoid����ʱ�ģ�һ����ȫ�������ⱻ��Ϊ��������ֵ�����ߡ��ӳټ��ء�
	}
	
//	limit:�ض���
	@Test
	public void test2(){
		employees.stream()
					.filter((e) -> e.getSalary() > 8000)
					.limit(2)
					.forEach(System.out::println);
	//		Employee [name=roy, age=10, salary=10000.0]
	//		Employee [name=Jack, age=11, salary=9000.0]
					
	}
//	��·�ض�
	@Test
	public void test3(){
		employees.stream()
		.filter((e) -> {
			System.out.println("��·");
			return e.getSalary() >8000;
		})
		.limit(2)//���ҵ��������ݺ󣬾Ͳ�ִ�в�ѯ��
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
	//����ȥ�����ظ�����Ϊ����hashcode��employee����û��дhashcode����ʱ����ʹ����������������ͬ���󣬹�ϣ��ֵҲ��ͬ���������ﲻ��ȥ�ظ�
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
//		flatMap�ǽ�һ�������е�Ԫ�ؼ����µ�����
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
	
//	����sorted()��Ȼ����(Comparable) sorted(Comparator com)-��������(Comparator)
	
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
