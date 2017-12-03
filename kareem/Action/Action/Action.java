package gameproject.Action;


public class Action {
    
    private int health;
    private int wisdom;
    private int strength;
    private int agility;
    private int fighter = 1;
    private int thief = 2;
    private int wizard = 3;
    
    
    public Action(int value){
        if(value == fighter){
            health = 20;
            wisdom = -3;
            strength = 3;
            agility = 0;
        }else if(value == thief){
            health = 20;
            wisdom = 3;
            strength = -2;
            agility = 2;
        }else if(value == wizard){
            health = 20;
            wisdom = 5;
            strength = -5;
            agility = -3;
        }
    }//defualt
    
    public void attack(int damage){
        if(){
            
        }
    }
    public void run(){}
    public void hide(){}
    public void search(){}
    public void loot(){}
    public void steal(){}
    
}
