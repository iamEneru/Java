package com.java.exercise20;

public class GreatestCommonDivisor {
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