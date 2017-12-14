/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import queues.LinkedDequeue;

/**
 * FXML Controller class
 *
 * @author ryanlingxiao
 */
public class MapController implements Initializable, ControlledScreen {

    ScreenController myController;
    private int numOfPlayers;
    private int numOfEnemies;
    private Rooms[][] map;
    private int coordX;
    private int coordY;
    private int mapSize;
    private Charactors[] players;
    private Charactors[] enemies;
    private int livePlayers;
    private int liveEnemies;
    private int round;
    private Charactors[] battleparties;
    private int targetID;
    private int onActionID;

    Battle battle;

    @FXML
    private ToggleButton tbRoom;
    @FXML
    private ToggleButton tbMap;

    private Button btnStart;

    private HBox hbActionBtns;
    private ToggleButton tbAttack;
    private ToggleButton tbSkill;
    private ToggleButton tbRunAway;
    private ToggleButton tbHide;
    private Button btnExcute;
    private GridPane gpCharactorBox;
    private ToggleButton[] tbPlayers;
    private ToggleButton[] tbEnemies;

    private Button btnNorth;
    private Button btnSouth;
    private Button btnEast;
    private Button btnWest;

    public static final int ATTACK = 1;
    public static final int SKILL = 2;
    public static final int RUN_AWAY = 3;
    public static final int HIDE = 4;

