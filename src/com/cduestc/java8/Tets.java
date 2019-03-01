package com.cduestc.java8;

import org.junit.Test;

public class Tets {
	
	@Test
	public void ONE(){
		System.out.println("jJJJjj");
	}
	
	@Test
	public void LLL(){
		Employee employee = new Employee("z",12,1999);
		Employee employee2 = new Employee("z",12,1999);
		System.out.println(employee.hashCode());
		System.out.println(employee2.hashCode());
	}

}
