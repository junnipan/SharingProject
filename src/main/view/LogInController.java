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
	
	@FXML
	public void mouseClickedSignUp(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY) {
			
			RootLayoutController.sceneId = 2;
			
			FadeTransition ft = new FadeTransition(Duration.millis(800), thisPane);		
			ft.setFromValue(1.0);
			ft.setToValue(0);
			ft.setOnFinished(e -> root.loadSignUp());
			ft.play();
			
		}
		
	}
	
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}

	
}
