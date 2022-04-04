package com.java.exercise09;

public class MinutesToYearsDaysCalculator {
	public static void printYearsAndDays(long minutes) {
		if (minutes >= 0) {
			long hours = minutes / 60;
			long years = (hours / 24) / 365;
			long days = (hours / 24) % 365;

			System.out.println(minutes + " min = " + years + " y and " + days + " d");
			return;
		}
		System.out.println("Invalid Value");

	}
}