package com.java.exercise43;

public class ReverseArray {
	private static void reverse(int[] array) {
		System.out.print("Array = [");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ", ");
			} else {
				System.out.print(array[i]);
			}
		}
		System.out.print("]");

		int num = array.length;

		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[num - 1];
			array[num - 1] = temp;
			num--;
		}

		System.out.print("Reversed array = [");
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + ", ");
			} else {
				System.out.print(array[i]);
			}
		}
		System.out.print("]");
	}
}
