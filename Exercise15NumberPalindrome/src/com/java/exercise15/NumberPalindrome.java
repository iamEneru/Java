package com.java.exercise15;

public class NumberPalindrome {
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