package com.java.main;

import java.util.Map;

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

		Basket myBasket = new Basket("Tim");

		sellItem(myBasket, "car", 1);
		System.out.println(myBasket);

		sellItem(myBasket, "car", 1);
		System.out.println(myBasket);

		if (sellItem(myBasket, "car", 1) != 1) {
			System.out.println("There are no more cars in stock");
		}

		sellItem(myBasket, "spanner", 5);
//        System.out.println(timsBasket);

		sellItem(myBasket, "juice", 4);
		sellItem(myBasket, "cup", 12);
		sellItem(myBasket, "bread", 1);
//        System.out.println(timsBasket);

//        System.out.println(stockList);

		Basket basket = new Basket("customer");
		sellItem(basket, "cup", 100);
		sellItem(basket, "juice", 5);
		removeItem(basket, "cup", 1);
		System.out.println(basket);

		removeItem(myBasket, "car", 1);
		removeItem(myBasket, "cup", 9);
		removeItem(myBasket, "car", 1);
		System.out.println("cars removed: " + removeItem(myBasket, "car", 1)); // should not remove any

		System.out.println(myBasket);

		// remove all items from timsBasket
		removeItem(myBasket, "bread", 1);
		removeItem(myBasket, "cup", 3);
		removeItem(myBasket, "juice", 4);
		removeItem(myBasket, "cup", 3);
		System.out.println(myBasket);

		System.out.println("\nDisplay stock list before and after checkout");
		System.out.println(basket);
		System.out.println(stockList);
		checkOut(basket);
		System.out.println(basket);
		System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);

		StockItem car = stockList.Items().get("car");

		if (car != null) {
			car.adjustStock(2000);
		}

		if (car != null) {
			stockList.get("car").adjustStock(-1000);
		}

		System.out.println(stockList);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

		checkOut(myBasket);
		System.out.println(myBasket);
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

	public static int removeItem(Basket basket, String item, int quantity) {
		// retrieve the item from stock list
		StockItem stockItem = stockList.get(item);
		if (stockItem == null) {
			System.out.println("We don't sell " + item);
			return 0;
		}

		if (basket.removeFromBasket(stockItem, quantity) == quantity) {
			return stockList.unreserveStock(item, quantity);
		}

		return 0;
	}

	public static void checkOut(Basket basket) {
		for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
			stockList.sellStock(item.getKey().getName(), item.getValue());
		}
		basket.clearBasket();
	}
}
