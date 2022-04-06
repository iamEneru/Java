package com.java.main;

public class EnhancedPlayer {

	public String name;
	public int hitPoints;
	public String weapon;

	public EnhancedPlayer(String name, int hitPoints, String weapon) {
		this.name = name;
		if (hitPoints > 0 && hitPoints <= 200)
			this.hitPoints = hitPoints;
		this.weapon = weapon;
	}

	public void loseHealth(int damage) {
		this.hitPoints = this.hitPoints - damage;
		if (this.hitPoints <= 0) {
			System.out.println("Player knocked out");
		}
	}

	public int getHealth() {
		return this.hitPoints;
	}

}
