package com.java.exercise49;

/*
	Only add/edit code where it is stated in the description.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private Map<Integer, Location> locations = new HashMap<Integer, Location>();
	private Map<String, String> vocabulary = new HashMap<String, String>();

	public Main() {
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));

		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);

		locations.get(2).addExit("N", 5);

		locations.get(3).addExit("W", 1);

		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);

		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);

		vocabulary.put("N", "NORTH");
		vocabulary.put("S", "SOUTH");
		vocabulary.put("W", "WEST");
		vocabulary.put("E", "EAST");
	}

	public void command() {
		Scanner scanner = new Scanner(System.in);
		int location = 1;
		boolean isExist = true;
		while (true) {

			if (!isExist)
				System.out.println("You cannot go in that direction");
			isExist = false;

			System.out.println(locations.get(location).getDescription());

			if (location == 0) {
				scanner.close();
				break;
			}

			System.out.print("Available exits are ");

			Map<String, Integer> exits = locations.get(location).getExits();
			for (String key : exits.keySet()) {
				System.out.print(key + ", ");
			}

			System.out.println();

			String input = scanner.nextLine();

			if (input.toUpperCase().equals("QUIT")) {
				location = 0;
				isExist = true;
				continue;
			}

			for (String key : exits.keySet()) {
				if (input.toUpperCase().equals(key)
						|| (vocabulary.get(key) != null && input.toUpperCase().contains(vocabulary.get(key)))) {
					location = exits.get(key);
					isExist = true;
				}
			}
		}
	}
}