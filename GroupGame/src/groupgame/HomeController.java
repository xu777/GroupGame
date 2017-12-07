/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ryanlingxiao
 */
public class HomeController implements Initializable, ControlledScreen {

    ScreenController myController;
    GameController gameController;

    @FXML
    private VBox vb;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnQuit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameController = new GameController();
    }

    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent;
    }

    @FXML
    private void newButtonAction(ActionEvent event) {
        myController.setScreen(GroupGame.newOptionID);
    }//new button

    @FXML
    private void loadButtonAction(ActionEvent event) {
        System.out.println("Load function in working");
    }//load button

    @FXML
    private void quitButtonAction(ActionEvent event) {
        Stage stage = (Stage) btnQuit.getScene().getWindow();
        stage.close();

    }//exit button

}
