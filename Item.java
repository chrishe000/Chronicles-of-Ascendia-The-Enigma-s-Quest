// Author: Chris He
// Date: 5/29/2023
/*
AdventureGameItem sword = new AdventureGameItem("Sword", "A sharp weapon for battles");
System.out.println(sword.getName()); // Output: Sword
System.out.println(sword.getDescription()); // Output: A sharp weapon for battles

sword.use();    // Output: Using Sword...
*/

public class Item {
    private String name;
    private String description;
    private int cost;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public int getCost() {
        return cost;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void use() {
        System.out.println("Using " + name + "...");
    }
}