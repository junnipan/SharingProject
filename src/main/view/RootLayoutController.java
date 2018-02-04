package main.view;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import main.view.ShareController;

public class RootLayoutController {

	
	@FXML
	private HBox hbox;
	
	private double translateX;
	
	@FXML
	private HBox hbox0;
	
	private double translateXL;
	
	@FXML
	public AnchorPane centerpane;
	
	private AnchorPane logIn;
	
	private AnchorPane signUp;
	
	private AnchorPane share;
	
	private AnchorPane itemList;
	
	public ShareController shareController;
	
	@FXML
	private ImageView wide0;
	
	@FXML
	private ImageView wide00;
	
	@FXML
	private ImageView textBook;
	
	private double scaleXB;
	private double scaleYB;
	
	@FXML
	private ImageView videoGame;
	
	@FXML
	private BorderPane rootLayout;
	
	/*
	 * Root 0
	 * LogIn 1
	 * Sign Up 2
	 * Share 3
	 * Textbook & Videogame 4
	 * Overview 5
	 */
	public static int sceneId;

	/* Methods */
	@FXML
	public void initialize() {
		
		translateX = hbox.getTranslateX();
		translateXL = hbox0.getTranslateX();
		scaleXB = textBook.getScaleX();
		scaleYB = textBook.getScaleY();
		
		// Fade
		PauseTransition stayOn = new PauseTransition(Duration.seconds(1));
		
		FadeTransition fade = new FadeTransition(Duration.seconds(1.5), wide0);
		fade.setFromValue(1);
		fade.setToValue(0);
		
		FadeTransition fade1 = new FadeTransition(Duration.seconds(1.5), wide00);
		fade1.setFromValue(0);
		fade1.setToValue(1);
		
		SequentialTransition sequentialTransition = new SequentialTransition();
		sequentialTransition.getChildren().addAll(fade1,fade,stayOn);
		sequentialTransition.setDelay(Duration.seconds(2));
		sequentialTransition.setCycleCount(Timeline.INDEFINITE);
		sequentialTransition.setAutoReverse(true);
		
		sequentialTransition.play();
		// End fade
		
		sceneId = 0;
		
	}
	
	
	@FXML
	public void mouseClickedTextbook(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY && sceneId == 0) { //right mouse button and the translate of hbox is not 0.
			
			sceneId = 4;
			
			FadeTransition ft = new FadeTransition(Duration.millis(800), centerpane);		
			ft.setFromValue(1.0);
			ft.setToValue(0);
			ft.setOnFinished(e -> loadTextBook());
			ft.play();
			
			logoToRight();
			
		} 
		
	}
	
	private void loadTextBook() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ItemList.fxml"));
            itemList = loader.load();           
            ItemListController controller = loader.getController();
            controller.setRoot(this);
			rootLayout.setCenter(itemList);
			FadeInTransition(itemList, 1500);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	@FXML
	public void mouseClickedVideogame(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY && sceneId == 0) { //right mouse button and the translate of hbox is not 0.
			
			sceneId = 4;
			logoToRight();
			
		}
		
	}
	
	@FXML
	public void mouseClickedReturn(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY && sceneId == 1) {
			
			sceneId = 0;
			logoToLeft();
			FadeTransition ft = new FadeTransition(Duration.millis(800), logIn);		
			ft.setFromValue(1.0);
			ft.setToValue(0);
			ft.setOnFinished(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					rootLayout.setCenter(centerpane);
					FadeInTransition(centerpane, 1500);
				}
			});
			ft.play();
			
		} else if( evt.getButton() == MouseButton.PRIMARY && sceneId == 2) {
			
			sceneId = 1;
			FadeTransition ft = new FadeTransition(Duration.millis(800), signUp);		
			ft.setFromValue(1.0);
			ft.setToValue(0);
			ft.setOnFinished(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					rootLayout.setCenter(logIn);
					FadeInTransition(logIn, 1500);
				}
			});
			ft.play();
			
		} else if( evt.getButton() == MouseButton.PRIMARY && sceneId == 3) {
			
			if( ShareController.shareId == 0) {
				sceneId = 0;
				logoToLeft();
				FadeTransition ft = new FadeTransition(Duration.millis(800), share);		
				ft.setFromValue(1.0);
				ft.setToValue(0);
				ft.setOnFinished(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						rootLayout.setCenter(centerpane);
						FadeInTransition(centerpane, 1500);
					}
				});
				ft.play();
				
			} else if (ShareController.shareId == 1) {
				
				shareController.textBookBack();
				
			} else if (ShareController.shareId == 2) {
				
				shareController.videoGameBack();
				
			}
			
		} else if(evt.getButton() == MouseButton.PRIMARY && sceneId == 4) { //right mouse button and the translate of hbox is not 0.
		
			sceneId = 0;
			logoToLeft();
			
			
		}
		
	}
	
	public void signUpCancel() {
		
		sceneId = 1;
		FadeTransition ft = new FadeTransition(Duration.millis(800), signUp);		
		ft.setFromValue(1.0);
		ft.setToValue(0);
		ft.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				rootLayout.setCenter(logIn);
				FadeInTransition(logIn, 1500);
			}
		});
		ft.play();
		
	}
	
	public void logoToRight() {
		
		Timeline timeline = new Timeline();	
		
		KeyValue endValue = new KeyValue(hbox.translateXProperty(), -50); //set transition end position
		KeyFrame endFrame = new KeyFrame(Duration.millis(300), endValue); //set transition end time
		
		timeline.getKeyFrames().add(endFrame); //add endframe to the timeline
		
		timeline.play();
	}
	
	public void logoToLeft() {
		
		Timeline timeline = new Timeline();
		
		KeyValue endValue = new KeyValue(hbox.translateXProperty(), translateX); //set transition end position
		KeyFrame endFrame = new KeyFrame(Duration.millis(300), endValue); //set transition end time
		
		timeline.getKeyFrames().add(endFrame); //add endframe to the timeline
		
		timeline.play();
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
	
	@FXML
	public void mouseEnteredLogo(MouseEvent evt) {
		
		Timeline timeline = new Timeline();
		
		ImageView img = (ImageView)evt.getSource();
		
		KeyValue endValueX = new KeyValue(img.scaleXProperty(), 0.8);
		KeyValue endValueY = new KeyValue(img.scaleYProperty(), 0.8);
		KeyFrame endFrame = new KeyFrame(Duration.millis(200), endValueX, endValueY);
		
		timeline.getKeyFrames().add(endFrame);
		
		timeline.play();
		
	}
	
		
	@FXML
	public void mouseExitedLogo(MouseEvent evt) {
		
		Timeline timeline = new Timeline();
		
		ImageView img = (ImageView)evt.getSource();
		
		KeyValue endValueX = new KeyValue(img.scaleXProperty(), 0.5);
		KeyValue endValueY = new KeyValue(img.scaleYProperty(), 0.5);
		KeyFrame endFrame = new KeyFrame(Duration.millis(200), endValueX, endValueY);
		
		timeline.getKeyFrames().add(endFrame);
		
		timeline.play();
	}
	
	
	@FXML
	public void mouseClickedShare(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY) {
			
			sceneId = 3;
			
			FadeTransition ft = new FadeTransition(Duration.millis(800), centerpane);		
			ft.setFromValue(1.0);
			ft.setToValue(0);
			ft.setOnFinished(e -> loadShare());
			ft.play();
			
			logoToRight();
			
		}
	}
	
	private void loadShare() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Share.fxml"));
            share = loader.load();           
            shareController = loader.getController();
            shareController.setRoot(this);
			rootLayout.setCenter(share);
			FadeInTransition(share, 1500);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	

	
	@FXML
	public void mouseEnteredLogIn(MouseEvent evt) {
		
		Timeline timeline = new Timeline();
		
		KeyValue endValueX = new KeyValue(hbox0.translateXProperty(), 0);
		KeyFrame endFrame = new KeyFrame(Duration.millis(400), endValueX);
		
		timeline.getKeyFrames().add(endFrame);
		
		timeline.play();
		
	}
	
	@FXML
	public void mouseExitedLogIn(MouseEvent evt) {
		
		Timeline timeline = new Timeline();
		
		KeyValue endValueX = new KeyValue(hbox0.translateXProperty(), translateXL);
		KeyFrame endFrame = new KeyFrame(Duration.millis(400), endValueX);
		
		timeline.getKeyFrames().add(endFrame);
		
		timeline.play();
		
	}
	
	@FXML
	public void mouseClickedLogIn(MouseEvent evt) {
		
		if(evt.getButton() == MouseButton.PRIMARY) {
		
			sceneId = 1;
			
			FadeTransition ft = new FadeTransition(Duration.millis(800), centerpane);		
			ft.setFromValue(1.0);
			ft.setToValue(0);
			ft.setOnFinished(e -> loadLogIn());
			ft.play();
			
			logoToRight();
			
		}
		
	}
	
	private void loadLogIn() {
		
		try {
			// Load logIn layout from fxml file.
			//logIn = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            logIn = loader.load();           
            LogInController controller = loader.getController();
            controller.setRoot(this);
			rootLayout.setCenter(logIn);
			FadeInTransition(logIn, 1500);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loadSignUp() {
		try {
			// Load signUp layout from fxml file.
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            signUp = loader.load();           
            SignUpController controller = loader.getController();
            controller.setRoot(this);	
			rootLayout.setCenter(signUp);
			FadeInTransition(signUp, 1500);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void FadeInTransition(Node pane, int time) {
		
		FadeTransition ft = new FadeTransition(Duration.millis(time), pane);	
		ft.setFromValue(0);
		ft.setToValue(1.0);		
		ft.play();
		
	}
	
}
