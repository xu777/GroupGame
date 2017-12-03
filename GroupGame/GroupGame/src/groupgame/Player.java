
package groupgame;

/**
 *
 * @author ryanlingxiao
 */
public class Player {
    public int hitPoints;
    public int strength;
    public int wisdom;
    public int agility;
    public Weapon weapon;
    public Armor armor;
    public String name;
    public int Ability;
    
    private static final int BASH= 1;
    private static final int STEAL= 2;
    private static final int FIREBALL= 3;

    public Player(String name, int hitPoints, int Strength, int Wisdom, int Agility, Weapon weapon, Armor armor){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = Strength;
        this.wisdom = Wisdom;
        this.agility =Agility;
        this.weapon = weapon;
        this.armor = armor;
    }
    
    public Player(){
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

    public void setName(String name) {
        this.name = name;
    }
}
