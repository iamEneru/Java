package com.java.exercise49;

public class MyLinkedList implements NodeList {
	private ListItem root = null;

	public MyLinkedList(ListItem root) {
		this.root = root;
	}

	@Override
	public ListItem getRoot() {
		return this.root;
	}

	@Override
	public boolean addItem(ListItem item) {
		if (this.root == null) {
			this.root = item;
			return true;
		}

		ListItem currentItem = this.root;
		while (currentItem != null) {
			int comparison = currentItem.compareTo(item);
			if (comparison < 0) {
				if (currentItem.next() != null) {
					currentItem = currentItem.next();
					continue;
				}
				currentItem.setNext(item).setPrevious(currentItem);
				return true;
			}

			if (comparison > 0) {
				if (currentItem.previous() != null) {
					currentItem.previous().setNext(item).setPrevious(currentItem.previous());
					item.setNext(currentItem).setPrevious(item);
					return true;
				}
				item.setNext(this.root).setPrevious(item);
				this.root = item;
				return true;
			}

			System.out.println(item.getValue() + " is already present, not added.");
			return false;
		}
		return false;
	}

	@Override
	public boolean removeItem(ListItem item) {
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}

		ListItem currentItem = this.root;
		while (currentItem != null) {
			int comparison = currentItem.compareTo(item);
			if (comparison == 0) {
				if (currentItem == this.root) {
					this.root = currentItem.next();
					return true;
				}
				currentItem.previous().setNext(currentItem.next());
				if (currentItem.next() != null) {
					currentItem.next().setPrevious(currentItem.previous());
				}
				return true;
			}

			if (comparison < 0) {
				currentItem = currentItem.next();
				continue;
			}

			return false;
		}
		return false;
	}

	@Override
	public void traverse(ListItem item) {
		if (item == null) {
			System.out.println("The list is empty");
		} else {
			while (item != null) {
				System.out.println(item.getValue());
				item = item.next();
			}
		}
	}

}
