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

    private int numOfPlayers;
    private Charactors[] players;
    private int mapSize;
    private Rooms[][] map;
    private String playerStyle;
    private int coordX;
    private int coordY;

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
        this.players = new Charactors[numOfPlayers];

        System.out.println(numOfPlayers + " player(s), map size: " + mapSize + " * " + mapSize);//test line: print selection on screen

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                map[row][col] = new Rooms(row, col, false, false);
            }
        }// end creating new map;
        coordX = 0;
        coordY = 0;
        map[coordX][coordY].setCurrent(true);
    }//creating new game data

    public GameController(int numOfPlayers, int mapSize, Charactors[] players, Rooms[][] map) {
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

    public void setPlayers(Charactors[] players) {
        this.players = players;
    }
    
    public void setMap(Rooms[][] map) {
        this.map = map;
    }

    public void setCoordX(int coordX) {
        map[this.coordX][this.coordY].setCurrent(false);
        this.coordX = coordX;
        map[this.coordX][this.coordY].setCurrent(true);
        System.out.printf("Coord(X,Y):(%d,%d)\n", this.coordX, this.coordY);
    }

    public void setCoordY(int coordY) {
        map[this.coordX][this.coordY].setCurrent(false);
        this.coordY = coordY;
        map[this.coordX][this.coordY].setCurrent(true);
        System.out.printf("Coord(X,Y):(%d,%d)\n", this.coordX, this.coordY);
    }

    public void setClear(int coordX, int coordY) {
        map[coordX][coordY].setClear(true);
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int getMapSize() {
        return mapSize;
    }

    public Charactors[] getPlayers() {
        return players;
    }

    public Rooms[][] getMap() {
        return map;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public boolean isClear(int X, int Y) {
        return map[X][Y].isClear();
    }

    public void printMap() {
        for (Rooms[] rooms : map) {
            for (Rooms room : rooms) {
                System.out.print(room.isClear() + " ");
            }
            System.out.println();
        }
    }//method print map on screen

    @FXML
    public void newMapPane() {
        int start = (8 - mapSize) / 2;
        for (int col = 0; col < mapSize; col++) {
            for (int row = 0; row < mapSize; row++) {
                String buttontxt = "";
//                buttontxt = ""+row+","+""+col; //testline, button index on button
                mapButtons[row][col] = new Button(buttontxt);
                mapPane.add(mapButtons[row][col], start + row, start + col, 1, 1);
                mapButtons[row][col].setMnemonicParsing(false);
                mapButtons[row][col].setPrefSize(70, 70);
                mapButtons[row][col].getStyleClass().add("newRoom");
                mapButtons[row][col].setDisable(true);
            }
        }
        if (numOfPlayers > 1) {
            playerStyle = "players";
        } else {
            playerStyle = "player";
        }
        System.out.println("New map built");
    }

    public void setRoomDisable(int row, int col, boolean value) {
        mapButtons[row][col].setDisable(value);
    }

    public GridPane refreshMapPane() {
        for (int col = 0; col < mapSize; col++) {
            for (int row = 0; row < mapSize; row++) {
                if (map[row][col].isClear() == true) {//check and show if a room is clear
                    mapButtons[row][col].getStyleClass().clear();
                    mapButtons[row][col].getStyleClass().add("clearRoom");
                }
                if (map[row][col].isCurrent() == true) {//check and show the current location
                    mapButtons[row][col].getStyleClass().clear();
                    mapButtons[row][col].getStyleClass().add(playerStyle);
                }
            }
        }
        System.out.println("Map Loaded");
        return mapPane;
    }
}
