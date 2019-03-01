package com.cduestc.java8.lambda2;
/*
 * Java8内置四大核心函数式接口
 * 		Consumer<T>:消费型接口
 * 			void accept(T t);
 * Supplier<T>:供给型接口
 * 		T get();
 * 
 * Function<T,R>：函数型接口
 * 		R apply(T t);
 * 
 * Predicate<T>:断言型接口
 * 		boolean test(T t);
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class TestLambda {
	
//	消费型接口
	@Test
	public void test1(){
		enjoy(10000,(x) -> System.out.println("每次消费"+x+"yuan"));
	}
	public void enjoy(double money,Consumer<Double> consumer){
		consumer.accept(money);
	}
//	供给型接口
	@Test
	public void test2(){
		List<Integer> list = getNumList(10, () -> (int)(Math.random() * 100));
		for(Integer i:list){
			
			System.out.println(i);
		}
	}
	public List<Integer> getNumList(int num,Supplier<Integer> supplier){
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<num;i++){
			list.add(supplier.get());
		}
		return list;
	}
	
	//函数型接口
	@Test
	public void test3(){
		String str = strHandler("\t\t\t hi guys  ", (str1) -> str1.trim());
		System.out.println(str);
		String str2 = strHandler(str,(string) -> string.substring(0, 3));
		System.out.println(str2);
	}
	public String strHandler(String str,Function<String, String> function){
		return function.apply(str);
	}
	
	//断言型接口
	@Test
	public void test4(){
		List<String> list = Arrays.asList("hello",
										"boys",
										"and",
										"girls",
										"ok");
		
		List<String> list2 = filterStr(list, (s) -> s.length() >3);
		
		for(String string : list2){
			System.out.println(string);
		}
	}
	public List<String> filterStr(List<String> list,Predicate<String> predicate){
		List<String> sList = new ArrayList<String>();
		
		for(String str:list){
			if(predicate.test(str)){
				sList.add(str);
			}
		}
		return sList;
	}
}

