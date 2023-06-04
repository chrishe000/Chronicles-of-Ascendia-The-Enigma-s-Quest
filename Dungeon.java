import java.util.ArrayList; // import the ArrayList class
//Nishad Yedunuthula

public class Dungeon {
	
	String name;// will be something like "LEVEL 1...2...3...etc"
	int difficulty;// the difficulty of the dungeon
	ArrayList<Character> monsterList;// the list of monsters in this dungeon
	
	public Dungeon(String name, int difficulty, ArrayList<Character> monsterList) {
		
		this.name = name;
        	this.difficulty = difficulty;
     		this.monsterList = monsterList;
	}
	
	void spawnList(){// sets the monsterlist that the dungeon has based on the difficulty of the dungeon
		
		if(difficulty == 1)
			//
		else if(difficulty == 2)
			//	
		else if(difficulty == 3)
			//etc...
	}
	
	void monsterDefeated() {// when the main character beats a monster, it is removed from the arraylist
		
		monsterList.remove(0);
	}
	
	void setDungeon(ArrayList<Character> monsters) {// set method
		
		monsterList = monsters;
	}
	
	ArrayList<Character> getDungeon(){// get method
		
		return monsterList;
	}	
		
}
