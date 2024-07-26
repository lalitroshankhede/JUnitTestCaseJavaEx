package com.javajunit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


// Note : Make sure you should have to write this @TestInstance annotation before creating the class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // here is @TestInstance annotation which is used to create the instance of Class as well as Every Method 
// Note : When you use PER_METHOD value it will creating instance for all methods and when you use PER_CLASS it will create only one instace for whole class

public class CalculationTest {

	Calculation obj ;

	
	@BeforeAll  // running before all methods but make sure it will calls only time at before of creating instance of class.
	// Note: make sure you have to use static keyword when using @BeforeAll annotation because this method calling before creating the instance of the class 
	
	// Note : if you use the @TestInstance annotation with PER_CLASS value it will not mandatory to use static keyword with the @BeforeAll annotation method
	
	/*
	public static void beforeAllInit()  
	{
		System.out.println("Running Before All Methods");
	}
	
	*/
	public void beforeAllInit()  
	{
		System.out.println("Running Before All Methods");
	}
	
	
	
	@BeforeEach  // which is invoked before each method called.
	public void init()
	{
		obj= new Calculation();
		System.out.println("Running Before Each Method...");
		
	}
	

	
	@AfterEach  // which is invoked after each method has been called.
	public void cleanUp()
	{
		System.out.println("Cleaning up....");
	}
	
	
@AfterAll // running after all methods having executed but make sure it will calls only at the end when executing all the methods. 
	// Note : use should have to use static keyword with this method also when using @AfterAll annotation
	public static void closePro()
	{
		System.out.println("Running After everything has been done");
	}
	

	
	@Test

	@DisplayName("Testing Add Method")
	// Note : @DisplayName annotation which is used to given specifically method Name with Annotation
	
	@RepeatedTest(3)
    // Note: here is if the method wants to be test repeatedly have to use @RepeatedTest annotation along with 
	// how many times to repeated gives the given integer value
	public void testAdd() {
		int expectedVal = 30;
		int actualVal = obj.add(10, 20);

		assertEquals(expectedVal, actualVal);
	}

	@Test
	@DisplayName("Testing Substrat Method")
	public void testSub() {


		Calculation object=new Calculation() ;
		int expectedVal = 10;
		int actualVal = obj.substract(20, 10);

		assertAll(
				
			 ()->assertEquals(expectedVal, actualVal),
			 ()->assertEquals(3,obj.substract(5,2) ),
			 ()->assertEquals(10,obj.substract(20,10) )
				
				);
		
	}

	@Test
	@DisplayName("Testing Division Method")
	public void testDivision() {

		int expVal=5;
		int actualVal=obj.divide(10, 2);
		
		assertEquals(expVal, actualVal);
		
		if (actualVal!=Integer.valueOf(expVal)) {
			
			assertThrows(ArithmeticException.class, () -> obj.divide(10, 2), "Can't Divide by Zero");
		}
		
		 
	}
	
	
	@Test
	@DisplayName("Test Distabled Method")
	@Disabled // this annotation used to disable the method i.e skipping to test this method 
	public void testDisabled()
	{
		fail("This test should be disabled");
		
	}
	
	
	/*
	 
	 @Tag("<name of tag>")
	 
	 Note : use of @Tag annotation on the any method which you would not to test 
	 but after using this annotation have to write name of the tag in JUnit Include Tag Panel
	  
	 
	 Here are some Conditional Execution Annotations perform on System
	 
	 @EnabledOnOs(OS.LINUX)
	 @EnabledOnJre(JRE.JAVA_11)
	 @EnabledIf
	 @EnabledIfSystemPropery
	 @EnabledIfEnvironmentVariable
	 
	 
	 */
	
	
	
	
}
