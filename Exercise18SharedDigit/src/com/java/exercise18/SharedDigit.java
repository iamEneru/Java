package com.java.exercise18;

public class SharedDigit {
	public static void main(String[] args) {
		System.out.println(hasSharedDigit(12, 23)); // should return true since the digit 2 appears in both numbers

		System.out.println(hasSharedDigit(9, 99)); // should return false since 9 is not within the range of 10-99

		System.out.println(hasSharedDigit(15, 55)); // should return true since the digit 5 appears in both numbers

	}

	public static boolean hasSharedDigit(int num1, int num2) {
        if((num1 < 10 || num1 > 99) || (num2 > 99 || num2 < 10)) {
            return false;
        }

        int digit1 = 0, digit2 =0;

        while (num1 != 0 && num2 != 0) {
            digit1 = num1 % 10;
            digit2 = num2 % 10;

            num1 /= 10;
            num2 /= 10;

            if(digit1 == digit2 || digit2 == digit1 || digit2 == num1 || digit1 == num2) return true;

        }
        return false;
    }

}