// Author: Chris He
// Date: 6/4/2023

public class Skill {
    private String name;
    private int attackDamage, abilityPower;
    private int manaCost;

    public Skill(String name, int attackDamage, int abilityPower, int manaCost) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.manaCost = manaCost;
    }

    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // attack damage
    public int getAttackDamage() {
        return attackDamage;
    }
    
    public void setDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    
    // ability power
    public int getAbilityPower() {
        return abilityPower;
    }
    
    public void setAbilityPower(int abilityPower) {
        this.abilityPower = abilityPower;
    }
    
    // mana cost
    public int getmanaCost() {
        return manaCost;
    }

    public void setmanaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    // use
	public void use(Enemy e) {
	    e.takeADDamage(attackDamage);
	    e.takeAPDamage(abilityPower);
	}
}
