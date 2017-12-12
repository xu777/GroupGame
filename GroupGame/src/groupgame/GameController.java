/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author ryanlingxiao
 */
public class GameController {

    public int numOfPlayers;
    public Players[] players;
    public int mapSize;
    public Rooms[][] map;
    private String playerStyle;

    @FXML
    public GridPane mapPane = new GridPane();
    @FXML
    public Button[][] mapButtons = new Button[8][8];

    public GameController() {

    }

    public GameController(int numOfPlayers, int mapSize) {
        this.numOfPlayers = numOfPlayers;
        this.mapSize = mapSize;
        this.map = new Rooms[mapSize][mapSize];

        System.out.println(numOfPlayers + " player(s), map size: " + mapSize + " * " + mapSize);//test line: print selection on screen

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                map[row][col] = new Rooms(row, col, false, false);
            }
        }// end creating new map;

        map[0][0].setCurrent(true);
    }//creating new game data

    public GameController(int numOfPlayers, int mapSize, Players[] players, Rooms[][] map) {
        this.numOfPlayers = numOfPlayers;
        this.mapSize = mapSize;
        this.players = players;
        this.map = map;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public void setPlayers(Players[] players) {
        this.players = players;
    }

    public void setMap(Rooms[][] map) {
        this.map = map;

    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int getMapSize() {
        return mapSize;
    }

    public Players[] getPlayers() {
        return players;
    }

    public Rooms[][] getMap() {
        return map;
    }

    public void printMap() {
        for (Rooms[] rooms : map) {
            for (Rooms room : rooms) {
                System.out.print(room.clear + " ");
            }
            System.out.println();
        }
    }

    @FXML
    public void newMapPane() {
        int start = (8 - mapSize) / 2;
        for (int col = 0; col < mapSize; col++) {
            for (int row = 0; row < mapSize; row++) {
                mapButtons[row][col] = new Button();
                mapPane.add(mapButtons[row][col], start + col, start + row, 1, 1);
                mapButtons[row][col].setMnemonicParsing(false);
                mapButtons[row][col].setPrefSize(70, 70);
                mapButtons[row][col].getStyleClass().add("newRoom");
                mapButtons[row][col].setDisable(true);
            }
        }
        if (numOfPlayers >1) {
            playerStyle = "players";
        }
        else {
            playerStyle = "player";
        }
        System.out.print("New map built");
    }

    public GridPane refreshMapPane() {
        int start = (8 - mapSize) / 2;
        for (int col = 0; col < mapSize; col++) {
            for (int row = 0; row < mapSize; row++) {
                if(map[row][col].isClear() == true){
//                mapPane.add(mapButtons[row][col], start + col, start + row, 1, 1);
//                mapButtons[row][col].setMnemonicParsing(false);
//                mapButtons[row][col].setPrefSize(70, 70);
                mapButtons[row][col].getStyleClass().clear();
                mapButtons[row][col].getStyleClass().add("clearRoom");
                }
                if(map[row][col].isCurrent() == true){
//                mapPane.add(mapButtons[row][col], start + col, start + row, 1, 1);
//                mapButtons[row][col].setMnemonicParsing(false);
//                mapButtons[row][col].setPrefSize(70, 70);
                mapButtons[row][col].getStyleClass().clear();
                mapButtons[row][col].getStyleClass().add(playerStyle);
                }
            }
        }
        System.out.print("Map Updated");
        return mapPane;
    }
}
