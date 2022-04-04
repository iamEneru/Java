package com.java.exercise25;

public class LargestPrime {
	public static void main(String[] args) {
		System.out.println(getLargestPrime(21)); // should return 7 since 7 is the largest prime (3 * 7 = 21)

		System.out.println(getLargestPrime(217)); // should return 31 since 31 is the largest prime (7 * 31 = 217)

		System.out.println(getLargestPrime(0)); // should return -1 since 0 does not have any prime numbers

		System.out.println(getLargestPrime(45)); // should return 5 since 5 is the largest prime (3 * 3 * 5 = 45)

		System.out.println(getLargestPrime(-1)); // should return -1 since the parameter is negative
	}

	public static int getLargestPrime(int num) {
		if (num > 1) {
			int max = 0;
			for (int i = 2; i < num + 2; i++) {
				if (num % i == 0) {
					if (num % 2 == 0) {
						i = 2;
					}
					num = num / i;
					if (i >= max) {
						max = i;
					}
					i = 2;
				}
			}
			if (num > max) {
				max = num;
			}
			return max;
		}
		return -1;
	}
}
