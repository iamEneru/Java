package com.java.exercise09;

public class MinutesToYearsDaysCalculator {
	public static void main(String[] args) {
		printYearsAndDays(525600); // should print "525600 min = 1 y and 0 d"

		printYearsAndDays(1051200); // should print "1051200 min = 2 y and 0 d"

		printYearsAndDays(561600); // should print "561600 min = 1 y and 25 d"
	}

	public static void printYearsAndDays(long minutes) {
		if (minutes >= 0) {
			long hours = minutes / 60;
			long years = (hours / 24) / 365;
			long days = (hours / 24) % 365;

			System.out.println(minutes + " min = " + years + " y and " + days + " d");

		} else {
			System.out.println("Invalid Value");
		}
	}
}