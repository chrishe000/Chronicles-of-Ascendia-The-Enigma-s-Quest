import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

//Franklin Wang, Nishad Yedunuthula

class StyledButtonUI extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(200, 200, 200));
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        
        g.setColor(new Color(244, 244, 244));
        g.fillRoundRect(0, yOffset, size.width , size.height + yOffset - 3, 10, 10);
    }
}

public class Main extends JPanel {

	int width = 300, height = 300;
	ArrayList<Dungeon> dungeons;
	MainCharacter character;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Main m = new Main();
		
		
		frame.setVisible(true);
		frame.setBounds(0,0,m.width, m.height);


		frame.add(m);
	}
	
	public Main() {
		this.dungeons = new ArrayList<Dungeon>();
		String[] options = {"hello", "say hello", "ads"};
		ArrayList<Character> monsterList = new ArrayList<Character>();
		Dungeon dungeon1 = new Dungeon("ez dungeon", 1, monsterList, options);
		dungeons.add(dungeon1);
		this.character = new MainCharacter(0,0,0,0,0);
		System.out.println("FASD");
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
	    this.setLayout(new BorderLayout()); // Set the layout manager before adding components

//	    this.add(new JLabel(/*get the text inside dungeon d*/), BorderLayout.NORTH);
	    this.add(new JLabel("asdkf"), BorderLayout.NORTH);

	    paintStats();
	    
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    int numberOfOptions = d.getOptions().length;

	    for (int i = 0; i < numberOfOptions; i++) {
	    	
	    	JButton button = new JButton(d.getOptions()[i]);
	        button.setUI(new StyledButtonUI());
	        buttonPanel.add(button);
	    }

	    int height = this.getHeight();
	    int targetY = (int) (height * 0.25);

	    this.add(Box.createVerticalStrut(targetY), BorderLayout.CENTER);
	    this.add(buttonPanel, BorderLayout.SOUTH);
	}


	public void paintStats() {
	    this.add(new JLabel("hp : " + character.getHP() + ", basic attack damage : " 
	+ character.getAttackDamage() + ", ability power : " + character.getAbilityPower()), 
	    		BorderLayout.NORTH);
	}
	
	public Dungeon randomDungeon(ArrayList<Dungeon> d) {
		int randNum = (int)(d.size() * Math.random());
		return d.get(randNum);
	}
	
	public void run(Dungeon[] dungeons, MainCharacter c) {
		
	}
	
}
