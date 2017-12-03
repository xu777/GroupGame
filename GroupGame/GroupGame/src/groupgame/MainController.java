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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author ryanlingxiao
 */
public class MainController implements Initializable {
    
    
    @FXML
    private void newGameClick(ActionEvent event) throws IOException {
        Parent choose_characters_parent =  FXMLLoader.load(getClass().getResource("NewOption.fxml"));
        Scene ChooseCharacters = new Scene(choose_characters_parent);
        Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(ChooseCharacters);
        stage2.setTitle("New Game");
        stage2.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
