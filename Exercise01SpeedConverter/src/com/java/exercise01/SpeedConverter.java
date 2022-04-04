package com.java.exercise01;

public class SpeedConverter {
	public static void main(String[] args) {
		printConversion(1.5); // should print the following text (into the console - System.out): 1.5
								// km/h = 1 mi/h
		printConversion(10.25); // should print the following text (into the console - System.out): 10.25
								// km/h = 6 mi/h
		printConversion(-5.6); // should print the following text (into the console - System.out):
								// Invalid Value
		printConversion(25.42); // should print the following text (into the console - System.out): 25.42
								// km/h = 16 mi/h
		printConversion(75.114); // should print the following text (into the console - System.out):
									// 75.114 km/h = 47 mi/h
	}

	public static long toMilesPerHour(double kilometersPerHour) {
		if (kilometersPerHour >= 0) {
			return (long) Math.round(kilometersPerHour / 1.609);
		}
		return -1;
	}

	public static void printConversion(double kilometersPerHour) {
		if (kilometersPerHour >= 0)
			System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
		else
			System.out.println("Invalid Value");
	}
}