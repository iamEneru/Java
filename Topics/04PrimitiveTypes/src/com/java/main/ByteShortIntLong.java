package com.java.main;

public class ByteShortIntLong {

	public static void main(String[] args) {

		byte myMinByteValue = Byte.MIN_VALUE;
		byte myMaxByteValue = Byte.MAX_VALUE;
		System.out.println("Byte Minimum Value = " + myMinByteValue);
		System.out.println("Byte Maximum Value = " + myMaxByteValue);

		short myMinShortValue = Short.MIN_VALUE;
		short myMaxShortValue = Short.MAX_VALUE;
		System.out.println("Short Minimum Value = " + myMinShortValue);
		System.out.println("Short Maximum Value = " + myMaxShortValue);

		int myMaxIntTest = 2_147_483_647;
		System.out.println(myMaxIntTest);

		int myMinIntValue = Integer.MIN_VALUE;
		int myMaxIntValue = Integer.MAX_VALUE;
		System.out.println("Integer Minimum Value = " + myMinIntValue);
		System.out.println("Integer Maximum Value = " + myMaxIntValue);
		System.out.println("Busted MAX value = " + (myMaxIntValue + 1));
		System.out.println("Busted MIN value = " + (myMinIntValue - 1));

		long bigLongLiteralValue = 2_147_483_647_234L;
		System.out.println(bigLongLiteralValue);

		long myMinLongValue = Long.MIN_VALUE;
		long myMaxLongValue = Long.MAX_VALUE;
		System.out.println("Long Minimum Value = " + myMinLongValue);
		System.out.println("Long Maximum Value = " + myMaxLongValue);
		System.out.println("Busted MAX value = " + (myMaxLongValue + 1));
		System.out.println("Busted MIN value = " + (myMinLongValue - 1));

	}
}
