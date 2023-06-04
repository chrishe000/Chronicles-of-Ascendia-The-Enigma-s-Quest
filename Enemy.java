import java.util.ArrayList;

public class Enemy {

	
	int attack;
	int defense;
	String name;
	int hp;
	ArrayList<Item> drops;
	boolean isAlive;
	
	public Enemy(int attack, int defense, String name, int hp, ArrayList<Item> drops) {
		
		this.attack = attack;
		this.defense = defense;
		this.name = name;
		this.hp = hp;
		this.drops = drops;
		
	}
	
	int attackPlayer(MainCharacter player, int attack) {
		
		int damage = player.getDefense() - attack;
		return damage;
	}
	
	void die() {
		if(hp == 0)
			isAlive = false;
	}
	
	void takeAPDamage(int damage) {
		
		hp = hp - damage;
	}
	
	void takeADDamage(int damage) {
		
		hp = hp - (defense - damage);
	}
	
	void setAttack(int attack){
		this.attack = attack;
	}
	
	void drop(MainCharacter c) {
		
		for(Item e: drops) {
			
			c.addItem(e);
		}
	}
	
	void setDefense(int defense) {
		this.defense = defense;
	}
	
	void setHp(int hp) {
		this.hp = hp;
	}
	
	
	int getAttack() {
		
		return attack;
	}
	
	int getDefense() {
		
		return defense;
	}

	int getHp() {
	
		return hp;
	}
}
