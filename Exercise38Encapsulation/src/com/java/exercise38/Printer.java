package com.java.exercise38;

public class Printer {
	private int tonerLevel;
	private int pagesPrinted;
	private boolean duplex;

	public Printer(int tonerLevel, boolean duplex) {
		this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
		this.pagesPrinted = 0;
		this.duplex = duplex;
	}

	public int addToner(int tonerAmount) {
		if ((tonerAmount > 0 && tonerAmount <= 100) && tonerLevel + tonerAmount <= 100) {
			return tonerLevel += tonerAmount;
		}
		return -1;
	}

	public int printPages(int pages) {
		int pagesToPrint = pages;
		if (duplex) {
			System.out.println("Printing in duplex mode");
			pagesToPrint = (pages % 2 == 0) ? pagesToPrint / 2 : pagesToPrint / 2 + 1;
		}
		pagesPrinted += pagesToPrint;
		return pagesToPrint;
	}

	public int getPagesPrinted() {
		return pagesPrinted;
	}
}
