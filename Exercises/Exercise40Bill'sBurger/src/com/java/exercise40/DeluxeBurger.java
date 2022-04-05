package com.java.exercise40;

public class DeluxeBurger extends Hamburger {
	public DeluxeBurger() {
		super("Deluxe", "Sausage & Bacon", 14.54, "White");
		super.addHamburgerAddition1("Chips", 2.75);
		super.addHamburgerAddition2("Drink", 1.81);
	}

	@Override
	public void addHamburgerAddition1(String addition1Name, double addition1Price) {

	}

	@Override
	public void addHamburgerAddition2(String addition2Name, double addition2Price) {

	}

	@Override
	public void addHamburgerAddition3(String addition3Name, double addition3Price) {

	}

	@Override
	public void addHamburgerAddition4(String addition4Name, double addition4Price) {

	}
}
