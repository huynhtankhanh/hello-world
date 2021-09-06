package com.khanh.exception;

class Parent {

	// defining the method
	public void msg() {
		System.out.println("parent method");
	}
}

/**
 * Exception Handling with Method Overriding in Java
 * If the superclass method does not declare an exception
 * Rule 1: If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception.
 * @author DELL
 *
 */
public class TestExceptionChild extends Parent {
	// overriding the method in child class
	// gives compile time error
//	void msg() throws IOException {
//		System.out.println("TestExceptionChild");
//	}

	public static void main(String args[]) {
		Parent p = new TestExceptionChild();
		p.msg();
	}
}
