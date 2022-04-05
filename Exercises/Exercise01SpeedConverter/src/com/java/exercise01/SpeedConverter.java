package com.java.exercise01;

public class SpeedConverter {
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