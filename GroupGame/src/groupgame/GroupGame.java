/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ryanlingxiao
 */
public class GroupGame extends Application {

    //setting screen names
    public static String homeScreenID = "Home";
    public static String homeScreenFile = "Home.fxml";
    public static String newOptionID = "NewOption";
    public static String newOptionFile = "NewOption.fxml";
    public static String createPlayerID = "CreatePlayer";
    public static String createPlayerFile = "CreatePlayer.fxml";
    public static String mapScreenID = "MapScreen";
    public static String mapScreenFile = "MapScreen.fxml";
    public static GameController gameController;

    //getting screen size
//    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//    public int screenWidth = gd.getDisplayMode().getWidth();
//    public int screenHeight = gd.getDisplayMode().getHeight();
    
    @Override
    public void start(Stage primaryStage){
//        if (screenWidth >= 414) {
//            screenWidth = 414;
//        }
//        if (screenHeight >= 736) {
//           screenHeight = 736;
//        }//preset stage/scene size

        //System.out.println(Integer.toString(screenWidth) + Integer.toString(screenHeight));
        ScreenController mainContainer = new ScreenController();
        mainContainer.loadScreen(GroupGame.homeScreenID, GroupGame.homeScreenFile);
        mainContainer.loadScreen(GroupGame.newOptionID, GroupGame.newOptionFile);
        mainContainer.loadScreen(GroupGame.createPlayerID, GroupGame.createPlayerFile);
        mainContainer.loadScreen(GroupGame.mapScreenID, GroupGame.mapScreenFile);
        mainContainer.setScreen(GroupGame.homeScreenID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
