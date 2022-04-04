package com.java.exercise27;

import java.util.Scanner;

public class InputCalculator {
	public static void main(String[] args) {
		inputThenPrintSumAndAverage();
	}
      
    public static void inputThenPrintSumAndAverage() {
        int sum = 0;
        double count = 0.0;
        long avg = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean isInt = scanner.hasNextInt();
            if(isInt) {
                count++;
                int grade = scanner.nextInt();
                sum += grade;
            } else {
                break;
            }
            scanner.nextLine();
        }
        avg = (long) Math.round(sum / count);
        System.out.println("SUM = " + sum + " AVG = " + avg);
        scanner.close();
    }
}
