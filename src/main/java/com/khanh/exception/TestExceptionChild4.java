package com.khanh.exception;

/**
 * Example in case subclass overridden method declares subclass exception
 * 
 * @author DELL
 *
 */
public class TestExceptionChild4 extends Parent1 {
	void msg() throws ArrayIndexOutOfBoundsException {
		System.out.println("child method");
	}

	public static void main(String args[]) {
		Parent1 p = new TestExceptionChild4();
		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}
