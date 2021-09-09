package com.khanh.pattern;

public class SingletonPattern {
	private static SingletonPattern instance;

	public static SingletonPattern getInstance() {
		SingletonPattern result = instance;
		if (result != null) {
			return result;
		}

		synchronized (SingletonPattern.class) {
			if (instance == null) {
				return new SingletonPattern();
			}
			return instance;
		}
	}
}