    @FXML
    private BorderPane gameBox = new BorderPane();
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    private int choice;
    LinkedDequeue battleQueue = new LinkedDequeue<Charactors>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbRoom.setSelected(true);
        tbMap.setSelected(false);
        lbClear();
        lb1.setText("Welcome to game");
        iniAction();
        firstRoom();
    }

    public void setScreenParent(ScreenController screenParent) {
        myController = screenParent;
    }

    @FXML
    public void mapBtnAction(ActionEvent event) {
        iniDirectionBtns(); // initiate direction buttons
        tbMap.setSelected(true);
        lbClear();
        loadMap();
    }//refresh the map pane and show it in the window

    @FXML
    public void roomBtnAction() {
        tbRoom.setSelected(true);
        lbClear();
        iniAction();
        iniCharactors();
        EnterRoom(coordX, coordY);
        showRoom();
    }

    @FXML
    private void homeButtonAction(ActionEvent event) {

        myController.setScreen(GroupGame.homeScreenID);
        clearBox();
        firstRoom();
    }//home button action ends

    private void refreshDirectionBtn() {
        if (cantGoNorth()) {
            btnNorth.setDisable(true);
        } else {
            btnNorth.setDisable(false);
        }

        if (cantGoSouth()) {
            btnSouth.setDisable(true);
        } else {
            btnSouth.setDisable(false);
        }
        if (cantGoWest()) {
            btnWest.setDisable(true);
        } else {
            btnWest.setDisable(false);
        }
        if (cantGoEast()) {
            btnEast.setDisable(true);
        } else {
            btnEast.setDisable(false);
        }
    }

    private boolean isInBattle(int coordX, int coordY) {
        return map[coordX][coordY].isClear();
    }

    private boolean cantGoWest() {
        return coordX == 0 || isInBattle(coordX, coordY);
    }

    private boolean cantGoEast() {
        return coordX == mapSize - 1 || isInBattle(coordX, coordY);
    }

    private boolean cantGoNorth() {
        return coordY == 0 || isInBattle(coordX, coordY);
    }

    private boolean cantGoSouth() {
        return coordY == mapSize - 1 || isInBattle(coordX, coordY);
    }

    private void moveNorth() {
        coordY--;
        GroupGame.gameController.setCoordY(coordY);
        loadMap();
        System.out.println("Moved East");
    }

    private void moveSouth() {
        coordY++;
        GroupGame.gameController.setCoordY(coordY);
        loadMap();
        System.out.println("Moved West");
    }

    private void moveWest() {
        coordX--;
        GroupGame.gameController.setCoordX(coordX);
        loadMap();
        System.out.println("Moved South");
    }

    private void moveEast() {
        coordX++;
        GroupGame.gameController.setCoordX(coordX);
        loadMap();
        System.out.println("Moved North");
    }

    private void showCoordInLable() {
        lb1.setText("Room: (" + coordX + "," + coordY + ")");
    }

    private void showClearInLable() {
        String status;
        if (GroupGame.gameController.isClear(coordX, coordY)) {
            status = "Pick a room to move";
        } else {
            status = "You can't move before clear";
        }
        lb2.setText(status);
    }

    private void setNeighbourAvailabe() {
        if (!cantGoWest()) {// if it can go W, able the room after move
            GroupGame.gameController.setRoomDisable(coordX - 1, coordY, false);
        }
        if (!cantGoEast()) {// if it can go E, able the room after move
            GroupGame.gameController.setRoomDisable(coordX + 1, coordY, false);
        }
        if (!cantGoSouth()) {// if it can go Sourth, able the room after move
            GroupGame.gameController.setRoomDisable(coordX, coordY + 1, false);
        }
        if (!cantGoNorth()) {// if it can go North, able the room after move
            GroupGame.gameController.setRoomDisable(coordX, coordY - 1, false);
        }
    }

    private void iniDirectionBtns() {
        btnNorth = new Button("N");
        btnNorth.setStyle("-fx-font: 16 arial");
        btnNorth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                moveNorth();
            }
        });
        btnSouth = new Button("S");
        btnSouth.setStyle("-fx-font: 16 arial");
        btnSouth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                moveSouth();
            }
        });
        btnWest = new Button("W");
        btnWest.setStyle("-fx-font: 16 arial");
        btnWest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                moveWest();
            }
        });
        btnEast = new Button("E");
        btnEast.setStyle("-fx-font: 16 arial");
        btnEast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                moveEast();
            }
        });

    }

    private void loadMap() {
        this.mapSize = GroupGame.gameController.getMapSize();
        this.map = GroupGame.gameController.getMap();
        this.coordX = GroupGame.gameController.getCoordX();
        this.coordY = GroupGame.gameController.getCoordY();

        //set cuurent available, refresh direction btns, then show status in labels. Room next to curret are also able to click on pane. 
        GroupGame.gameController.setRoomDisable(coordX, coordY, false);
        refreshDirectionBtn();
        showCoordInLable();
        showClearInLable();
        setNeighbourAvailabe();
        GroupGame.gameController.refreshMapPane();
        gameBox.setCenter(GroupGame.gameController.mapPane);
        gameBox.setTop(btnNorth);
        gameBox.setBottom(btnSouth);
        gameBox.setLeft(btnWest);
        gameBox.setRight(btnEast);
        gameBox.setAlignment(btnNorth, Pos.CENTER);
        gameBox.setAlignment(btnSouth, Pos.CENTER);
        gameBox.setAlignment(btnWest, Pos.CENTER);
        gameBox.setAlignment(btnEast, Pos.CENTER);
    }

    private void firstRoom() {//first room choice
        EnterRoom(0, 0);
    }

    private void EnterRoom(int CoordX, int CoordY) {//first room choice
        this.battle = new Battle();
        this.coordX = CoordX;
        this.coordY = CoordY;

        btnStart = new Button("Start");
        btnStart.setStyle("-fx-font: 16 arial");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                occourEnemy();
                iniCharactors();
                clearBox();
                showRoom();

                livePlayers = players.length;
                liveEnemies = enemies.length;
                onActionID = 0;
                targetID = 100;
                battleparties = battle.getBattleparties(players, enemies);
                boolean ranaway = false;

                Arrays.sort(battleparties);

                for (Charactors battleparty : battleparties) {
                    if (battleparty.isAlive()) {
                        battleQueue.AddToFront(battleparty);
                    }
                }
                battleNext(1);
                System.out.println("Entered First Room");
            }
        });
        gameBox.setCenter(btnStart);
    }

    private void iniAction() {
        //hbox contains 4 toggle button action choices
        this.hbActionBtns = new HBox();

        choice = 1;

        hbActionBtns.setSpacing(8);
        hbActionBtns.setStyle("-fx-background-color: #afb9c9;");
        hbActionBtns.setPadding(new Insets(15, 12, 15, 12));
        ToggleGroup tgAction = new ToggleGroup();

        tbAttack = new ToggleButton("Attack");
        tbAttack.setToggleGroup(tgAction);
        tbAttack.getStyleClass().add("tbStyle");
        tbAttack.setSelected(true);
        tbAttack.setUserData(ATTACK);
        tbAttack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                battle.setActionString("attacked");
                choice = 1;
            }
        });

        tbSkill = new ToggleButton("Bash");
        tbSkill.setToggleGroup(tgAction);
        tbSkill.getStyleClass().add("tbStyle");
        tbSkill.setUserData(SKILL);
        tbSkill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                battle.setActionString("casted skill on");
                choice = 2;
            }
        });

        tbRunAway = new ToggleButton("Run");
        tbRunAway.setToggleGroup(tgAction);
        tbRunAway.getStyleClass().add("tbStyle");
        tbRunAway.setUserData(RUN_AWAY);
        tbRunAway.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                battle.setActionString("ran away");
                choice = 3;
            }
        });

        tbHide = new ToggleButton("Hide");
        tbHide.setToggleGroup(tgAction);
        tbHide.getStyleClass().add("tbStyle");
        tbHide.setUserData(HIDE);
        tbHide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                battle.setActionString("hid");
                choice = 4;
            }
        });

        //button excute action
        btnExcute = new Button("");
        btnExcute.getStyleClass().add("goStyle");
        btnExcute.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                battle.action(onActionID, targetID, choice);
                enemies = battle.getEnemies();
                if (enemies[targetID - 100].getHitPoints() < 0) {
                    tbEnemies[targetID - 100].setDisable(true);
                    tbEnemies[targetID - 100].setSelected(false);
                    btnExcute.setDisable(true);
                    liveEnemies--;
                }
                if (liveEnemies == 0) {
                    System.out.println("Battle won!");
                }
                showEnemy(targetID);
                battleNext(round);
            }
        });

        hbActionBtns.getChildren().addAll(tbAttack, tbSkill, tbRunAway, tbHide, btnExcute);

    }//initiated action buttons here.

    private void iniCharactors() {
        this.gpCharactorBox = new GridPane();
        this.numOfPlayers = GroupGame.gameController.getNumOfPlayers();
        this.players = GroupGame.gameController.getPlayers();

        ToggleGroup tgPlayers = new ToggleGroup();
        tbPlayers = new ToggleButton[numOfPlayers];

        for (int index = 0; index < numOfPlayers; index++) {
            ToggleButton tempPlayer = new ToggleButton();
            tempPlayer.setToggleGroup(tgPlayers);
            tempPlayer.setMnemonicParsing(false);
            tempPlayer.setPrefSize(120, 50);
            tempPlayer.setUserData(index);
            tempPlayer.getStyleClass().add("battlePly");
            //disabled: manually select onAction Player
            tempPlayer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    tempPlayer.setSelected(!tempPlayer.isSelected());
                }
            });
            tbPlayers[index] = tempPlayer;
            int position = 4 - numOfPlayers + index;
            players[index].setId(index);
            gpCharactorBox.add(tbPlayers[index], 1, position, 1, 1);
        }

        battle.setActionString("attacked");
        battle.setPlayers(players);
        battle.setNumOfPlayers(numOfPlayers);

        Label vs = new Label("vs.");
        vs.getStyleClass().add("lbVs");
        vs.setPrefSize(120, 50);
        vs.setTextAlignment(TextAlignment.CENTER);
        gpCharactorBox.add(vs, 2, 3, 1, 1);

        this.numOfEnemies = battle.getNumOfEnemies();
        ToggleGroup tgEnemies = new ToggleGroup();
        tbEnemies = new ToggleButton[numOfEnemies];

        for (int index = 0; index < numOfEnemies; index++) {
            ToggleButton tempEnemy = new ToggleButton();

            tempEnemy.setToggleGroup(tgEnemies);
            tempEnemy.setMnemonicParsing(false);
            tempEnemy.setPrefSize(120, 50);
            tempEnemy.setUserData(index + 100);
            tempEnemy.getStyleClass().add("Enemy");

            tempEnemy.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    int id = (Integer) tempEnemy.getUserData();
                    tempEnemy.setSelected(true);
                    targetID = id;
                    btnExcute.setDisable(false);
                    showEnemy(id);
                }
            });
            tbEnemies[index] = tempEnemy;
            int position = 6 - numOfEnemies + index;
            gpCharactorBox.add(tbEnemies[index], 3, position, 1, 1);
        }

        gpCharactorBox.setHgap(15);
        gpCharactorBox.setVgap(0);
    }//initiated charactor pane nodes

    private void showRoom() {

        gameBox.getChildren().clear();//clear

        //charactors in the middle
        gameBox.setCenter(gpCharactorBox);
        gameBox.setAlignment(gpCharactorBox, Pos.CENTER);
        //actions at the bottom
        gameBox.setBottom(hbActionBtns);
        gameBox.setAlignment(hbActionBtns, Pos.CENTER);
    }//show nodes in bordered pane in room section. 

    public void clearBox() {
        gameBox.getChildren().clear();
    }// clears game box pane

    public void showPlayer(int id) {
        lb1.setText("");
        String pStats;
        pStats = players[id].toString();
        lb3.setText(pStats);
    }// shows selected player stats on top label

    public void showEnemy(int id) {
        String pStats;
        pStats = enemies[id - 100].toString();
        lb4.setText(pStats);
    }//shows selected enemy stats on bottom label

    public void lbClear() {
        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        lb4.setText("");
    }//clears all msg labels

    public void occourEnemy() {
        Random random = new Random();

        numOfEnemies = random.nextInt(6) + 1;// 1- 6 enemies
        System.out.println(numOfEnemies + " enemy/enemies generated.");

        enemies = new Charactors[numOfEnemies];
        for (int i = 0; i < numOfEnemies; i++) {
            int randomRank = random.nextInt(6) + 1; //1~6 random rank

            enemies[i] = new Charactors().newEnemy(randomRank);
            enemies[i].setId(100 + i);
        }
        battle.setEnemies(enemies);
        battle.setNumOfEnemies(numOfEnemies);
    }

    public void battleNext(int round) {
        this.round = round;

        Charactors ctr;
        Charactors target;

        if (!battleQueue.isEmpty()) {
            ctr = (Charactors) battleQueue.removeFront();
            System.out.print("Next:  ");
            ctr.printPlayer();
            
            
            ctr.printPlayer();
            while (ctr.getRole() == 4) {//if it's enemy move
                Random randomTarget = new Random();
                if (livePlayers > 0) {//pick a player
                    targetID = randomTarget.nextInt(numOfPlayers);
                    while (!players[targetID].isAlive()) {
                        targetID = randomTarget.nextInt(numOfPlayers);
                    }
                    battle.action(ctr.getId(), targetID, 1); // attack if alive
                } else {
                    System.out.print("GG, all players died");
                }

                if (players[targetID].getHitPoints() < 0) {
                    tbPlayers[targetID].setDisable(true);
                    tbPlayers[targetID].setSelected(false);
                    btnExcute.setDisable(true);
                }
                ctr = (Charactors) battleQueue.removeFront();
                onActionID = ctr.getId();
            }
            setOn();
            System.out.println("PlayerPick");
            showPlayer(onActionID);
            tbSkill.setText(players[onActionID].getSkillName());
        } else {
            round++;
            battleparties = battle.getBattleparties(players, enemies);
            boolean ranaway = false;

            Arrays.sort(battleparties);

            for (Charactors battleparty : battleparties) {
                if (battleparty.isAlive()) {
                    battleQueue.AddToFront(battleparty);
                }
            }
            battleNext(round);
        }

    }

    public void setOn() {
        for (int i = 0; i < numOfPlayers; i++) {
            if ((Integer) tbPlayers[i].getUserData() == onActionID) {
                tbPlayers[i].setSelected(true);
            } else {
                tbPlayers[i].setSelected(false);
            }
        }
    }
}
