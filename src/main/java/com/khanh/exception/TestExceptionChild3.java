package com.khanh.exception;

/**
 * Example in case subclass overridden method declares same exception
 * 
 * @author DELL
 *
 */
public class TestExceptionChild3 extends Parent1 {
	void msg() throws ArithmeticException {
		System.out.println("child method");
	}

	public static void main(String args[]) {
		Parent1 p = new TestExceptionChild3();

		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}
