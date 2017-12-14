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
import javax.swing.JOptionPane;

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
    private Label lbHpValue;
    @FXML
    private Label lbStrValue;
    @FXML
    private Label lbWisValue;
    @FXML
    private Label lbAgiValue;
    @FXML
    private Label lbSkillName;
    @FXML
    private TextField tfName;

    private int index;
    private int str, tempstr;
    private int wis, tempwis;
    private int hp;
    private int agi, tempagi;
    private Charactors[] players;
    private int role;
    String skillTitle;
    String roleTitle;

    public static final int FIGHTER = 1;
    public static final int THIEF = 2;
    public static final int WIZARD = 3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbPlayerNum.setText("#1");
        tbFighter.setSelected(true);
        index = 0;
        hp = 20;
        roll();
        tempstr = +3;
        tempwis = - 3;
        tempagi = 0;
        setText();
        //initialize player 1 value, all attributes are rolled except hp.
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
    private void fighterButtonAction(ActionEvent event) {
        tbFighter.setSelected(true);
        role = FIGHTER;
        roleTitle = "Fighter";
        skillTitle = "Bash";
        lbSkillName.setText(skillTitle);
        tempstr = +3;
        tempwis = - 3;
        tempagi = 0;
        setText();
    }//re-roll  Dice for better attributes

    @FXML
    private void thiefButtonAction(ActionEvent event) {
        tbThief.setSelected(true);
        role = THIEF;
        roleTitle = "Thief";
        skillTitle = "Steal";
        lbSkillName.setText(skillTitle);
        tempstr = - 2;
        tempwis = +2;
        tempagi = +3;
        setText();
    }//re-roll  Dice for better attributes

    @FXML
    private void wizardButtonAction(ActionEvent event) {
        tbWizard.setSelected(true);
        role = WIZARD;
        roleTitle = "Wizard";
        skillTitle = "Fireball";
        lbSkillName.setText(skillTitle);
        tempstr = - 5;
        tempwis = +5;
        tempagi = - 3;
        setText();
    }//re-roll  Dice for better attributes

    @FXML
    private void nextButtonAction(ActionEvent event) {
        int numOfPlayers = GroupGame.gameController.getNumOfPlayers();
        System.out.println("Player: #" + (index + 1));
        if (!"".equals(tfName.getText()) && (tbFighter.isSelected() || tbThief.isSelected() || tbWizard.isSelected())) {
            if (index == 0) {//create new player group when index
                players = new Charactors[numOfPlayers];
            }
            players[index] = new Charactors();
            players[index].CreateCharactors(index, tfName.getText(), hp, str + tempstr, wis + tempwis, agi + tempagi, role);//add player to player array on each click
            players[index].printPlayer();

            if (index < numOfPlayers - 1) {
                index++;
                lbPlayerNum.setText("#" + (index+1));
            } else {//after last player added 

                // reset text and index
                lbPlayerNum.setText("#" + 1);
                index = 0;

                //set players array to game controller.
                GroupGame.gameController.setPlayers(players);
                //show next screen
                myController.setScreen(GroupGame.MapScreenID);
            }
            roll();
        } else {
            JOptionPane.showMessageDialog(null, "Please enter the name and pick a job.");
        }
    }

    private void setText() {
        lbHpValue.setText(Integer.toString(hp));
        lbStrValue.setText(Integer.toString(str + tempstr));
        lbWisValue.setText(Integer.toString(wis + tempwis));
        lbAgiValue.setText(Integer.toString(agi + tempagi));
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
