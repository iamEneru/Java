package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField nameField;

	@FXML
	private Button helloButton;

	@FXML
	private Button byeButton;

	@FXML
	private CheckBox checkBox;

	@FXML
	private Label gridPaneLabel;

	@FXML
	public void initialize() {
		helloButton.setDisable(true);
		byeButton.setDisable(true);
	}

	@FXML
	public void onButtonClicked(ActionEvent e) {
		if (e.getSource().equals(helloButton))
			System.out.println("Hello, " + nameField.getText());

		if (e.getSource().equals(byeButton))
			System.out.println("Bye, " + nameField.getText());

		System.out.println("The following button was pressed: " + e.getSource());

		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
					System.out.println("I'm going to sleep on the: " + s);

					Thread.sleep(5000);

					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
							System.out.println("I'm updating the label on the: " + s);
							gridPaneLabel.setText("We did something!");
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(task).start();

		if (checkBox.isSelected()) {
			nameField.setText(null);
			helloButton.setDisable(true);
			byeButton.setDisable(true);
		}
	}

	@FXML
	public void onKeyReleased() {
		String text = nameField.getText();
		boolean disableButtons = text.isEmpty() | text.trim().isEmpty();
		helloButton.setDisable(disableButtons);
		byeButton.setDisable(disableButtons);
	}

	@FXML
	public void onTextChanged() {
		System.out.println("The checkbox is " + (checkBox.isSelected() ? "checked" : "not checked"));
	}
}
