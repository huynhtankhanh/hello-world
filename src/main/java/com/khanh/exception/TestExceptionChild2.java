package com.khanh.exception;

class Parent1 {
	void msg() throws ArithmeticException {
		System.out.println("parent method");
	}
}

/**
 * If the superclass method declares an exception Rule 1: If the superclass
 * method declares an exception, subclass overridden method can declare the same
 * subclass exception or no exception but cannot declare parent exception.
 * 
 * @author DELL
 *
 */
public class TestExceptionChild2 extends Parent1 {
//	void msg() throws Exception { // compile error 
//		System.out.println("child method");
//	}

	public static void main(String args[]) {
		Parent1 p = new TestExceptionChild2();

		try {
			p.msg();
		} catch (Exception e) {
		}

	}
}
