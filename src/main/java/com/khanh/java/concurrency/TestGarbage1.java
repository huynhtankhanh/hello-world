package com.khanh.java.concurrency;

import java.io.IOException;

public class TestGarbage1 {
	public void finalize() {
		System.out.println("object is garbage collected");
	}

	public static void main(String args[]) throws IOException {
		TestGarbage1 s1 = new TestGarbage1();
		TestGarbage1 s2 = new TestGarbage1();
		
		s1.finalize();
		s2.finalize();
		
		s1 = null;
		s2 = null;
		System.gc();
		
		Runtime.getRuntime().exec("notepad");//will open a new notepad  
	}
}