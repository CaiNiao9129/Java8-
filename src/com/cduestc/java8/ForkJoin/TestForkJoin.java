package com.cduestc.java8.ForkJoin;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {
	@Test
	public void test1(){
		Instant startinstant = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000L);
		
		long sum = pool.invoke(task);
		System.out.println(sum);
		Instant endInstant = Instant.now();
		
		System.out.println("耗费时间为:"+Duration.between(startinstant, endInstant).toMillis());
	}
	
	/*
	 * 并行流
	 * 
	 */
	@Test
	public void test2(){
		Instant startInstant = Instant.now();
		
		LongStream.rangeClosed(0, 1000000000L)
					.parallel()
					.reduce(0, Long::sum);
		
		Instant endInstant = Instant.now();
		System.out.println("耗费时间为:" + Duration.between(startInstant, endInstant).toMillis());
	}
}
