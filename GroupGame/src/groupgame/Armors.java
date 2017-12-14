/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

import java.util.Random;

/**
 *
 * @author ryanlingxiao
 */
public class Armors {

    public static final int CLOAK = 0;
    public static final int LEATHER = 1;
    public static final int ARMOR = 2;
    public static final int CHAINEDARMOR = 2;

    private String name;
    private int duability;
    private int rank;

    public Armors() {
    }

    public Armors(String name, int rank, int duability) {
        this.name = name;
        this.rank = rank;
        this.duability = duability;
    }

    public Armors(int rank) {
        this.rank = rank;
        switch (rank) {
            case 1:
                this.name = "Leather";
                break;
            case 2:
                this.name = "Armor";
                break;
            case 3:
                this.name = "Chained Armor";
                break;
            default:
                this.name = "Cloak";
                break;
        }
        this.duability = 20;
    }

    public String getName() {
        return name;
    }

    public int getDuability() {
        return duability;
    }

    public void setDuability(int duability) {
        this.duability = duability;
    }

    public void used() {
        duability--;
    }

    public boolean isBroken() {
        return duability > 0;
    }

    public Armors enemyPull() { // 75%chance, enemy has a weapon
        
        Random random = new Random();
        int chance = random.nextInt(4);
        if (chance > 0) {
            int randomRank = random.nextInt(3) + 1;
            return (new Armors(randomRank));
        } else {
            return (new Armors(0));
        }
    }

}
