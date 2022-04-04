package com.java.exercise20;

public class GreatestCommonDivisor {
	public static void main(String[] args) {

		System.out.println(getGreatestCommonDivisor(25, 15)); // should return 5 since both can be divided by 5 without
																// a remainder

		System.out.println(getGreatestCommonDivisor(12, 30)); // should return 6 since both can be divided by 6 without
																// a remainder

		System.out.println(getGreatestCommonDivisor(9, 18)); // should return -1 since the first parameter is < 10

		System.out.println(getGreatestCommonDivisor(81, 153)); // should return 9 since both can be divided by 9 without
																// a remainder
	}

	public static int getGreatestCommonDivisor(int first, int second) {
		if (first < 10 || second < 10)
			return -1;

		int divisor1 = 0;
		int divisor2 = 0;

		int max = 0;
		for (int i = 1; i <= first || i <= second; i++) {
			if (first % i == 0) {
				divisor1 = i;
			}
			if (second % i == 0) {
				divisor2 = i;
			}
			if (divisor1 == divisor2) {
				max = divisor2;
			}
		}

		return max;
	}
}