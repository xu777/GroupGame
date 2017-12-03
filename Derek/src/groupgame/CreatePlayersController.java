/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hehnd
 */
public class CreatePlayersController implements Initializable {
    
     private int playerNumber = 0;
     
         Player p1 = new Player();
         Player p2 = new Player();
         Player p3 = new Player();
         Player p4 = new Player();


    @FXML
    private StackPane StackPane1;
    @FXML
    private ToggleButton Player1;
    @FXML
    private ToggleGroup togglePlayers;
    @FXML
    private ToggleButton Player2;
    @FXML
    private ToggleButton Player3;
    @FXML
    private ToggleButton Player4;
    @FXML
    private Button Continue2;
    @FXML
    private StackPane StackPane2;
   
    
    @FXML
    private Tab tab1;
    @FXML
    private AnchorPane playAnch1;
    @FXML
    private Label nameLabel;
    @FXML
    private Label nameLabel2;
    @FXML
    private Label nameLabel3;
    @FXML
    private Label nameLabel4;
    
    
    @FXML
    private TextField pName1;
    @FXML
    private TextField pName2;
    @FXML
    private TextField pName3;
    @FXML
    private TextField pName4;
   
    @FXML
    private Button EnterNameButton1;
    @FXML
    private Button EnterNameButton2;
    @FXML
    private Button EnterNameButton3;
    @FXML
    private Button EnterNameButton4;
    @FXML
    private Button rollStats;
    @FXML
    private Label strengthNumView;
    @FXML
    private Label wisdomNumView;
    @FXML
    private Label agilityNumView;
    @FXML
    private ToggleButton fighterClassButton;
    @FXML
    private ToggleGroup toggle2;
    @FXML
    private ToggleButton wizardClassButton;
    @FXML
    private ToggleButton thiefClassButton;
    @FXML
    private Tab tab2;
    @FXML
    private ToggleGroup toggle3;
    @FXML
    private Tab tab3;
    @FXML
    private ToggleGroup toggle4;
    @FXML
    private Tab tab4;
    @FXML
    private ToggleGroup toggle5;
    @FXML
    private Button startGameButton;
    @FXML
    private StackPane StackPane3;
    @FXML
    private TabPane TabPane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TabPane.setVisible(false);
        StackPane2.setVisible(false);
    }    

    @FXML
    private void onContinue2(ActionEvent event) {
            
         if (Player1.isSelected()){
            playerNumber = 1; 
        }
        else if (Player2.isSelected()) {
            playerNumber = 2;
            tab2.setDisable(false);
        }
        else if (Player3.isSelected()) {
            playerNumber = 3;
             tab2.setDisable(false);
             tab3.setDisable(false);   
        }
        else if (Player4.isSelected()){
            playerNumber = 4; 
             tab2.setDisable(false);
             tab3.setDisable(false);
             tab4.setDisable(false);  
        } 
           if (playerNumber > 0 ){
                StackPane2.setVisible(true);
                TabPane.setVisible(true);
                StackPane3.setVisible(false);
           }
    }

    @FXML 
    private void setName1(ActionEvent event) {
        nameLabel.setText(pName1.getText());
        p1.setName(pName1.getText());
        
    }
    
    @FXML
    private void setName2(ActionEvent event) {
            nameLabel2.setText(pName2.getText());
            p2.setName(pName2.getText());
    }

    @FXML
    private void setName3(ActionEvent event) {
            nameLabel3.setText(pName3.getText());
            p3.setName(pName3.getText());
    }

    @FXML
    private void setName4(ActionEvent event) {
            nameLabel4.setText(pName4.getText());
            p4.setName(pName4.getText());
            
    }
    
    
    @FXML
    private void handleRollStats(ActionEvent event) {
        p1.setAgility(RollStats());
        p1.setStrength(RollStats());
        p1.setWisdom(RollStats());
        strengthNumView.setText(Integer.toString(p1.getStrength()));
       // agilityNumView.setText();
       // wisdomNumView.setText();
        
        
        
    }
    
    @FXML
    private void handleRollstats2(ActionEvent event) {

    }

    @FXML
    private void handleRollStats3(ActionEvent event) {

    }

   @FXML
    private void handleRollStats4(ActionEvent event) {

    }
    
    
    

    @FXML
    private void startGame(ActionEvent event) throws IOException  {
       if (p1.equals("null") ){
             
       }
       else {
        Parent choose_characters_parent =  FXMLLoader.load(getClass().getResource("DungeonRoom.fxml"));
        Scene ChooseCharacters = new Scene(choose_characters_parent);
        Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(ChooseCharacters);
        stage2.setTitle("Room");
        stage2.show(); 
        
       }
    }   

    public int RollStats() {
         int i = 0;
         int x = 0;
         Random rand3 = new Random();
            while(i < 3){
                  x += rand3.nextInt(6)+ 1;
                 i++;
            }
         return x;          
    }
}
