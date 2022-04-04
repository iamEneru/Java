package com.java.exercise02;

public class MegaBytesConverter {
	public static void printMegaBytesAndKiloBytes(int kiloBytes) {
		if (kiloBytes >= 0) {
			int megaBytes = kiloBytes / 1024;
			System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + kiloBytes % 1024 + " KB");
		} else {
			System.out.println("Invalid Value");
		}
	}
}