package com.java.exercise05;

public class DecimalComparator {
	public static boolean areEqualByThreeDecimalPlaces(double value1, double value2) {
		if ((int) (value1 * 1000) == (int) (value2 * 1000)) {
			return true;
		}
		return false;
	}
}
