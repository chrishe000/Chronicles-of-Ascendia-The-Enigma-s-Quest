
public class Enemy {

	
	int attack;
	int defense;
	String name;
	int hp;
	
	public Enemy(int attack, int defense, String name, int hp) {
		
		this.attack = attack;
		this.defense = defense;
		this.name = name;
		this.hp = hp;
		
	}
	
	int attackPlayer(Character player, int attack) {
		
		int damage = player.getDefense() - attack;
		return damage;
	}
	
	void setAttack(int attack){
		this.attack = attack;
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
