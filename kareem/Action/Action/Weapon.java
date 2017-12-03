package gameproject.Action;

//*******************************************
//@author kareem                           **
//*******************************************

class Weapon {

    	
    private String name;
    private int damage;
    private int rank;
    private int durability;
	
	public weapon()
	{
		private String name = "";
		private int damage = 0;
		private int rank = 0;
		private int durability = 0;
	}//defualt
	
	public weapon(int rank, int durability, int damage)
	{
		if(rank == 1){
			setName("Gauntlet gloves");
			setDamage(damage);
			setRank(rank);
			setDurability(durability);
		}
		else if(rank == 2)
		{
			setName("Staff of Katar");
			setDamage(damage);
			setRank(rank);
			setDurability(durability);
		}
		else(rank == 3)
		{
			setName("Icarus boots");
			setDamage(damage);
			setRank(rank);
			setDurability(durability);
		}
	}

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
		
    
    
    
    
}
