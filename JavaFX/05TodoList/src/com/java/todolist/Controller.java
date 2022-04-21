package com.java.todolist;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

import com.java.todolist.datamodel.TodoData;
import com.java.todolist.datamodel.TodoItem;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class Controller {

//	private List<TodoItem> todoItems;

	@FXML
	private ListView<TodoItem> todoListView;

	@FXML
	private TextArea detailsTextArea;

	@FXML
	private Label deadlineLabel;

	@FXML
	private BorderPane mainBorderPane;

	@FXML
	private ContextMenu listContextMenu;

	@FXML
	private ToggleButton filterToggleButton;

	private FilteredList<TodoItem> filteredList;

	private Predicate<TodoItem> allItems;
	private Predicate<TodoItem> todayItems;

	public void initialize() {
		listContextMenu = new ContextMenu();
		MenuItem deleteMenuItem = new MenuItem("Delete");
		deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				TodoItem item = todoListView.getSelectionModel().getSelectedItem();
				deleteItem(item);
			}
		});

		listContextMenu.getItems().addAll(deleteMenuItem);

//		TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
//				LocalDate.of(2022, Month.APRIL, 25));
//		TodoItem item2 = new TodoItem("Doctor's Appointment", "See Dr. Smith at 123 Main Street. Bring paperwork.",
//				LocalDate.of(2022, Month.MAY, 23));
//		TodoItem item3 = new TodoItem("Finish design proposal for client",
//				"I promised Mike I'd email website mockups by Friday 22nd April", LocalDate.of(2022, Month.APRIL, 22));
//		TodoItem item4 = new TodoItem("Pickup Doug at the train station",
//				"Doug's arriving on March 23 on the 5:00 train", LocalDate.of(2022, Month.MARCH, 23));
//		TodoItem item5 = new TodoItem("Pick up dry cleaning", "The clothes should be ready by Wednesday",
//				LocalDate.of(2022, Month.APRIL, 20));
//
//		todoItems = new ArrayList<TodoItem>();
//		todoItems.add(item1);
//		todoItems.add(item2);
//		todoItems.add(item3);
//		todoItems.add(item4);
//		todoItems.add(item5);
//
//		TodoData.getInstance().setTodoItems(todoItems);

		todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
			@Override
			public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
				if (newValue != null) {
					TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
					detailsTextArea.setText(item.getDetails());
					DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
					deadlineLabel.setText(df.format(item.getDeadline()));
				}
			}
		});

		allItems = new Predicate<TodoItem>() {
			@Override
			public boolean test(TodoItem t) {
				return true;
			}
		};

		todayItems = new Predicate<TodoItem>() {
			@Override
			public boolean test(TodoItem t) {
				return t.getDeadline().equals(LocalDate.now());
			}
		};

		filterToggleButton.setTooltip(new Tooltip("TOGGLED UP: All items."));
		filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), allItems);

		SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList, new Comparator<TodoItem>() {
			@Override
			public int compare(TodoItem o1, TodoItem o2) {
				return o1.getDeadline().compareTo(o2.getDeadline());
			}
		});
		todoListView.setItems(sortedList); // SortedList

//		todoListView.getItems().setAll(todoItems);
//		todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); // List<TodoItems>
//		todoListView.setItems(TodoData.getInstance().getTodoItems()); // ObservableList<TodoItem>
		todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		todoListView.getSelectionModel().selectFirst();

		todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {

			@Override
			public ListCell<TodoItem> call(ListView<TodoItem> arg0) {
				ListCell<TodoItem> cell = new ListCell<TodoItem>() {
					@Override
					protected void updateItem(TodoItem item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setText(null);
							return;
						}

						setText(item.getShortDescription());

						if (item.getDeadline().isBefore(LocalDate.now())) {
							setTextFill(Color.RED);
						}

						if (item.getDeadline().equals(LocalDate.now())) {
							setTextFill(Color.GREEN);
						}
					}
				};

				cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
					if (isNowEmpty) {
						cell.setContextMenu(null);
						return;
					}

					cell.setContextMenu(listContextMenu);
				});

				return cell;
			}

		});
	}

	@FXML
	public void showNewItemDialog() {
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setTitle("Create new Todo item...");
		dialog.setHeaderText("Use this dialog to create a new todo item");
		dialog.initOwner(mainBorderPane.getScene().getWindow());

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));

		try {
//			Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
//			dialog.getDialogPane().setContent(root);

			dialog.getDialogPane().setContent(fxmlLoader.load());
		} catch (IOException e) {
			System.out.println("Couldn't load the dialog");
			e.printStackTrace();
			return;
		}

		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

		Optional<ButtonType> result = dialog.showAndWait();
		if (result.isPresent()) {
			if (result.get() == ButtonType.OK) {
				DialogController controller = fxmlLoader.getController();
				TodoItem newItem = controller.processResults();
//				todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); // List<TodoItems>
				todoListView.getSelectionModel().select(newItem);
			}
		}
	}

	@FXML
	public void handleKeyPressed(KeyEvent keyEvent) {
		TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			if (keyEvent.getCode().equals(KeyCode.DELETE)) {
				deleteItem(selectedItem);
			}
		}
	}

	public void deleteItem(TodoItem item) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Delete Todo Item");
		alert.setHeaderText("Delete item: " + item.getShortDescription());
		alert.setContentText("Are you sure?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			TodoData.getInstance().deleteTodoItem(item);
		}
	}

	@FXML
	public void handleFilterButton() {
		TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
		if (filterToggleButton.isSelected()) {
			filterToggleButton.setTooltip(new Tooltip("TOGGLED DOWN: Today's items."));
			filteredList.setPredicate(todayItems);
			if (filteredList.isEmpty()) {
				detailsTextArea.clear();
				deadlineLabel.setText(null);
				return;
			}

			if (filteredList.contains(selectedItem)) {
				todoListView.getSelectionModel().select(selectedItem);
				return;
			}

			todoListView.getSelectionModel().selectFirst();
			return;
		}
		filterToggleButton.setTooltip(new Tooltip("TOGGLED UP: All items."));
		filteredList.setPredicate(allItems);
		todoListView.getSelectionModel().select(selectedItem);
	}

	@FXML
	public void handleExit() {
		Platform.exit();
	}
}
