// Author: Chris He
// Date: 6/3/2023

public class Skill {
    private String name;
    private int damage;
    private int mana;

    public Skill(String name, int damage, int mana) {
        this.name = name;
        this.damage = damage;
        this.mana = mana;
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
    
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

	public void use() {
	    System.out.println("Using " + name);
	    System.out.println("Consumed : " + mana + " mana");
	}
}