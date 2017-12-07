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

/**
 * FXML Controller class
 *
 * @author ryanlingxiao
 */
public class NewOptionController implements Initializable, ControlledScreen {

    ScreenController myController;

//players
    @FXML
    private ToggleButton tb1ply;
    @FXML
    private ToggleButton tb2ply;
    @FXML
    private ToggleButton tb3ply;
    @FXML
    private ToggleButton tb4ply;

//map size
    @FXML
    private ToggleButton tbSmall;
    @FXML
    private ToggleButton tbMed;
    @FXML
    private ToggleButton tbLarge;

// home and next
    @FXML
    private Button btnNext;
    @FXML
    private Button btnHome;

    private int numOfPlayers;
    private int mapSize;
    private final int SMALL = 4;
    private final int MEDIUM = 6;
    private final int LARGE = 8;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent;
    }

    @FXML
    private void homeButtonAction(ActionEvent event) {
        myController.setScreen(GroupGame.homeScreenID);
    }//home button action ends

    @FXML
    private void nextButtonAction(ActionEvent event) {

//        tb2ply.setUserData(2);
        if (tb1ply.isSelected() == true) {
            numOfPlayers = 1;
        } else if (tb2ply.isSelected() == true) {
            numOfPlayers = 2;
        } else if (tb3ply.isSelected() == true) {
            numOfPlayers = 3;
        } else if (tb4ply.isSelected() == true) {
            numOfPlayers = 4;
        }

        if (tbSmall.isSelected() == true) {
            mapSize = SMALL;
        } else if (tbMed.isSelected() == true) {
            mapSize = MEDIUM;
        } else if (tbLarge.isSelected() == true) {
            mapSize = LARGE;
        }

        GroupGame.gameController = new GameController(numOfPlayers, mapSize);
        GroupGame.gameController.printMap();// test line - print map
        myController.setScreen(GroupGame.createPlayerID);
    }//next-> start a new game based on selection 
}
