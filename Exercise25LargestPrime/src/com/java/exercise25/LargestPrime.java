package com.java.exercise25;

public class LargestPrime {
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
