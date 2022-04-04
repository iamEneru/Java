package com.java.exercise15;

public class NumberPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome(-1221)); // should return true

		System.out.println(isPalindrome(707)); // should return true

		System.out.println(isPalindrome(11212)); // should return false because reverse is 21211 and that is not equal
													// to 11212.

	}

	public static boolean isPalindrome(int number) {
		int oldNum = number;
		int reversed = 0;
		int lastDigit;

		while (number != 0) {
			lastDigit = number % 10;
			reversed = reversed * 10 + lastDigit;
			number /= 10;
		}

		return oldNum == reversed;

	}

}