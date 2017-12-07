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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author ryanlingxiao
 */
public class CreatePlayerController implements Initializable, ControlledScreen {

    ScreenController myController;

    @FXML
    private Button btnHome;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnReroll;
//map size
    @FXML
    private ToggleButton tbFighter;
    @FXML
    private ToggleButton tbThief;
    @FXML
    private ToggleButton tbWizard;

    @FXML
    private Label lbPlayerNum;
    @FXML
    private Label hpValue;
    @FXML
    private Label strValue;
    @FXML
    private Label wisValue;
    @FXML
    private Label agiValue;
    @FXML
    private TextField tfName;

    private int index;
    private int str;
    private int wis;
    private int hp;
    private int agi;
    private Players[] players;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbPlayerNum.setText("#1");
        index = 1;
        hp = 20;
        roll();         //initialize player 1 value, all attributes are rolled except hp.
    }

    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent;
    }

    @FXML
    private void homeButtonAction(ActionEvent event) {
        myController.setScreen(GroupGame.homeScreenID);
    }//end home button

    @FXML
    private void rerollButtonAction(ActionEvent event) {
        roll();
    }//re-roll  Dice for better attributes

    @FXML
    private void nextButtonAction(ActionEvent event) {
        System.out.println(index);
        if (index == 1){//create new player group when index
        players = new Players[GroupGame.gameController.numOfPlayers];}
        
        players[index-1] = new Players(tfName.getText(), hp, str, wis, agi);//add player to player array on each click
        
        if (index <= GroupGame.gameController.numOfPlayers - 1) {
            
            players[index-1].printPlayer();
            
            index++;
            System.out.println(index);
            lbPlayerNum.setText("#" + index);
        } else {//after last player added 
            //print
            players[index-1].printPlayer();
            
            // reset text and index
            lbPlayerNum.setText("#" + 1);
            index = 1;
            
            //set players array to game controller.
            GroupGame.gameController.setPlayers(players);
            //show next screen
            myController.setScreen(GroupGame.mapScreenID);
        }
    }

    private void setText() {
        hpValue.setText(Integer.toString(hp));
        strValue.setText(Integer.toString(str));
        wisValue.setText(Integer.toString(wis));
        agiValue.setText(Integer.toString(agi));
    }//set text based on private vlaues;

    private void roll() {
        Dice dice = new Dice();
        hp = 20;
        str = dice.roll(3, 6);
        wis = dice.roll(3, 6);
        agi = dice.roll(3, 6);
        setText();
    }//roll dice and set text
}
