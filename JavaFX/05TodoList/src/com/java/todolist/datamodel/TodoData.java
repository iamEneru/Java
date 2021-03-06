package com.java.todolist.datamodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TodoData {
	private static TodoData instance = new TodoData();
	private static String filename = "TodoListItems.txt";

//	private List<TodoItem> todoItems;
	private ObservableList<TodoItem> todoItems; // binding
	private DateTimeFormatter formatter;

	public static TodoData getInstance() {
		return instance;
	}

	private TodoData() {
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}

//	public List<TodoItem> getTodoItems() {
//		return todoItems;
//	}

	public ObservableList<TodoItem> getTodoItems() {
		return todoItems;
	}

	public void addTodoItem(TodoItem item) {
		todoItems.add(item);
	}

	public void loadTodoItems() throws IOException {
		todoItems = FXCollections.observableArrayList();
		Path path = Paths.get(filename);
		BufferedReader reader = Files.newBufferedReader(path);

		String input;

		try {
			while ((input = reader.readLine()) != null) {
				String[] itemPieces = input.split("\t");

				String shortDescription = itemPieces[0];
				String details = itemPieces[1];
				String dateString = itemPieces[2];
				LocalDate date = LocalDate.parse(dateString, formatter);
				TodoItem item = new TodoItem(shortDescription, details, date);
				todoItems.add(item);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public void storeTodoItems() throws IOException {
		Path path = Paths.get(filename);
		BufferedWriter writer = Files.newBufferedWriter(path);

		try {
			Iterator<TodoItem> iterator = todoItems.iterator();
			while (iterator.hasNext()) {
				TodoItem item = iterator.next();
				writer.write(String.format("%s\t%s\t%s", item.getShortDescription(), item.getDetails(),
						item.getDeadline().format(formatter)));
				writer.newLine();
			}
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public void deleteTodoItem(TodoItem item) {
		todoItems.remove(item);
	}

}
