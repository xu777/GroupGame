/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

/**
 *
 * @author hehnd
 */
public class Player {
    
    private int hitPoints;
    private int wisdom;
    private int agility;
    private int strength;
    private Weapon weapon;
    private Armor armor;
    private Role role;
    private String name;

    public Player(int hitPoints, int wisdom, int agility, int strength, Weapon weapon, Armor armor, Role role, String name) {
        this.hitPoints = hitPoints;
        this.wisdom = wisdom;
        this.agility = agility;
        this.strength = strength;
        this.weapon = weapon;
        this.armor = armor;
        this.role = role;
        this.name = name;
    }

    public Player() {
        this(20, 0, 0, 0, new Weapon("fist"), new Armor("cloak") , null, "DEFAULT NAME" );
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    
    
            
    
    
    
    
    
    
    
    
}
