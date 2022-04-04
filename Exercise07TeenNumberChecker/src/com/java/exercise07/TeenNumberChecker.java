package com.java.exercise07;

public class TeenNumberChecker {
	public static void main(String[] args) {
		System.out.println(hasTeen(9, 99, 19)); // should return true since 19 is in range 13 - 19

		System.out.println(hasTeen(23, 15, 42)); // should return true since 15 is in range 13 - 19

		System.out.println(hasTeen(22, 23, 34)); // should return false since numbers 22, 23, 34 are not in range 13-19
	}

	public static boolean hasTeen(int age1, int age2, int age3) {
		return (isTeen(age1) || isTeen(age2) || isTeen(age3));
	}

	public static boolean isTeen(int age) {
		return (age >= 13 && age <= 19);
	}
}