package com.java.exercise17;

public class EvenDigitSum {
	public static int getEvenDigitSum(int number) {
		if (number >= 0) {
			int digit;
			int sum = 0;
			while (number != 0) {
				digit = number % 10;
				if (digit % 2 == 0) {
					sum += digit;
				}
				number /= 10;
			}
			return sum;
		}
		return -1;
	}
}
