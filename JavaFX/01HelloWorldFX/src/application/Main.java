package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Default
//		BorderPane root = new BorderPane();
//		Scene scene = new Scene(root, 400, 400);
//		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//		primaryStage.setTitle("Hello World");
//		primaryStage.setScene(scene);
//		primaryStage.show();

		/////////////////////////////////////////////////////

		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		primaryStage.setTitle("Hello JavaFX!");
		primaryStage.setScene(new Scene(root, 700, 275));
		primaryStage.show();

		/////////////////////////////////////////////////////

//		GridPane root = new GridPane();
//		root.setAlignment(Pos.CENTER);
//		root.setVgap(10);
//		root.setHgap(10);
//
//		Label greeting = new Label("Welcome to JavaFX!");
//		greeting.setTextFill(Color.GREEN);
//		greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//
//		root.getChildren().add(greeting);

//		Scene scene = new Scene(root, 700, 275);
//		scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//		primaryStage.setTitle("Hello JavaFX!");
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
