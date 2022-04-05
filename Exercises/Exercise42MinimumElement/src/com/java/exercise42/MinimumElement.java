package com.java.exercise42;

import java.util.Scanner;
import java.util.Arrays;

public class MinimumElement {
	private static int readInteger() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static int[] readElements(int size) {
		Scanner scanner = new Scanner(System.in);

		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}

		return array;
	}

	private static int findMin(int[] array) {
		int[] sortedArray = new int[array.length];

		System.arraycopy(array, 0, sortedArray, 0, array.length);
		Arrays.sort(sortedArray);

		return sortedArray[0];
	}
}
