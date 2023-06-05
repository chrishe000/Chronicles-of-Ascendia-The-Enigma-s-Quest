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
	String scenario;

	public Location(String name, int difficulty, ArrayList<Character> monsterList, String[] options) {

		this.name = name;
		this.difficulty = difficulty;
		this.monsterList = monsterList;
		this.options = options;
	}

	public Location(String file) {
		initializeMap(file);
		System.out.println("scenario : " + scenario);
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

		System.out.println("overall : " + overall);
		scenario = overall;
		System.out.println("post method scenario : " + scenario);
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
