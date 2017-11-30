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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hehnd
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button NewGame;
    @FXML
    private Button Continue;
    
    @FXML
    void onNewGameAction(ActionEvent event) throws IOException {
        Parent choose_characters_parent =  FXMLLoader.load(getClass().getResource("CreatePlayers.fxml"));
        Scene ChooseCharacters = new Scene(choose_characters_parent);
        Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(ChooseCharacters);
        stage2.setTitle("Create");
        stage2.show();
        
       
       
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void onContinueAction(ActionEvent event) {
    }
    
}
