package gameproject.Action;

//*******************************************
//@author kareem                           **
//*******************************************

public class Armor {
    
    private String name;
    private int rank;
    private int durability;
	
	public Armor(){
		private String name = "";
		private int rank = 0;
		private int durability = 0;
	}//defualt
	
	public Armor(int rank, int durability)
	{
		if(rank == 1)
		{
			setName("Dwarf star Shield");
			setRank(rank);
			setDurability(durability);
		}
		else if(rank == 2)
		{
			setName("");
			setRank(rank);
			setDurability(durability);
		}
		else(rank == 3)
		{
			setName("Reflective cloak");
			setRank(rank);
			setDurability(durability);
		}
	}
	

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
    
}
