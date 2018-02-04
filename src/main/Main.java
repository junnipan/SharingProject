package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.model.TextBook;
import main.model.User;
import main.model.VideoGame;

public class Main extends Application{

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    private ObservableList<User> userData = FXCollections.observableArrayList();
    private ObservableList<TextBook> textBookData = FXCollections.observableArrayList();
    private ObservableList<VideoGame> videoGameData = FXCollections.observableArrayList();
	
    @Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
    	
    		textBookData.add(new TextBook("Control System Engineering", 160, 7, "MECHTRON 3DX4", "This course is hard."));
    		textBookData.get(0).setImg("res/bookCover/textbook1.png");
    		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sharing Project");
        initRootLayout();
        
	}
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
        	
        		/*FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/LogIn.fxml")); 			
			logIn = (AnchorPane) loader.load();
        		Scene scene0 = new Scene(logIn);*/
            // Load root layout from fxml file.
            rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));

            // Show the scene containing the root layout.
            Scene scene0 = new Scene(rootLayout);
            primaryStage.setScene(scene0);
            primaryStage.show();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


}
