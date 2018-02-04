package main.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;



public class ItemListController {
	
	private RootLayoutController root;
	
	@FXML
	private AnchorPane thisPane;
	
	//@FXML
	//private Pane pane;
	
	public static int shareId;
	
	private double scaleXB;
	private double scaleYB;
	
	@FXML
	public void initialize() {
		
		thisPane.setOpacity(0);
		
		shareId = 0;
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
	
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}
		
		
}
