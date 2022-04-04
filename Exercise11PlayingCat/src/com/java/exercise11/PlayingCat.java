package com.java.exercise11;

public class PlayingCat {
	public static boolean isCatPlaying(boolean summer, int temperature) {
		if (summer) {
			return (temperature >= 25) && (temperature <= 45);
		}
		return (temperature >= 25) && (temperature <= 35);
	}
}