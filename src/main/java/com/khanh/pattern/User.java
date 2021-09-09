package com.khanh.pattern;

public class User {
	private final String firstName;
	private final String lastName;
	private final int age;

	public User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public static class UserBuilder {
		private String firstName;
		private String lastName;
		private int age;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserBuilder withAge(int age) {
			this.age = age;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	public static void main(String[] args) {
		User u1 = new User.UserBuilder("Khanh", "Huynh").withAge(33).build();
		System.out.println(u1);
	}
}
