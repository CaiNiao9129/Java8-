package com.cduestc.java8;

public class TestMyInterface2 implements MyInterface, MyFun {
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return MyFun.super.getName();
	}
}
