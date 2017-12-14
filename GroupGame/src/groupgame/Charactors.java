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
public class Charactors implements Comparable<Charactors> {

    private String name;
    private int id;
    private int hp;
    private int str;
    private int wis;
    private int agi;
    private int role;
    private int skill;
    private Weapons weapon;
    private Armors armor;

    public static final int BASH = 1;
    public static final int STEAL = 2;
    public static final int FIREBALL = 3;
    public static final int FIGHTER = 1;
    public static final int THIEF = 2;
    public static final int WIZARD = 3;
    public static final int ENEMY = 4;

    public Charactors() {

    }

    public Charactors(int id, String name, int hitPoints, int strength, int wisdom, int agility, int role, int ability, Weapons weapon, Armors armor) {
        this.id = id;
        this.name = name;
        this.hp = hitPoints;
        this.str = strength;
        this.wis = wisdom;
        this.agi = agility;
        this.role = role;
        this.skill = ability;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void CreateCharactors(int id, String name, int hitPoints, int strength, int wisdom, int agility, int Role) {
        this.id = id;
        this.name = name;
        this.hp = hitPoints;
        this.str = strength;
        this.wis = wisdom;
        this.agi = agility;
        this.role = Role;
        this.skill = Role;
        this.weapon = new Weapons(0);
        this.armor = new Armors(0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hp;
    }

    public int getStrength() {
        return str;
    }

    public int getWisdom() {
        return wis;
    }

    public int getAgility() {
        return agi;
    }

    public int getRole() {
        return role;
    }

    public int getAbility() {
        return skill;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        this.hp = hitPoints;
    }

    public void setStrength(int strength) {
        this.str = strength;
    }

    public void setWisdom(int wisdom) {
        this.wis = wisdom;
    }

    public void setAgility(int agility) {
        this.agi = agility;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setAbility(int ability) {
        this.skill = ability;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    @Override
    public int compareTo(Charactors ch) {
        return (this.agi - ch.agi);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getRoleTitle() {
        String roleTitle;
        switch (role) {
            case 1:
                roleTitle = "Fighter";
                break;
            case 2:
                roleTitle = "Thief";
                break;
            case 3:
                roleTitle = "Wizard";
                break;
            case 4:
                roleTitle = "Enemy";
                break;
            default:
                roleTitle = "Fighter";
                break;
        }
        return roleTitle;
    }

    public String getSkillName() {
        String title;
        switch (skill) {
            case 1:
                title = "Bash";
                break;
            case 2:
                title = "Steal";
                break;
            case 3:
                title = "Fireball";
                break;
            default:
                title = "Bash";
                break;
        }
        return title;
    }

    public void printPlayer() {

        System.out.println(toString());
    }

    @Override
    public String toString() {
        String roleTitle = getRoleTitle();
        String weaponTitle = weapon.getName();
        String armorTitle = armor.getName();
        String temp = String.format("%s\n %s,   %s \n HP: %d, Role:  %s \n STR:  %d, WIS:  %d, AGI:  %d", name, weaponTitle, armorTitle, hp, roleTitle, str, wis, agi); //, Role: %d, Ability:%d, Weapon:%s, Armor%s

        return temp;
    }

    public Charactors newEnemy(int rank) {
        String ename;
        switch (rank) {
            case 2:
                ename = "Ghost";
                break;
            case 3:
                ename = "Zombie";
                break;
            case 4:
                ename = "Skeleton";
                break;
            case 5:
                ename = "Robot";
                break;
            case 6:
                ename = "Dragon";
                break;
            case 1:
            default:
                ename = "Goblin";
                break;
        }
        Charactors enemy = new Charactors();
        Dice dice = new Dice();
        enemy.setName(ename);
        enemy.setHitPoints(dice.roll(rank, 3));
        enemy.setStrength(dice.roll(rank, 3));
        enemy.setWisdom(dice.roll(rank, 3));
        enemy.setAgility(dice.roll(rank, 3));
        enemy.setRole(4);
        enemy.setAbility(4);
        Weapons newWeapon = new Weapons();
        enemy.setWeapon(newWeapon.enemyPull());
        Armors newArmor = new Armors();
        enemy.setArmor(newArmor.enemyPull());
        enemy.printPlayer();
        return enemy;
    }
}
