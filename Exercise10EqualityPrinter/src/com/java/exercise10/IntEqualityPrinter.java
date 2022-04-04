package com.java.exercise10;

public class IntEqualityPrinter {
	public static void main(String[] args) {
		printEqual(1, 1, 1); // should print text All numbers are equal

		printEqual(1, 1, 2); // should print text Neither all are equal or different

		printEqual(-1, -1, -1); // should print text Invalid Value

		printEqual(1, 2, 3); // should print text All numbers are different
	}

	public static void printEqual(int val1, int val2, int val3) {
		if (val1 < 0 || val2 < 0 || val3 < 0) {
			System.out.println("Invalid Value");
		} else if (val1 == val2 && val2 == val3 && val3 == val1) {
			System.out.println("All numbers are equal");
		} else if (val1 != val2 && val2 != val3 && val3 != val1) {
			System.out.println("All numbers are different");
		} else {
			System.out.println("Neither all are equal or different");
		}
	}
}