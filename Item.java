// Author: Chris He, Nishad Yedunuthula 
// Date: 5/29/2023

public class Item {
    private String name;
    private String description;
    private int mana, cost, boostAD, boostAP, boostDef, heal, uses;
    
    public Item(String name, String description,int  mana, int cost,int boostAD,int boostAP,int boostDef,int heal,int uses) {
        this.name = name;
        this.description = description;
        this.mana = mana; // the mana cost of using the item
        this.cost = cost;// the money it costs to buy or the money you get when selling
        this.boostAD = boostAD;// the attack damage boost of this item when used
        this.boostAP = boostAP;// the ability power boost of this item when used
        this.boostDef = boostDef;// the defense boost of this item when used
        this.heal = heal;// the amount healed when this item is used
        this.uses = uses;// the amount of uses this item has
        
    }
    
    
    public void useItem(MainCharacter c) {
    	if(uses < 25) {
    		uses--;
    	}
        
    	c.setHP(c.getHP()+ heal);
    	c.setAttackDamage(c.getAttackDamage() + boostAD);
    	c.setAbilityPower(c.getAbilityPower() + boostAP);
    	c.setDefense(c.getDefense() + boostDef);
    	c.setMana(c.getMana() - mana);
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public int getBoostAD() {
        return boostAD;
    }
    
    public void setBoostAD(int boostAD) {
        this.boostAD = boostAD;
    }
    
    public int getBoostAP() {
        return boostAP;
    }
    
    public void setBoostAP(int boostAP) {
        this.boostAP = boostAP;
    }
    
    public int getBoostDEF() {
        return boostDef;
    }
    
    public void setBoostDEF(int boostDef) {
        this.boostDef = boostDef;
    }
    
    public int getHeal() {
        return heal;
    }
    
    public void setHeal(int heal) {
        this.heal = heal;
    }
    
    public int getUses() {
        return uses;
    }
    
    public void setUses(int uses) {
        this.uses = uses;
    }
}
