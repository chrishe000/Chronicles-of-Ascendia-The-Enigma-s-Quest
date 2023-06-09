import java.util.ArrayList; // import the ArrayList class

//Nishad Yedunuthula
public class Location {
	
	String name;// will be something like "LEVEL 1...2...3...etc"
	int difficulty;// the difficulty of the dungeon
	ArrayList<Enemy> monsterList = new ArrayList<Enemy>();// the list of monsters in this dungeon
	ArrayList<String> script = new ArrayList<String>();
	ArrayList<Location> doors = new ArrayList<Location>();
	private String[] options;
	
	public Location(String name, int difficulty, ArrayList<Enemy> monsterList, String[] options){
		
		this.name = name;
        this.difficulty = difficulty;
        this.monsterList = monsterList;
        this.options = options;
	}
	
	ArrayList<Location> getDoors() {
		
		return doors;
	}

	void leaveDungeon(MainCharacter c, Location l) {
		
		c.setLocation(l);
		c.addLoc(l);
	}
	
	
	void monsterDefeated() {// when the main character beats a monster, it is removed from the arraylist
		
		monsterList.remove(0);
	}
	
	void setDungeon(ArrayList<Enemy> monsters) {// set method
		
		monsterList = monsters;
	}
	
	ArrayList<Enemy> getDungeon(){// get method
		
		return monsterList;
	}
	
	String[] getOptions() {
		return options;
	}
	
	
	
	
}
