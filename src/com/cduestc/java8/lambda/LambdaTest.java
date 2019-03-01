package com.cduestc.java8.lambda;

import java.time.Year;
import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * Lambda ���ʽ�Ļ����﷨��Java8��������һ���µĲ�����->��
 * �ò�������Ϊ��ͷ��������Lambda����������ͷ������Lambda���ʽ��ֳ�������
 * ��ࣺLambda���ʽ�Ĳ����б�
 * �ҲࣺLambda���ʽ������ִ�еĹ��ܣ���Lambda��
 * 
 * �﷨��ʽһ���޲������޷���ֵ
 * 			() -> System.out.println("hello everyone");
 * 
 * �﷨��ʽ������һ�����������޷���ֵ�ķ���
 * 			(x) -> System.out.println(x);
 * 
 * �﷨��ʽ��:��ֻ��һ��������С���ſ���ʡ�Բ�д
 * 
 * �﷨��ʽ�ģ������������ϵĲ������з���ֵ������Lambda �����ж������		
		Comparator<Integer> com = (x,y) -> {
			System.out.println("����ʽ�ӿ�:");
			return Integer.compare(x, y);
		};
		���䣺��Lambda����ֻ��һ����䣬return�ʹ����Ŷ����Բ�д
				Comparator<Integer> comparator = (x,y) -> Integer.compare(x, y);
				
 * �﷨��ʽ6��Lambda�Ĳ����б��е��������Ϳ��Ը����������ƶϳ��������ͣ�
 * 				"�����ƶ�" ���Բ���Ҫ����
 */
public class LambdaTest {
	
	@Test
	public void test1(){
		int num = 0;//jdk 1.7֮ǰ ����������Ϊfinal��jdk1.8��ͬ��������ΪĬ��
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
			System.out.println("����ʽ�ӿ�:");
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
