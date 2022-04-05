package com.java.exercise49;

public class SearchTree implements NodeList {
	private ListItem root = null;

	public SearchTree(ListItem root) {
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
				currentItem.setNext(item);
				return true;
			}

			if (comparison > 0) {
				if (currentItem.previous() != null) {
					currentItem = currentItem.previous();
					continue;
				}
				currentItem.setPrevious(item);
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
		ListItem parentItem = currentItem;
		while (currentItem != null) {
			int comparison = currentItem.compareTo(item);
			if (comparison < 0) {
				parentItem = currentItem;
				currentItem = currentItem.next();
				continue;
			}

			if (comparison > 0) {
				parentItem = currentItem;
				currentItem = currentItem.previous();
				continue;
			}

			performRemoval(currentItem, parentItem);
			return true;
		}
		return false;
	}

	private void performRemoval(ListItem item, ListItem parent) {
		if (item.next() == null) {
			if (parent.next() == item) {
				parent.setNext(item.previous());
				return;
			}

			if (parent.previous() == item) {
				parent.setPrevious(item.previous());
				return;
			}

			this.root = item.previous();
			return;
		}

		if (item.previous() == null) {
			if (parent.next() == item) {
				parent.setNext(item.next());
				return;
			}

			if (parent.previous() == item) {
				parent.setPrevious(item.next());
				return;
			}

			this.root = item.next();
			return;
		}

		ListItem current = item.next();
		ListItem leftmostParent = item;
		while (current.previous() != null) {
			leftmostParent = current;
			current = current.previous();
		}

		item.setValue(current.getValue());

		if (leftmostParent == item) {
			item.setNext(current.next());
			return;
		}

		leftmostParent.setPrevious(current.next());
		return;
	}

	@Override
	public void traverse(ListItem item) {
		if (item != null) {
			traverse(item.previous());
			System.out.println(item.getValue());
			traverse(item.next());
		}
	}

}
