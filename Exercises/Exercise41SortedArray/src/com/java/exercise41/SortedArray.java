package com.java.exercise41;

import java.util.Scanner;

public class SortedArray {
	public static int[] getIntegers(int arraySize) {
		int[] array = new int[arraySize];

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter " + arraySize + " integer values:\r");

		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		scanner.close();
		return array;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Element " + i + " contents " + array[i]);
		}
	}

	public static int[] sortIntegers(int[] array) {
		int[] sortedArray = new int[array.length];

		System.arraycopy(array, 0, sortedArray, 0, array.length);

		for (int i = 0; i < sortedArray.length; i++) {
			for (int j = i + 1; j < sortedArray.length; j++) {
				if (sortedArray[i] < sortedArray[j]) {
					int temp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;
				}
			}
		}

		return sortedArray;
	}
}
