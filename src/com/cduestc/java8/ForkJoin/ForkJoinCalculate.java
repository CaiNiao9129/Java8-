package com.cduestc.java8.ForkJoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12345678l;
	
	private long start;
	private long end;

	private static final long THRESHOLD = 10000;
	
	public ForkJoinCalculate(long start,long end) {
		this.start = start;
		this.end = end;
	}
	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		
		long length = end -start;
		
		if(length <= THRESHOLD){
			long  sum =0;
			for(long i =start;i<=end;i++){
				sum +=i;
			}
			
			return sum;
		}else {
			long middle = (start+end)/2;
			ForkJoinCalculate leftCalculate = new ForkJoinCalculate(start,middle);
			leftCalculate.fork();
			
			ForkJoinCalculate rightCalculate = new ForkJoinCalculate(middle+1,end);
			rightCalculate.fork();
			
			return leftCalculate.join()+rightCalculate.join();
		}
		
	}

}
