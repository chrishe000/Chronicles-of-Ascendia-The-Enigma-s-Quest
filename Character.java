package Characters;
import java.util.ArrayList;

/*
 * Fields 
Ad
Ap
Hp
Money
Level
Experience
Inventory array
Void attack()
Void defend()
Void retreat()
Void buyItem(float money, Item item)
Void die()
Void dropInventory()
 * */


public class Character {
	int attackDamage, abilityPower, hp, money;
	boolean isAlive = true;
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Character(int ad, int ap, int hp, int money) {
		attackDamage = ad;
		abilityPower = ap;
		this.hp = hp;
	}
	public void attackAD(Character c, Dungeon d) {
		
		c.takeDamage(attackDamage, d);
	}
	
	public int calculateTotalAD() {
		int total = 0;
		for(int i = 0; i < inventory.size(); i ++) {
			total += inventory.get(i).attackDamage;
		}
		return total;
	}
	public int calculateTotalAP() {
		int total = 0;
		for(int i = 0; i < inventory.size(); i ++) {
			total += inventory.get(i).abilityPower;
		}
		return total;
	}
	public int calculateTotalHP() {
		int total = 0;
		for(int i = 0; i < inventory.size(); i ++) {
			total += inventory.get(i).hitpoints;
		}
		return total;
	}
	
	public void takeDamage(int damage, Dungeon d) {
		hp = hp - damage;
		if(hp <= 0) {
			die(d);
		}
	}
	public void retreat() {
		// not sure how to code this
		// what does retreat do specifically? does the character just become
		// untargetable?
		
	}

	public void die(Dungeon d) {
		isAlive = false;
		dropInventory(d);
		// dungeon class will remove this character from its list of characters
	}
	public void dropInventory(Dungeon d) {
		// belongs in dungeon class?
		// drop inventory and money
		
		//d.addToItemsLoot(inventory)
		//d.addTo
	}
}
