package main.view;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class TextbookOverviewController {

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
