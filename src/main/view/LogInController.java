package main.view;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class LogInController {
	
	private RootLayoutController root;
	
	@FXML
	private AnchorPane thisPane;
	
	@FXML
	public void initialize() {
		
		thisPane.setOpacity(0);
		
		
	}
		
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}

	
}

