package com.khanh.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Java8Features {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<>();
		strs.add("A");
		strs.add("B");
		strs.add("C");
		strs.add("D");
		strs.add("E");
		
		Stream<String> stream = strs.stream();
		stream.filter(item -> "A".equals(item));
		// Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
//		stream.filter(item -> "B".equals(item));
	}
}
