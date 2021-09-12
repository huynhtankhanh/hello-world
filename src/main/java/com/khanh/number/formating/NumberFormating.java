package com.khanh.number.formating;

public class NumberFormating {
	public static void main(String[] args) {
		// Refer to https://www.java67.com/2014/06/how-to-format-float-or-double-number-java-example.html
		
		String strDouble = String.format("%.2f", 1.23456);
		System.out.println(strDouble);

		// auto round up
		String strDouble1 = String.format("%.2f", 1.9999);
		System.out.println(strDouble1); // print 2.00
	}
}
