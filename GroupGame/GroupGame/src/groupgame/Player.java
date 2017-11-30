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
public class Player {
    public int hitPoints;
    public int Strength;
    public int Wisdom;
    public int Agility;
    public Weapon weapon;
    public Armor armor;

    public Player(int hitPoints, int Strength, int Wisdom, int Agility, Weapon weapon, Armor armor){
        this.hitPoints = hitPoints;
        this.Strength = Strength;
        this.Wisdom = Wisdom;
        this.Agility =Agility;
        this.weapon = weapon;
        this.armor = armor;
    }
}
