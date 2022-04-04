package com.java.exercise23;

public class NumberToWords {
	public static void main(String[] args) {
		// Example Input/Output - getDigitCount method

		System.out.println(getDigitCount(0)); // should return 1 since there is only 1 digit

		System.out.println(getDigitCount(123)); // should return 3

		System.out.println(getDigitCount(-12)); // should return -1 since the parameter is negative

		System.out.println(getDigitCount(5200)); // should return 4 since there are 4 digits in the number

		// Example Input/Output - reverse method

		System.out.println(reverse(-121)); // should return -121

		System.out.println(reverse(1212)); // should return 2121

		System.out.println(reverse(1234)); // should return 4321

		System.out.println(reverse(100)); // should return 1

		// Example Input/Output - numberToWords method

		numberToWords(123); // should print "One Two Three".

		numberToWords(1010); // should print "One Zero One Zero".

		numberToWords(1000); // should print "One Zero Zero Zero".

		numberToWords(-12); // should print "Invalid Value" since the parameter is negative.
	}

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