// Author: Nishad Yedunuthula, Chris He
// Date: 6/4/2023

import java.util.ArrayList;

public class Enemy {
	private int attackDamage, abilityPower, defense, hp, money;
	private String name;
	private ArrayList<Item> drops;
	private boolean isAlive;
	
	public Enemy(int attackDamage, int abilityPower, int defense, String name, int hp, ArrayList<Item> drops, int money) {
		this.attackDamage = attackDamage;
		this.abilityPower = abilityPower;
		this.defense = defense;
		this.setName(name);
		this.hp = hp;
		this.drops = drops;
		this.money = money;
	}

	// attack combined
	void attackPlayerAP(MainCharacter player, int attack) {
		int damage =  attack;
		
		player.setHP(player.getHP()- damage);
	}
	
	void attackPlayerAD(MainCharacter player, int attack) {
		int damage = player.getDefense() - attack;
		
		player.setHP(player.getHP()- damage);
	}
	
	// take damage
	void takeAPDamage(int damage) {
		hp = hp - damage;
	}
	
	void takeADDamage(int damage) {
		hp = hp - (defense - damage);
	}
	
	// drop inventory
	void die(MainCharacter c) {
		if(hp <= 0) {
			setAlive(false);
		}
		
		for(Item i: drops) {
			c.addItem(i);
		}
		
		c.setMoney(c.getMoney() + money);
		
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
	
	// money
	int getMoney() {
		return money;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
