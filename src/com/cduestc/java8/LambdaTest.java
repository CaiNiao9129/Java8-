package com.cduestc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class LambdaTest {
	public static void main(String[] args) {
		System.out.println("1111");
	}
	
	@Test
	public void test1(){
		Comparator<Integer> com =new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		};
		TreeSet<Integer> tSet= new TreeSet<Integer>(com);
	}
//	Lambda
	@Test
	public void test2(){
		Comparator<Integer> com = (x,y) ->Integer.compare(x, y);
		TreeSet<Integer> tSet=new TreeSet<Integer>(com);
	}
	
	
	List<Employee> list = Arrays.asList(new Employee("roy",10,10000),
			new Employee("Jack",11,9000),
			new Employee("Marry",47,38000),
			new Employee("Marry1",39,28000),
			new Employee("Marry2",14,18000)
	);
	
//	普通方法一
	//获取当前公司中员工年龄大于35的员工信息
	public List<Employee> filterEmployees(List<Employee> list,MyPredicate<Employee> mPredicate){
		List<Employee> employees = new ArrayList<Employee>();
		
		for(Employee employee : list){
			if(mPredicate.test(employee)){
				employees.add(employee);
			}
		}
		
		return employees;
	}
	
	
	@Test
	public void test4(){
		List<Employee> employees = filterEmployees(list,(e) -> e.getAge() >=35);
		employees.forEach(System.out::println);
	}
//	优化4
	@Test
	public void test5(){
		list.stream()
			.filter((e) -> e.getAge() >=35)
			.forEach(System.out::println);
	}
}
