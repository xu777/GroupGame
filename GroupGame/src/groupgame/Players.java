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
public class Players {
    private String name;
    private int hitPoints;
    private int strength;
    private int wisdom;
    private int agility;
    private int role;
    private int ability;
    private Weapons weapon;
    private Armors armor;
    
    public static final int BASH= 1;
    public static final int STEAL= 2;
    public static final int FIREBALL= 3;
    public static final int FIGHTER= 1;
    public static final int THIEF= 2;
    public static final int WIZARD= 3;

    public Players(String name, int hitPoints, int strength, int wisdom, int agility, int role, int ability, Weapons weapon, Armors armor) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.wisdom = wisdom;
        this.agility = agility;
        this.role = role;
        this.ability = ability;
        this.weapon = weapon;
        this.armor = armor;
    }

    public Players(String name, int hitPoints, int strength, int wisdom, int agility){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.wisdom = wisdom;
        this.agility = agility;
    }
    
    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getAgility() {
        return agility;
    }

    public int getRole() {
        return role;
    }

    public int getAbility() {
        return ability;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }
   
    public void printPlayer(){
        String p = String.format("Name: %s, HP: %d, STR:%d, WIS:%d, AGI:%d",name,hitPoints,strength,wisdom,agility); //, Role: %d, Ability:%d, Weapon:%s, Armor%s
        System.out.println(p);
    }
}
