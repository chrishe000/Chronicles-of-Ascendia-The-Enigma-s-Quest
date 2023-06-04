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
	int moneyDrop;
	
	public Enemy(int attackDamage, int abilityPower, int defense, String name, int hp, ArrayList<Item> drops, int moneyDrop) {
		this.attackDamage = attackDamage;
		this.abilityPower = abilityPower;
		this.defense = defense;
		this.name = name;
		this.hp = hp;
		this.drops = drops;
		this.moneyDrop = moneyDrop;
	}

	// attack combined
	void attackPlayerAP(MainCharacter player, int attack) {
		int damage =  attack;
		
		player.setHp(player.getHp()- damage);
	}
	
	void attackPlayerAD(MainCharacter player, int attack) {
		int damage = player.getDefense() - attack;
		
		player.setHp(player.getHp()- damage);
	}
	
	
	
	void takeAPDamage(int damage) {
		
		hp = hp - damage;
		
	}
	
	void takeADDamage(int damage) {
		
		hp = hp - (defense - damage);
	}
	// drop inventory
	void die(MainCharacter c) {
		if(hp == 0) {
			isAlive = false;
		}
		
		for(Item e: drops) {
			c.addItem(e);
		}
		
		c.setMoney(c.getMoney() + moneyDrop);
		
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
	
	void setDropMoney(int hp) {
		this.hp = hp;
	}

	int getDropMoney() {
		return moneyDrop;
	}
}
