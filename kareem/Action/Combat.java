/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.Action;

/**
 *
 * @author kareem
 */
public class Combat extends Action{
    
    private int health;
    private int wisdom;
    private int strength;
    //private int damage;
    
    
    public Combat(int value){
        if(value < 10){
            health = 0;
            wisdom = 0;
            strength = 0;
        }else{
            health = 10;
            wisdom = 10;
            strength = 10;
        }
    }//defualt
    
    public void attack(int damage){
        health -= damage;
    }
    
    
}
