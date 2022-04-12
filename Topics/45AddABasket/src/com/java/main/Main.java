package com.java.main;

public class Main {
	private static StockList stockList = new StockList();

	public static void main(String[] args) {
		StockItem item = new StockItem("Bread", 0.86, 100);
		stockList.addStock(item);

		item = new StockItem("Cake", 1.10, 7);
		stockList.addStock(item);

		item = new StockItem("Car", 12.50, 2);
		stockList.addStock(item);

		item = new StockItem("Chair", 62.0, 10);
		stockList.addStock(item);

		item = new StockItem("Cup", 0.50, 200);
		stockList.addStock(item);

		item = new StockItem("Door", 72.95, 4);
		stockList.addStock(item);

		item = new StockItem("Juice", 2.50, 36);
		stockList.addStock(item);

		item = new StockItem("Phone", 96.99, 35);
		stockList.addStock(item);

		item = new StockItem("Towel", 2.40, 80);
		stockList.addStock(item);

		item = new StockItem("Vase", 8.76, 40);
		stockList.addStock(item);

		System.out.println(stockList);
	}

}
