import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;

import Elements.Enemy;
import Elements.TowerLand;
import Level.Gridspace;
import Projectile.Effect;
import Projectile.Projectile;

public class Location {
	
	
	/*
	 * planning : 

read textfiles into dungeons, initialize the enemies and options in dungeon

main : 
	dungeons[] array
	for each dungeon in dungeons[], initialize it

dungeon(String file) : 
	read file in
	 * */
	String name;// will be something like "LEVEL 1...2...3...etc"
	int difficulty;// the difficulty of the dungeon
	ArrayList<Character> monsterList;// the list of monsters in this dungeon
	private String[] options;
	
	public Location(String name, int difficulty, ArrayList<Character> monsterList, String[] options) {
		
		this.name = name;
        this.difficulty = difficulty;
        this.monsterList = monsterList;
        this.options = options;
	}
	
	void spawnList(){// sets the monsterlist that the dungeon has based on the difficulty of the dungeon
		
		if(difficulty == 1)
			//
		else if(difficulty == 2)
			//	
		else if(difficulty == 3)
			//etc...
			

		
	}
	
	public void initializeMap(String filePath) {
		{
			int x = 0, y = 0;
//			File randNums = new File("textfiles/randnums1");
			File dungeonPlan = new File(filePath);

			Scanner scanner;

			try {
				scanner = new Scanner(dungeonPlan);


				}
			 catch (FileNotFoundException e) {
				e.printStackTrace();
			
			}
		}
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
	
	String[] getOptions() {
		return options;
	}
	
	
	
	
}
