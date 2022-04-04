package com.java.exercise44;

import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		myContacts = new ArrayList<Contact>();
	}

	public boolean addNewContact(Contact contact) {
		for (Contact c : myContacts) {
			if (c.getName().equals(contact.getName()))
				return false;
		}

		myContacts.add(contact);

		return true;
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		if (findContact(oldContact) != -1) {
			myContacts.set(findContact(oldContact), newContact);
			return true;
		}

		return false;
	}

	public boolean removeContact(Contact contact) {
		if (findContact(contact) != -1) {
			myContacts.remove(contact);
			return true;
		}

		return false;
	}

	private int findContact(Contact contact) {
		return myContacts.indexOf(contact);
	}

	private int findContact(String input) {
		for (Contact c : myContacts) {
			if (c.getName().equals(input) || c.getPhoneNumber().contains(input)) {
				return myContacts.indexOf(c);
			}
		}
		return -1;
	}

	public Contact queryContact(String input) {
		for (Contact c : myContacts) {
			if (c.getName().equals(input) || c.getPhoneNumber().contains(input)) {
				return c;
			}
		}

		return null;
	}

	public void printContacts() {
		System.out.println("Contact List:");
		for (int i = 0; i < myContacts.size(); i++) {
			System.out
					.println(i + 1 + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
		}
	}
}
