/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author hehnd
 */
public class BattleScreenController implements Initializable {

    @FXML
    private Pane Root;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane anch1;
    @FXML
    private SplitPane splitMain;
    @FXML
    private AnchorPane anch2;
    @FXML
    private VBox vbox1;
    @FXML
    private HBox h1;
    @FXML
    private Label enemyNameOne;
    @FXML
    private Label EnemyNameTwo;
    @FXML
    private HBox h2;
    @FXML
    private Label EnemyNameThree;
    @FXML
    private Label EnemyNameFour;
    @FXML
    private HBox h3;
    @FXML
    private Label EnemyNameFive;
    @FXML
    private Label EnemyNameSix;
    @FXML
    private AnchorPane anch3;
    @FXML
    private VBox Vbox3;
    @FXML
    private HBox h4;
    @FXML
    private Label PlayerName1;
    @FXML
    private Label Player1Frac;
    @FXML
    private ProgressBar Player1Health;
    @FXML
    private HBox h5;
    @FXML
    private Label PlayerName2;
    @FXML
    private Label Player2Frac;
    @FXML
    private ProgressBar Player2Health;
    @FXML
    private HBox h6;
    @FXML
    private Label PlayerName3;
    @FXML
    private Label Player3Frac;
    @FXML
    private ProgressBar Player3Health;
    @FXML
    private HBox h7;
    @FXML
    private Label PlayerName4;
    @FXML
    private Label Player4Frac;
    @FXML
    private ProgressBar Player4Health;
    
     @FXML
    private StackPane stackMenu;

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackMenu.setVisible(false);
       // BattlseScreenController.setPlayerName1 = p1.getName();
       // BattlseScreenController.setPlayerName2 = p2.getName();
       // BattlseScreenController.setPlayerName3 = p3.getName();
        //BattlseScreenController.setPlayerName4 = p4.getName();
        
        
        // TODO
    }    

    public BattleScreenController(Label PlayerName1, Label PlayerName2, Label PlayerName3, Label PlayerName4) {
        this.PlayerName1 = PlayerName1;
        this.PlayerName2 = PlayerName2;
        this.PlayerName3 = PlayerName3;
        this.PlayerName4 = PlayerName4;
    }
    
    /*public BattleScreenController(Label Player1Frac, Label Player2Frac Label Player3Frac, Label Player4Frac) {
        this.Player1Frac = Player1Frac;
        this.Player2Frac = Player2Frac;
        this.Player3Frac = Player3Frac;
        this.Player4Frac = Player4Frac;
        
    }
    
   */

    public BattleScreenController(ProgressBar Player1Health, ProgressBar Player2Health, ProgressBar Player3Health, ProgressBar Player4Health) {
        this.Player1Health = Player1Health;
        this.Player2Health = Player2Health;
        this.Player3Health = Player3Health;
        this.Player4Health = Player4Health;
    }

    public Label getPlayer1Frac() {
        return Player1Frac;
    }

    public void setPlayer1Frac(Label Player1Frac) {
        this.Player1Frac = Player1Frac;
    }

    public Label getPlayer2Frac() {
        return Player2Frac;
    }

    public void setPlayer2Frac(Label Player2Frac) {
        this.Player2Frac = Player2Frac;
    }

    public Label getPlayer3Frac() {
        return Player3Frac;
    }

    public void setPlayer3Frac(Label Player3Frac) {
        this.Player3Frac = Player3Frac;
    }

    public Label getPlayer4Frac() {
        return Player4Frac;
    }

    public void setPlayer4Frac(Label Player4Frac) {
        this.Player4Frac = Player4Frac;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    

    public Label getPlayerName1() {
        return PlayerName1;
    }

    public void setPlayerName1(Label PlayerName1) {
        this.PlayerName1 = PlayerName1;
    }

    public Label getPlayerName2() {
        return PlayerName2;
    }

    public void setPlayerName2(Label PlayerName2) {
        this.PlayerName2 = PlayerName2;
    }

    public Label getPlayerName3() {
        return PlayerName3;
    }

    public void setPlayerName3(Label PlayerName3) {
        this.PlayerName3 = PlayerName3;
    }

    public Label getPlayerName4() {
        return PlayerName4;
    }

    public void setPlayerName4(Label PlayerName4) {
        this.PlayerName4 = PlayerName4;
    }
    
    
    
    
    
    
    
    

    public ProgressBar getPlayer1Health() {
        return Player1Health;
    }

    public void setPlayer1Health(ProgressBar Player1Health) {
        this.Player1Health = Player1Health;
    }

    public ProgressBar getPlayer2Health() {
        return Player2Health;
    }

    public void setPlayer2Health(ProgressBar Player2Health) {
        this.Player2Health = Player2Health;
    }

    public ProgressBar getPlayer3Health() {
        return Player3Health;
    }

    public void setPlayer3Health(ProgressBar Player3Health) {
        this.Player3Health = Player3Health;
    }

    public ProgressBar getPlayer4Health() {
        return Player4Health;
    }

    public void setPlayer4Health(ProgressBar Player4Health) {
        this.Player4Health = Player4Health;
    }
    
  
    
}
