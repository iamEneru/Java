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

		item = new StockItem("Cup", 0.45, 7);
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

		for (String s : stockList.Items().keySet()) {
			System.out.println(s);
		}

		Basket myBasket = new Basket("Customer");
		sellItem(myBasket, "Car", 1);
		System.out.println(myBasket);

		sellItem(myBasket, "Car", 1);
		System.out.println(myBasket);

		sellItem(myBasket, "Car", 1);
		sellItem(myBasket, "Spanner", 5);
		System.out.println(myBasket);

		sellItem(myBasket, "Juice", 4);
		sellItem(myBasket, "Cup", 12);
		sellItem(myBasket, "Bread", 1);

		System.out.println(myBasket);

		System.out.println(stockList);
	}

	public static int sellItem(Basket basket, String item, int quantity) {
		StockItem stockItem = stockList.get(item);

		if (stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}

		if (stockList.sellStock(item, quantity) != 0) {
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}

		return 0;
	}
}
