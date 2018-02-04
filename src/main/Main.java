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
import main.view.RootLayoutController;

public class Main extends Application{

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    public ObservableList<User> userData = FXCollections.observableArrayList();
    public static ObservableList<TextBook> textBookData = FXCollections.observableArrayList();
    public static ObservableList<VideoGame> videoGameData = FXCollections.observableArrayList();
	
    @Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
    	
    		textBookData.add(new TextBook("Control System Engineering", 160, 7, "MECHTRON 3DX4", "This course is hard."));
    		textBookData.get(0).setImg("res/bookCover/textbook1.png");
    		textBookData.add(new TextBook("Operating System", 150, 8, "SFWRENG 3SH3", "This course is hard."));
    		textBookData.get(1).setImg("res/bookCover/textbook2.png");
    		textBookData.add(new TextBook("Algorithms", 120, 4, "SFWRENG 2C03", "This course is hard."));
    		textBookData.get(2).setImg("res/bookCover/textbook3.png");
    		textBookData.add(new TextBook("Operating System", 150, 8, "SFWRENG 3SH3", "This course is hard."));
    		textBookData.get(3).setImg("res/bookCover/textbook2.png");
    		textBookData.add(new TextBook("Algorithms", 120, 4, "SFWRENG 2C03", "This course is hard."));
    		textBookData.get(4).setImg("res/bookCover/textbook3.png");
    		textBookData.add(new TextBook("Control System Engineering", 160, 7, "MECHTRON 3DX4", "This course is hard."));
    		textBookData.get(5).setImg("res/bookCover/textbook1.png");
    		
    		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sharing Project");
        initRootLayout();
        
	}
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
        	
 
            //rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();           
            RootLayoutController controller = loader.getController();
            controller.setMain(this);
            // Show the scene containing the root layout.
            Scene scene0 = new Scene(rootLayout);
            primaryStage.setScene(scene0);
            primaryStage.show();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


}
