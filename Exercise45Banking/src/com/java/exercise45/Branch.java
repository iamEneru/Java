package com.java.exercise45;

import java.util.ArrayList;

public class Branch {

	private String name;
	private ArrayList<Customer> customers;

	public Branch(String name) {
		this.name = name;
		customers = new ArrayList<Customer>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public boolean newCustomer(String customerName, double initialTransaction) {
		if (findCustomer(customerName) == null) {
			Customer customer = new Customer(customerName, initialTransaction);
			customers.add(customer);
			return true;
		}
		return false;
	}

	public boolean addCustomerTransaction(String customerName, double transaction) {
		Customer customer = findCustomer(customerName);
		if (customer != null) {
			customer.addTransaction(transaction);
			return true;
		}
		return false;
	}

	private Customer findCustomer(String customerName) {
		for (Customer c : customers) {
			if (c.getName().equals(customerName))
				return c;
		}
		return null;
	}

}
