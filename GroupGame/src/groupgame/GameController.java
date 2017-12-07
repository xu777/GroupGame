/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;


/**
 *
 * @author ryanlingxiao
 */
public class GameController {

    public int numOfPlayers;
    public Players[] players;
    public int mapSize;
    public Rooms[][] map;

    public GameController() {

    }

    public GameController(int numOfPlayers, int mapSize) {
        this.numOfPlayers = numOfPlayers;
        setPlayers(new Players[numOfPlayers]);
        setMapSize(mapSize);
        setMap(new Rooms[mapSize][mapSize]);

        System.out.println(numOfPlayers + " player(s), map size: " + mapSize + " * " + mapSize);//test line: print selection on screen

        for (int row = 0; row < mapSize; row++) {
            for (int col = 0; col < mapSize; col++) {
                map[row][col] = new Rooms(row, col, false);
            }
        }// end creating new map;

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

}
