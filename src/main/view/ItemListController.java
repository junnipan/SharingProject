package main.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
	
	@FXML
	private ImageView img0;
	
	@FXML
	private Label label0;
	
	@FXML
	private ImageView img1;
	
	@FXML
	private Label label1;
	
	@FXML
	private ImageView img2;
	
	@FXML
	private Label label2;
	
	@FXML
	private ImageView img3;
	
	@FXML
	private Label label3;
	
	@FXML
	private ImageView img4;
	
	@FXML
	private Label label4;
	
	@FXML
	private ImageView img5;
	
	@FXML
	private Label label5;
	
	@FXML
	public void initialize() {
		
		if(RootLayoutController.listId == 1)loadBookData();
		
		thisPane.setOpacity(0);
		
		shareId = 0;
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
		
	 private void loadBookData() {
		
		 img0.setImage(Main.textBookData.get(0).getImg());
		 label0.setText(Main.textBookData.get(0).getName());
		 
		 img1.setImage(Main.textBookData.get(1).getImg());
		 label1.setText(Main.textBookData.get(1).getName());
		 
		 img2.setImage(Main.textBookData.get(2).getImg());
		 label2.setText(Main.textBookData.get(2).getName());
		 
		 img3.setImage(Main.textBookData.get(3).getImg());
		 label3.setText(Main.textBookData.get(3).getName());
		 
		 img4.setImage(Main.textBookData.get(4).getImg());
		 label4.setText(Main.textBookData.get(4).getName());
		 
		 img5.setImage(Main.textBookData.get(5).getImg());
		 label5.setText(Main.textBookData.get(5).getName());
		
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
			
			ImageView imgv = (ImageView)evt.getSource();
			
			Image img = imgv.getImage();
			
			root.textbookOverviewTransition(img);
			
		} else if( evt.getButton() == MouseButton.PRIMARY && RootLayoutController.listId == 2) {
			//System.out.println(RootLayoutController.listId);
			
			
			root.videogameOverviewTransition();
		}
		
	}
	
	public void setRoot(RootLayoutController root) {
		this.root = root;
	}
		
		
}
