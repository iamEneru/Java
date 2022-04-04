package com.java.exercise03;

public class BarkingDog {
	public static void main(String[] args) {
		System.out.println(shouldWakeUp(true, 1)); // should return true

		System.out.println(shouldWakeUp(false, 2)); // should return false since the dog is not barking.

		System.out.println(shouldWakeUp(true, 8)); // should return false, since it's not before 8.

		System.out.println(shouldWakeUp(true, -1)); // should return false since the hourOfDay parameter needs to be in
													// a range
		// 0-23.
	}

	public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		if (isBarking && ((hourOfDay >= 0 && hourOfDay < 8) || (hourOfDay > 22 && hourOfDay < 24))) {
			return true;
		}
		return false;
	}
}