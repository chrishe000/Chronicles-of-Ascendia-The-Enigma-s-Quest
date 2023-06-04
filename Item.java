// Author: Chris He
// Date: 5/29/2023

public class Item {
    private String name;
    private String description;
    private int cost;
    private int ap;
    private int ad;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // description
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    // cost
    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    // ability power
    public int getAP() {
        return ap;
    }
    
    public void setAP(int ap) {
        this.ap = ap;
    }
    
    // attack damage
    public int getAD() {
        return ad;
    }
    
    public void setAD(int ad) {
        this.ad = ad;
    }

    // use
    public void useHealPotion(MainCharacter m) {
        m.hp = 0;
    }
    
    public void useBoost(MainCharacter m, int ad, int ap, int def) {
        m.attackDamage += ad;
        m.abilityPower += ap;
        m.defense += def;
    }
}
