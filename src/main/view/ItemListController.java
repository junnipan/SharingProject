package main.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import main.Main;



public class ItemListController {
	
	private RootLayoutController root;
	
	private Main main;
	
	@FXML
	private AnchorPane thisPane;
		
	public static int shareId;
	
	private ImageView book0;
	
	private ImageView book1;
	
	private ImageView book2;
	
	private ImageView book3;
	
	private ImageView book4;
	
	private ImageView book5;
	
	@FXML
	public void initialize() {
		
		loadBookData();
		
		thisPane.setOpacity(0);
		
		shareId = 0;
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
		
	 private void loadBookData() {
		
		 book0.setImage(null);
		
	}

	@FXML
	 public void mouseEntered(MouseEvent evt) {

			Timeline timeline = new Timeline();
			
			Pane pane = (Pane)evt.getSource();
			
			KeyValue endValueX = new KeyValue(pane.scaleXProperty(), 0.9);
			KeyValue endValueY = new KeyValue(pane.scaleYProperty(), 0.9);
			KeyFrame endFrame = new KeyFrame(Duration.millis(200), endValueX, endValueY);
			
			timeline.getKeyFrames().add(endFrame);
			
			timeline.play();
			
		}
		
	@FXML
	public void mouseExited(MouseEvent evt) {
			
		Timeline timeline = new Timeline();
			
		Pane pane = (Pane)evt.getSource();
			
		KeyValue endValueX = new KeyValue(pane.scaleXProperty(), 0.8);
		KeyValue endValueY = new KeyValue(pane.scaleYProperty(), 0.8);
		KeyFrame endFrame = new KeyFrame(Duration.millis(200), endValueX, endValueY);
			
		timeline.getKeyFrames().add(endFrame);
			
		timeline.play();
	}
	
	@FXML
	public void mouseClickedItem(MouseEvent evt) {
		
		if( evt.getButton() == MouseButton.PRIMARY && RootLayoutController.listId == 1) {
			
			root.textbookOverviewTransition();
			
		} else if( evt.getButton() == MouseButton.PRIMARY && RootLayoutController.listId == 2) {
			//System.out.println(RootLayoutController.listId);
			root.videogameOverviewTransition();
		}
		
	}
	
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}
		
		
}
