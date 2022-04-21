package com.java.todolist;

import java.io.IOException;

import com.java.todolist.datamodel.TodoData;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
		primaryStage.setTitle("Todo List");
		primaryStage.setScene(new Scene(root, 900, 500));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception, IOException {
		TodoData.getInstance().loadTodoItems();
	}

	@Override
	public void stop() throws Exception, IOException {
		TodoData.getInstance().storeTodoItems();
	}
}
