package com.java.exercise24;

public class FlourPacker {
	public static boolean canPack(int bigCount, int smallCount, int goal) {
		if (bigCount < 0 || smallCount < 0 || goal < 0)
			return false;

		int bigCountKilos = 5;
		int totalKilos = bigCount * bigCountKilos + smallCount;

		if (goal <= totalKilos) {
			if (goal < bigCountKilos && goal <= smallCount)
				return true;
			if (goal % bigCountKilos == 0 && goal / bigCountKilos >= bigCount)
				return true;

			int total = bigCount;

			if (bigCount > 0) {
				while (goal < total * bigCountKilos) {
					total--;
				}
			}

			if (goal <= total * bigCountKilos + smallCount)
				return true;
		}

		return false;
	}
}