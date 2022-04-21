package com.java.todolist;

import java.time.LocalDate;

import com.java.todolist.datamodel.TodoData;
import com.java.todolist.datamodel.TodoItem;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {

	@FXML
	private TextField shortDescriptionTextField;

	@FXML
	private TextArea detailsTextArea;

	@FXML
	private DatePicker deadlineDatePicker;

	public TodoItem processResults() {
		String shortDescription = shortDescriptionTextField.getText().trim();
		String details = detailsTextArea.getText().trim();
		LocalDate deadline = deadlineDatePicker.getValue();

		TodoItem newItem = new TodoItem(shortDescription, details, deadline);
		TodoData.getInstance().addTodoItem(newItem);
		return newItem;
	}
}
