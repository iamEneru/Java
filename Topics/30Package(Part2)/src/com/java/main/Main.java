package com.java.main;

//To add project as classpath for imports,
//Right-click on the project
//Select Properties
//Select Java Build Path
//Select Projects tab
//Select Classpath and click add
//Select the existing project you want to add
//Click Apply and Close
import com.java.library.Series;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.println(Series.nSum(i));
		}

		System.out.println("*****************************");
		for (int i = 0; i <= 10; i++) {
			System.out.println(Series.factorial(i));
		}
		System.out.println("*****************************");
		for (int i = 0; i <= 10; i++) {
			System.out.println(Series.fibonacci(i));
		}
	}
}
