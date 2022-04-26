package application;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {

	@FXML
	private Label label;

	@FXML
	private Button button4;

	@FXML
	private GridPane gridPane;

	@FXML
	private WebView webView;

	public void initialize() {
		button4.setEffect(new DropShadow());
	}

	@FXML
	public void handleMouseEnter() {
		label.setScaleX(2.0);
		label.setScaleY(2.0);
	}

	@FXML
	public void handleMouseExit() {
		label.setScaleX(1.0);
		label.setScaleY(1.0);
	}

	@FXML
	public void handleClick() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Application File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text", "*.txt"),
				new ExtensionFilter("PDF", "*.pdf"), new ExtensionFilter("All Files", "*.*"),
				new ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"));
		List<File> file = fileChooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
		if (file != null) {
			for (int i = 0; i < file.size(); i++)
				System.out.println(file.get(i));
		}

		System.out.println("Chooser was cancelled");

//		DirectoryChooser directoryChooser = new DirectoryChooser();
//		File file = directoryChooser.showDialog(gridPane.getScene().getWindow());
//		if (file != null) {
//			System.out.println(file.getPath());
//			return;
//		}
//
//		System.out.println("Chooser was cancelled");
	}

	@FXML
	public void handleLinkClick() {
//		Desktop.getDesktop().browse(new URI("http://www.javafx.com")); // throws IOException, URISyntaxException
		WebEngine engine = webView.getEngine();
		engine.load("http://www.javafx.com");
	}

}
