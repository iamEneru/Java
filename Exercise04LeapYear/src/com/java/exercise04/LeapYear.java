package com.java.exercise04;

public class LeapYear {

	public static void main(String[] args) {
		isLeapYear(-1600); // should return false since the parameter is not in range (1-9999)

		isLeapYear(1600); // should return true since 1600 is a leap year

		isLeapYear(2017); // should return false since 2017 is not a leap year

		isLeapYear(2000); // should return true because 2000 is a leap year
	}

	public static boolean isLeapYear(int year) {
		if ((year >= 1 && year <= 9999) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
			return true;
		}
		return false;
	}
}