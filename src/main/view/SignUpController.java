package main.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SignUpController {

	private RootLayoutController root;
	
	@FXML
	private AnchorPane thisPane;
	
	@FXML
	public void initialize() {
		
		thisPane.setOpacity(0);
		
		
	}
	
	@FXML
	private void mouseClickedCancel(MouseEvent evt) {
		
		root.signUpCancel();
		
	}
	
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}
	
}
