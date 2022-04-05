package com.java.exercise40;

public class HealthyBurger extends Hamburger {
	private String healthyExtra1Name;
	private double healthyExtra1Price;
	private String healthyExtra2Name;
	private double healthyExtra2Price;

	public HealthyBurger(String meat, double price) {
		super("HealthyBurger", meat, price, "Brown rye");
	}

	public void addHealthyAddition1(String healthyExtra1Name, double healthyExtra1Price) {
		this.healthyExtra1Name = healthyExtra1Name;
		this.healthyExtra1Price = healthyExtra1Price;
		System.out.println("Added " + this.healthyExtra1Name + " for an extra " + this.healthyExtra1Price);
	}

	public void addHealthyAddition2(String healthyExtra2Name, double healthyExtra2Price) {
		this.healthyExtra2Name = healthyExtra2Name;
		this.healthyExtra2Price = healthyExtra2Price;
		System.out.println("Added " + this.healthyExtra2Name + " for an extra " + this.healthyExtra2Price);
	}

	@Override
	public double itemizeHamburger() {
		double total = super.itemizeHamburger();
		total += (healthyExtra1Price > 0) ? healthyExtra1Price : 0;
		total += (healthyExtra2Price > 0) ? healthyExtra2Price : 0;
		return total;
	}
}
