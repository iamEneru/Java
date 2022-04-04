package com.java.exercise29;

public class Person {
	private String firstName;
	private String lastName;
	private int age;

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFullName() {
		if (lastName.isEmpty()) {
			return this.firstName;
		}

		if (firstName.isEmpty()) {
			return this.lastName;
		}

		return this.firstName + " " + this.lastName;
	}

	public boolean isTeen() {
		if (this.age > 12 && this.age < 20) {
			return true;
		}
		return false;
	}

	public int getAge() {
		return this.age;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			this.firstName = "";
		} else {
			this.firstName = firstName.trim();
		}
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			this.lastName = "";
		} else {
			this.lastName = lastName.trim();
		}
	}

	public void setAge(int age) {
		if (age < 0 || age > 100) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}
}
