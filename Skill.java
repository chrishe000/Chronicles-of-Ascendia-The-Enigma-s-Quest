// Author: Chris He
// Date: 6/3/2023

public class Skill {
    private String name;
    private int damage;
    private int manaCost;

    public Skill(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
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
    
    public int getmanaCost() {
        return manaCost;
    }

    public void setmanaCost(int manaCost) {
        this.manaCost = manaCost;
    }

	public void use(Enemy e) {
	    e.takeDamage(damage);
	}
}
