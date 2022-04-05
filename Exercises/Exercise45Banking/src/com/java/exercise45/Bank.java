package com.java.exercise45;

import java.util.ArrayList;

public class Bank {

	private String name;
	private ArrayList<Branch> branches;

	public Bank(String name) {
		this.name = name;
		branches = new ArrayList<Branch>();
	}

	public boolean addBranch(String name) {
	    Branch branch = findBranch(name);
		if (branch == null) {
			branches.add(new Branch(name));
			return true;
		}
		return false;
	}

	public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
	    Branch branch = findBranch(branchName);
		if (branch != null) {
			return branch.newCustomer(customerName, initialTransaction);
		}
		return false;
	}

	public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			return branch.addCustomerTransaction(customerName, transaction);
		}
		return false;
	}

	private Branch findBranch(String branchName) {
		for (Branch b : branches) {
			if (b.getName().equals(branchName))
				return b;
		}
		return null;
	}

	public boolean listCustomers(String branchName, boolean printTransaction) {
		Branch branch = findBranch(branchName);
		if (branch != null) {
			System.out.println("Customer details for branch " + branch.getName());
			for (int i = 0; i < branch.getCustomers().size(); i++) {
				Customer customer = branch.getCustomers().get(i);
				System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");
				if (printTransaction) {
					System.out.println("Transactions");
					for (int j = 0; j < customer.getTransactions().size(); j++) {
						double transaction = customer.getTransactions().get(j);
						System.out.println("[" + (j + 1) + "]  Amount " + transaction);
					}
				}
			}
			return true;
		}
		return false;
	}

}
