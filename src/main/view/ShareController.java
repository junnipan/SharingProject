package main.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class ShareController {
	
	@FXML
	private ImageView Book;
	
	@FXML
	private ImageView Game;
	
	@FXML
	private HBox hboxLeft;
	
	@FXML
	private HBox hboxRight;
	
	@FXML
	private AnchorPane thisPane;
	
	public static int shareId;
	
	private double scaleXB;
	private double scaleYB;
	
	@FXML
	public void initialize() {
		
		thisPane.setOpacity(0);
		
		scaleXB = Book.getScaleX();
		scaleYB = Book.getScaleY();
		
		shareId = 0;
	}
	
	@FXML
	public void mouseClickedTextbook(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY && shareId == 0) { //right mouse button and the translate of hbox is not 0.
			
			shareId = 1;
			textbookTransit();		
		} 
		
	}
	
	@FXML
	public void mouseClickedVideogame(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY && shareId == 0) { //right mouse button and the translate of hbox is not 0.
			
			shareId = 2;
			gameTransit();
			
		}
		
	}
	
    public void textbookTransit() {

		ParallelTransition pt = new ParallelTransition();
		
		TranslateTransition tTLeft = new TranslateTransition(Duration.seconds(2), hboxLeft);
		tTLeft.setByX(1200);		
		
		TranslateTransition tTRight = new TranslateTransition(Duration.seconds(1.5), hboxRight);
		tTRight.setByX(600);

		pt.getChildren().addAll(tTLeft, tTRight); //add endframe to the timeline
		
		pt.play();		
	}
	
	
    public void gameTransit() {
		
        ParallelTransition pt = new ParallelTransition();
		
		TranslateTransition tTLeft = new TranslateTransition(Duration.seconds(2), hboxLeft);
		tTLeft.setByX(-600);		
		
		TranslateTransition tTRight = new TranslateTransition(Duration.seconds(1.5), hboxRight);
		tTRight.setByX(-1200);

		pt.getChildren().addAll(tTLeft, tTRight); //add endframe to the timeline
		
		pt.play();
	}
    
    @FXML
	public void mouseEntered(MouseEvent evt) {

		Timeline timeline = new Timeline();
		
		ImageView img = (ImageView)evt.getSource();
		
		KeyValue endValueX = new KeyValue(img.scaleXProperty(), 0.95);
		KeyValue endValueY = new KeyValue(img.scaleYProperty(), 0.95);
		KeyFrame endFrame = new KeyFrame(Duration.millis(200), endValueX, endValueY);
		
		timeline.getKeyFrames().add(endFrame);
		
		timeline.play();
		
	}
	
	@FXML
	public void mouseExited(MouseEvent evt) {
		
		Timeline timeline = new Timeline();
		
		ImageView img = (ImageView)evt.getSource();
		
		KeyValue endValueX = new KeyValue(img.scaleXProperty(), scaleXB);
		KeyValue endValueY = new KeyValue(img.scaleYProperty(), scaleYB);
		KeyFrame endFrame = new KeyFrame(Duration.millis(200), endValueX, endValueY);
		
		timeline.getKeyFrames().add(endFrame);
		
		timeline.play();
	}
	
	

}
