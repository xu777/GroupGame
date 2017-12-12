/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author ryanlingxiao
 */
public class GameMainController implements Initializable, ControlledScreen {

    ScreenController myController;

    @FXML
    private Button btnNorth;
    @FXML
    private Button btnSouth;
    @FXML
    private Button btnEast;
    @FXML
    private Button btnWest;
    @FXML
    private ToggleButton tbRoom;
    @FXML
    private ToggleButton tbMap;
    @FXML
    private BorderPane mapBox = new BorderPane();
    @FXML
    private AnchorPane mapPane = new AnchorPane();
    @FXML
    private AnchorPane roomPane = new AnchorPane();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbRoom.setSelected(true);
        roomShow();
    }

    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent;
    }

//    public void newMap() {
//        mapSize = 8;//preset map size as small
//        
//        setMap(mapSize);
//    }
//
    @FXML
    public void mapShow() {
        mapPane.setOpacity(1);
        roomPane.setOpacity(0);
        GroupGame.gameController.refreshMapPane();
        mapBox.setCenter(GroupGame.gameController.mapPane);
    }

    @FXML
    public void roomShow() {
        mapPane.setOpacity(0);
        roomPane.setOpacity(1);
    }
    
    @FXML
    private void homeButtonAction(ActionEvent event) {

        myController.setScreen(GroupGame.homeScreenID);
    }//home button action ends
}
