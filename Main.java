import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JPanel {

	int width = 100, height = 100;
	ArrayList<Dungeon> dungeons;
	MainCharacter character;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0,0,100,100);


		frame.add(new Main());
	}
	
	public Main() {
		this.dungeons = new ArrayList<Dungeon>();
		String[] options = {"hello", "say hello"};
		ArrayList<Character> monsterList = new ArrayList<Character>();
		Dungeon dungeon1 = new Dungeon("ez dungeon", 1, monsterList, options);
		dungeons.add(dungeon1);
		MainCharacter character = new MainCharacter(0,0,0,0);
	}
	
	public Main(Dungeon[] dungeons, MainCharacter c) {
//		while(c.isAlive) {
//			
//		} 
		
		 
		
		/*
		 * while the game is continuing
		 * 
		 * write each dungeon's text out on the jframe
		 * create buttons for each option on the dungeon, with 
		 * each button's text on their buttons
		 * 
		 * once dungeon is beaten upload the next one, until player is dead
		 * 
		 * for each dungeon in DUNGEONS write its text
		 on the jframe 
		 
		 
		 * */
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Dungeon randomDungeon = randomDungeon(dungeons);
		paintDungeon(randomDungeon, g);
		
		
	}
	
	public void paintDungeon(Dungeon d, Graphics g) {
		this.add(new JLabel(/*get the text inside dungeon d*/));
		
		// based on how many options are inside Dungeon d,
		// create that many JButtons with their respective texts on it
		int numberOfOptions = d.getOptions().length;
		System.out.println(numberOfOptions);
		int heightOfButton = height / numberOfOptions;
		int widthOfButton = width / numberOfOptions;
		
		for(int i = 0; i < numberOfOptions; i ++) {
			this.add(new JButton(d.getOptions()[i]));
		}
		
//		int count = 0;
//		
//		
//		for(int i = 0; i < width; i += widthOfButton) {
//			for(int j = 0; j < height; j += heightOfButton) {
//				this.add(new JButton(d.getOptions()[count]));
//				count ++;
//			}
//		}
		
	}
	
	public Dungeon randomDungeon(ArrayList<Dungeon> d) {
		int randNum = (int)(d.size() * Math.random());
		return d.get(randNum);
	}
	
	public void run(Dungeon[] dungeons, MainCharacter c) {
		
	}
	
}
