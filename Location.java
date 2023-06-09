import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Location extends JPanel{



	int currentLineIndex = 0;
	String name;// will be something like "LEVEL 1...2...3...etc"
	int difficulty;// the difficulty of the dungeon
	ArrayList<Enemy> monsterList;// the list of monsters in this dungeon
	private String[] options;
	String scenario;

	public Location(String name, int difficulty, ArrayList<Enemy> monsterList, String[] options) {

		this.name = name;
		this.difficulty = difficulty;
		this.monsterList = monsterList;
		this.options = options;
	}

	public Location(String file) {
		initializeMap(file);
	}
	
	void spawnList(){// sets the monsterlist that the dungeon has based on the difficulty of the dungeon

		if(difficulty == 1) {}
		//
		else if(difficulty == 2) {}
		//	
		else if(difficulty == 3) {}
		//etc...



	}


	/*
	 * i want the scanner to read in everything starting from 
	 * SCENARIO to ENEMIES
	 * 
	 * from the end of SCENARIO to the start of ENEMIES
	 * */
	public void initializeMap(String filePath) {
		initializeScenario(filePath);
	}

	private void initializeScenario(String filePath) {

		File file = new File(filePath);
		String overall = "";
		String scenarioString = "SCENARIO : ";
		String enemiesString = "ENEMIES : ";
		int scenarioStringStart;

		try {
			Scanner scanner = new Scanner(file);

			boolean started = false;

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();

				if (line.contains(scenarioString)) {
					started = true;
					scenarioStringStart = line.indexOf(scenarioString) + scenarioString.length();
					overall += line.substring(scenarioStringStart);
				}
				else if(line.contains(enemiesString)) {
					break;                	
				}
				else if(started == true) {
					overall += line;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scenario = overall;
	}

	public void paint(Graphics g, MainCharacter character) {
		
		this.setLayout(new BorderLayout()); // Set the layout manager before adding components

		paintStats(character);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		int numberOfOptions = getOptions().length;

		for (int i = 0; i < numberOfOptions; i++) {

			JButton button = new JButton(getOptions()[i]);
			button.setUI(new StyledButtonUI());
			buttonPanel.add(button);
		}

		int height = this.getHeight();
		int targetY = (int) (height * 0.25);

		this.add(Box.createVerticalStrut(targetY), BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}

	
	private void initializeEnemies(String filePath) {
		/*
		 * i want to split the enemies string apart by certain keywords
		 * like name, attackDamage, abilityPower, defense, hp, drops, money

		 * */

		int currIndex = 0;
		Scanner scanner = new Scanner(filePath);
		String line = scanner.nextLine();
		while(!line.contains("---")) {
			initializeOneEnemy(filePath, currentLineIndex);
		}
		
//		"---"
		
		

	}
	
	private void initializeOneEnemy(String filePath, int startIndex) {
		String name = (getStringBetween("name:", "attackDamage", filePath, startIndex));
		int attackDamage = Integer.parseInt(getStringBetween("attackDamage:", "abilityPower", filePath, startIndex));
		int abilityPower = Integer.parseInt(getStringBetween("abilityPower:", "defense", filePath, startIndex));
		int defense = Integer.parseInt(getStringBetween("defense:", "hp", filePath, startIndex));
		int hp = Integer.parseInt(getStringBetween("hp:", "drops", filePath, startIndex));
		ArrayList<Item> drops = returnDrops(filePath, startIndex);
		int money = Integer.parseInt(getStringBetween("money:", "", filePath, startIndex));
		
		monsterList.add(new Enemy(attackDamage, abilityPower, 
				defense, name, hp, drops, money));
	}
	
	private ArrayList<Item> returnDrops(String filePath, int startIndex) {
		/*
		 * start at startIndex, keep reading Items in
		 * until you reach a "}"
		 * */

		
		
	}
	
	private Item readItem(String filePath, int start) {
		
		String name = (getStringBetween("name:", "description", filePath, start));
		String description = (getStringBetween("description:", "mana", filePath, start));
		int mana = Integer.parseInt(getStringBetween("mana:", "cost", filePath, start));
		int cost = Integer.parseInt(getStringBetween("cost:", "boostAD", filePath, start));
		int boostAD = Integer.parseInt(getStringBetween("boostAD:", "boostAP", filePath, start));
		int boostAP = Integer.parseInt(getStringBetween("boostAP:", "boostDef", filePath, start));
		int boostDef = Integer.parseInt(getStringBetween("boostAP:", "boostDef", filePath, start));
		int heal = Integer.parseInt(getStringBetween("boostAP:", "boostDef", filePath, start));
		int uses = Integer.parseInt(getStringBetween("boostAP:", "boostDef", filePath, start));

		return new Item(name, description, mana, cost, boostAD, boostAP,
				boostDef, heal, uses);
	}
	
	
	private String getStringBetween(String start, String end, String filePath, int startIndex) {
		File file = new File(filePath);
		String overall = "";
		int stringStart;

		try {
			Scanner scanner = new Scanner(file);

			for(int i = 0; i < startIndex - 1; i ++) {
				scanner.nextLine();	
			}
			boolean started = false;

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.contains(start)) {
					started = true;
					stringStart = line.indexOf(start) + start.length();
					overall += line.substring(stringStart);
					
				}
				else if(line.contains(end)) {
					break;
				}
				else if(started == true) {
					overall += line;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return overall;
	}
	
	public void paintStats(MainCharacter character) {
		this.add(new JLabel("hp : " + character.getHP() + ", basic attack damage : " 
				+ character.getAttackDamage() + ", ability power : " + character.getAbilityPower()), 
				BorderLayout.NORTH);
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
