package com.khanh.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class JavaCollection {
	public static void main(String[] args) {
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.add("Amit Sharma");
		queue.add("Vijay Raj");
		queue.add("JaiShankar");
		queue.add("Raj");
		System.out.println("head:" + queue.element());
		System.out.println("head:" + queue.peek());
		System.out.println("iterating the queue elements:");
		Iterator<String> itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		queue.remove();
		queue.poll();
		System.out.println("after removing two elements:");
		Iterator<String> itr2 = queue.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		// Creating Deque and adding elements
		System.out.println("=====Deque");
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("Gautam");
		deque.add("Karan");
		deque.add("Ajay");
		// Traversing elements
		for (String str : deque) {
			System.out.println(str);
		}

		System.out.println("=====Array to List");
		String[] array = { "Java", "Python", "PHP", "C++" };
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("=====List to Array");
		String[] langs = list.toArray(new String[list.size()]);
		System.out.println("Printing Array: " + Arrays.toString(langs));

		System.out.println("Treeset Example=====");
		TreeSet<String> set = new TreeSet<String>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		System.out.println("Intial Set: " + set);
		System.out.println("Head Set: " + set.headSet("C"));
		System.out.println("SubSet: " + set.subSet("A", "E"));
		System.out.println("TailSet: " + set.tailSet("C"));

	}
}
