package com.java.exercise23;

public class NumberToWords {
	public static int getDigitCount(int number) {

		if (number == 0)
			return 1;

		if (number > 0) {
			int count = 0;
			while (number != 0) {

				number /= 10;
				count++;
			}
			return count;
		}

		return -1;
	}

	public static int reverse(int number) {
		int digit;
		int reverse = 0;

		while (number != 0) {
			digit = number % 10;
			reverse = reverse * 10 + digit;
			number /= 10;
		}

		return reverse;
	}

	public static void numberToWords(int number) {
		String[] word = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" };

		if (number < 0) {
			System.out.println("Invalid Value");
			return;
		}

		int num = getDigitCount(number);
		int reversed = reverse(number);
		int digit = 0;

		for (int i = 0; i < num; i++) {
			digit = reversed % 10;
			System.out.println(word[digit]);
			reversed /= 10;
		}
	}
}