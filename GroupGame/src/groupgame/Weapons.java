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
public class Weapons {

    public static final int FIST = 0;
    public static final int WOODENSWORD = 1;
    public static final int IRONSWORD = 2;
    public static final int IRONAXE = 3;
    

    private String name;
    private int rank;
    private int duability;

    public Weapons() {
    }

    
    
    public Weapons(String name, int rank, int duability) {
        this.name = name;
        this.rank = rank;
        this.duability = duability;
    }

    public Weapons(int rank) {
        this.rank = rank;
        switch (rank) {
            case 1:
                this.name = "Wooden Sword";
                break;
            case 2:
                this.name = "Iron Sword";
                break;
            case 3:
                this.name = "Iron Axe";
                break;
            default:
                this.name = "Fist";
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDuability(int duability) {
        this.duability = duability;
    }

    public void used(){
        duability--;
    }
    
    public boolean isBroken(){
        return duability>0;
    }
    
    public Weapons enemyPull(){ // 75%chance, enemy has a weapon
        Random random = new Random();
        int chance = random.nextInt(4);
        if (chance> 0){
            int randomRank = random.nextInt(3)+1;
            return (new Weapons(randomRank));
        }
        else 
        {
            return (new Weapons(0));
        }
    }
    
}
