package com.javajunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddtionTest {
	
	AdditionofTwo obj=new AdditionofTwo();
	
	@Test
	public void test()
	{
		
		
		int expectedVal=30;
		int actualVal=obj.addition(10, 20);
		
		assertEquals(expectedVal, actualVal);
		
		
	}
	
	
     
	
	
}
