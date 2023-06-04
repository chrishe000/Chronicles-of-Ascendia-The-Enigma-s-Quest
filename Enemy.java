// Author: Nishad Yedunuthula, Chris He
// Date: 6/4/2023

import java.util.ArrayList;

public class Enemy {
	int attackDamage;
	int abilityPower;
	int defense;
	String name;
	int hp;
	ArrayList<Item> drops;
	boolean isAlive;
	
	public Enemy(int attackDamage, int abilityPower, int defense, String name, int hp, ArrayList<Item> drops) {
		this.attackDamage = attackDamage;
		this.abilityPower = abilityPower;
		this.defense = defense;
		this.name = name;
		this.hp = hp;
		this.drops = drops;
	}

	// attack combined
	int attackPlayer(MainCharacter player, int attack) {
		int damage = player.getDefense() - attack;
		
		return damage;
	}
	
	// end game
	void die() {
		if(hp == 0) {
			isAlive = false;
		}
	}
	
	// drop inventory
	void drop(MainCharacter c) {
		for(Item e: drops) {
			c.addItem(e);
		}
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

	// defense
	int getDefense() {
		return defense;
	}
	
	void setDefense(int defense) {
		this.defense = defense;
	}
	
	// hp
	void setHp(int hp) {
		this.hp = hp;
	}

	int getHp() {
		return hp;
	}
}
