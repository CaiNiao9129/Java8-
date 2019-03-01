package com.cduestc.java8.lambda;

import java.time.Year;
import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * Lambda 表达式的基础语法，Java8中引入了一个新的操作“->”
 * 该操作符称为箭头操作符或Lambda操作符，箭头操作符Lambda表达式拆分成俩部分
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式中所需执行的功能，即Lambda体
 * 
 * 语法格式一：无参数，无返回值
 * 			() -> System.out.println("hello everyone");
 * 
 * 语法格式二：有一个参数并且无返回值的方法
 * 			(x) -> System.out.println(x);
 * 
 * 语法格式三:若只有一个参数，小括号可以省略不写
 * 
 * 语法格式四：若有俩个以上的参数，有返回值，并且Lambda 体中有多条语句		
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口:");
			return Integer.compare(x, y);
		};
		补充：若Lambda体中只有一条语句，return和大括号都可以不写
				Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
				
 * 语法格式6：Lambda的参数列表中的数据类型可以根据上下文推断出数据类型，
 * 				"类型推断" 所以不需要声明
 */
public class LambdaTest {
	
	@Test
	public void test1(){
		int num = 0;//jdk 1.7之前 必须是声明为final，jdk1.8后不同声明，改为默认
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hello world!..."+num);
			}
		};
		runnable.run();
		System.out.println("****************************");
		Runnable runnable2 = () -> System.out.println("hello world!...."+num);
		runnable2.run();
	}
	
	@Test
	public void test2(){
		Consumer<String> consumer = (x) -> System.out.println(x);
		Consumer<String> consumer2 = x -> System.out.println(x);
		consumer.accept("hi guys");
		consumer2.accept("hi guys2");
	}
	
	@Test
	public void test3(){
		
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口:");
			return Integer.compare(x, y);
		};
		System.out.println(com.compare(1, 2));
	}
	
	@Test
	public void test4(){
		Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
		System.out.println(comparator.compare(1, 2));
	}
	
	@Test
	public void test5(){
		
		System.out.println(opteration(10, 20, (x,y) -> x+y));
	}
	public Integer opteration(Integer x,Integer y,MyFunction<Integer> mf){
		return mf.getSum(x, y);
	}
}
