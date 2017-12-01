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
public abstract class Player {
    public int hitPoints;
    public int strength;
    public int wisdom;
    public int agility;
    public Weapon weapon;
    public Armor armor;
    public String name;
    public int Ability;
    
    private static int Bash= 1;
    private static int Steal= 2;
    private static int Fireball= 3;

    public Player(int hitPoints, int Strength, int Wisdom, int Agility, Weapon weapon, Armor armor){
        this.hitPoints = hitPoints;
        this.strength = Strength;
        this.wisdom = Wisdom;
        this.agility =Agility;
        this.weapon = weapon;
        this.armor = armor;
    }
    
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public abstract void role();

    public void setName(String name) {
        this.name = name;
    }
}
