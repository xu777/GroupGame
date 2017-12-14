/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.util.Arrays;
import java.util.Random;
import queues.LinkedDequeue;

/**
 *
 * @author ryanlingxiao
 */
public class Battle {

    private Charactors[] players;
    private Charactors[] enemies;
    private int numOfPlayers;
    private int numOfEnemies;
    private int round;

    private String actionName;

    public Battle() {
    }

    public Battle(Charactors[] players, Charactors[] enemies, int numOfPlayers, int numOfEnemies, int round, int onActionID, int targetID) {
        this.players = players;
        this.enemies = enemies;
        this.numOfPlayers = numOfPlayers;
        this.numOfEnemies = numOfEnemies;
        this.round = round;
    }

    public Battle(Charactors[] players, Charactors[] enemies) {
        this.players = players;
        this.enemies = enemies;
        this.numOfPlayers = players.length;
        this.numOfEnemies = enemies.length;

    }

    public void setPlayers(Charactors[] players) {
        this.players = players;
    }

    public void setEnemies(Charactors[] enemies) {
        this.enemies = enemies;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setNumOfEnemies(int numOfEnemies) {
        this.numOfEnemies = numOfEnemies;
    }

    public void setRound(int round) {
        this.round = round;
    }


    public Charactors[] getPlayers() {
        return players;
    }

    public Charactors[] getEnemies() {
        return enemies;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int getNumOfEnemies() {
        return numOfEnemies;
    }

    public int getRound() {
        return round;
    }

    public Charactors[] getBattleparties(Charactors[] players, Charactors[] enemies) {
        int totalParty = players.length + enemies.length;
        Charactors[] battleparties = new Charactors[totalParty];
        
        for (int i = 0; i < numOfPlayers; i++) {
            battleparties[i] = players[i];
        }

        for (int i = 0; i < numOfEnemies; i++) {
            battleparties[i + numOfPlayers] = enemies[i];
        }
        return battleparties;
    }

 
    public void enemyAction() {

    }

    public void action(int ID, int targetID, int actionType) {
        actionName = getActionName();
        Charactors ctr;
        Charactors target;
        int agi;
        if (actionType == 1) {
            System.out.println(ID + " " + actionName + " " + targetID + " " + actionType);
            if (ID < 4) {
                ctr = players[ID];  //charactor doing the action
                target = enemies[targetID - 100];//the target
            } else if (ID > 99) {
                target = players[targetID];
                ctr = enemies[ID - 100];
            } else {
                ctr = null;
                target = null;
                System.out.println("Error ID!");
            }
            agi = ctr.getAgility();
            if (ifHit(agi)) {

                int dmg = ctr.getStrength() / 3;
                target.setHitPoints(target.getHitPoints() - dmg);
                System.out.println("land! and delt " + dmg + " damage.");
            } else {
                System.out.println("Miss");
            }
        } else if (actionType == 2) {
            System.out.println(ID + " " + actionName + " " + targetID + " " + actionType);
        } else if (actionType == 3) {
            System.out.println(ID + " " + actionName);
        } else {
            System.out.println(ID + " " + actionName);
        }
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionString(String actionName) {
        this.actionName = actionName;
    }

    public boolean ifHit(int agi) {
        if (agi <= -100) {
            System.out.println("agi load error!");
        }
        Dice dice = new Dice();
        int chance = dice.roll(1, 20);
        return (agi - chance > 0);
    }

 
}
