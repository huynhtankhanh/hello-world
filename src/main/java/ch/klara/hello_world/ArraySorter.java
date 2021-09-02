package ch.klara.hello_world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySorter {
	public static void main(String[] args) {
		int[] squares = { 4, 25, 9, 36, 49 };
		List<Integer> list = new ArrayList<>();
		Arrays.stream(squares).forEach(s -> list.add(s));
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
	}
}
