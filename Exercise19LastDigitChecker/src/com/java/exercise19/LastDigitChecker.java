package com.java.exercise19;

public class LastDigitChecker {
	public static void main(String[] args) {
		System.out.println(hasSameLastDigit(41, 22, 71)); // should return true since 1 is the rightmost digit in
															// numbers 41 and 71

		System.out.println(hasSameLastDigit(23, 32, 42)); // should return true since 2 is the rightmost digit in
															// numbers 32 and 42

		System.out.println(hasSameLastDigit(9, 99, 999)); // should return false since 9 is not within the range of
															// 10-1000

	}

	public static boolean hasSameLastDigit(int num1, int num2, int num3) {
		if (!(num1 >= 10 && num1 <= 1000) || !(num2 >= 10 && num2 <= 1000) || !(num3 >= 10 && num3 <= 1000))
			return false;

		int lastDigit1 = num1 % 10;
		int lastDigit2 = num2 % 10;
		int lastDigit3 = num3 % 10;

		if (lastDigit1 == lastDigit2 || lastDigit1 == lastDigit3 || lastDigit2 == lastDigit1
				|| lastDigit2 == lastDigit3)
			return true;

		return false;
	}

	public static boolean isValid(int num) {
		if (num >= 10 && num <= 1000)
			return true;
		return false;
	}
}