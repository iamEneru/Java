package com.java.exercise49;

public interface NodeList {

	ListItem getRoot();

	boolean addItem(ListItem item);

	boolean removeItem(ListItem item);

	void traverse(ListItem item);

}
