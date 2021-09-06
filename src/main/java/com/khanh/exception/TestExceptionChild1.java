package com.khanh.exception;

/**
 * Exception Handling with Method Overriding in Java 
 * Rule 2: If the superclass
 * method does not declare an exception, subclass overridden method cannot
 * declare the checked exception but can declare unchecked exception.
 * 
 * @author DELL
 *
 */
public class TestExceptionChild1 extends Parent {
	public void msg() throws ArithmeticException {
		System.out.println("child method");
	}

	public static void main(String args[]) {
		Parent p = new TestExceptionChild1();
		p.msg();
	}
}
