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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hehnd
 */
public class DungeonRoomController implements Initializable {
    private int sleepCounter = 0;
    private int searchCounter = 0;
    private int lootCounter =0 ;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    void clickSleep(ActionEvent event) throws IOException {
        if (sleepCounter < 1) {
            sleepCounter++;
            
         //  Player.hitPoints.setHitPoints(Player.getHitPoints() + 1);
         //  Player.hitPoints.setHitPoints(Player.getHitPoints() + 1);
         //  Player.hitPoints.setHitPoints(Player.getHitPoints() + 1);
          // Player.hitPoints.setHitPoints(Player.getHitPoints() + 1);
           
           Random rand = new Random();
           int x = rand.nextInt(6);
           if (x  == 1){
              Battle battle = new Battle();
                Parent choose_characters_parent =  FXMLLoader.load(getClass().getResource("BattleScreen.fxml"));
                Scene ChooseCharacters = new Scene(choose_characters_parent);
                Stage stage3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage3.setScene(ChooseCharacters);
                stage3.setTitle("Fight!");
                stage3.show(); 
           }
        }
    }

    @FXML
    void clickSearch(ActionEvent event) {
        if (searchCounter < 1){
            searchCounter++;
            
            
            
            
        }

    }
    
    @FXML
    void clickLoot(ActionEvent event) {
        if (lootCounter < 1) {
            lootCounter++;
          //  int z =   room.getBattleNum;
       //     if (Room.BattleNum == 0){  
        //    }
     //   else {
       //      Enemy.getArmor
        //     Enemy.getWeapon
       // }
        
        
        
        }
   }

    @FXML
    void OpenInventory(ActionEvent event) throws IOException {
         Parent choose_characters_parent =  FXMLLoader.load(getClass().getResource("StatusScreen.fxml"));
         Scene ChooseCharacters = new Scene(choose_characters_parent);
         Stage stage3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
         stage3.setScene(ChooseCharacters);
         stage3.setTitle("Status");
         stage3.show(); 
    }
    
    private static class Battle {

        public Battle() {
            
            
        }
    }
     
}
