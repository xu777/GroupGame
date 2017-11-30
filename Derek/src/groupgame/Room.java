/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;


import java.io.IOException;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hehnd
 */




public class Room {
    
    private int encounter;
    private int battleNum = 0;

    
    public Room () throws IOException{
        
        Random rand2 = new Random();
        encounter = rand2.nextInt(10);
        if (encounter <= 8){
        
    //    Parent choose_characters_parent =  FXMLLoader.load(getClass().getResource("BattleScreen.fxml"));
    //    Scene ChooseCharacters = new Scene(choose_characters_parent);
    //    Stage stage4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
     //   stage4.setScene(ChooseCharacters);
     //   stage4.setTitle("Fight!");
     //   stage4.show(); 
         
    }
    
}

    public int getBattleNum() {
        return battleNum;
    }
    
}
  
