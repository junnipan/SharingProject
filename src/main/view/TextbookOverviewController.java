package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.Main;
import main.model.TextBook;

public class TextbookOverviewController {

	private RootLayoutController root;
	
	@FXML
	private AnchorPane thisPane;
	
	@FXML
	private ImageView cover;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField courseId;
	
	@FXML
	private TextField version;
	
	@FXML
	private TextField price;
	
	@FXML
	public void initialize() {
		
		thisPane.setOpacity(0);
		
	}
	
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}
	
	public void load(Image img) {
		
		cover.setImage(img);
		
		for(TextBook t : Main.textBookData) {
			if(t.getImg().equals(img)) {
				
				name.setText(t.getName());
				courseId.setText(t.getCourseId());
				version.setText("" + t.getVersion());
				price.setText("" + t.getPrice());
				
			}
		}
		
	}
	
}
