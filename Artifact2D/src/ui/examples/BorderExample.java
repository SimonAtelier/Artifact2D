package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.border.BorderFactory;
import ui.layout.Anchor;
import ui.layout.GridLayout;

public class BorderExample extends Game {

	public static void main(String[] args) {
		BorderExample game = new BorderExample();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		Panel mainPanel = new Panel();
		mainPanel.setBackground(new Color(20, 20, 20));
		mainPanel.setLayoutAnchor(Anchor.FULL_RECTANGLE);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10));
		mainPanel.setLayout(new GridLayout(5, 2, 5, 5));
		
		Panel panel0 = new Panel();
		panel0.setBorder(BorderFactory.createBevelBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));	
		mainPanel.add(panel0);
		
		Panel panel1 = new Panel();
		panel1.setBorder(BorderFactory.createCornerSquaresBorder(5, Color.WHITE));	
		mainPanel.add(panel1);
		
		Panel panel2 = new Panel();
		panel2.setBorder(BorderFactory.createCornerSquaresInlinedBorder(5, Color.WHITE, Color.GRAY));	
		mainPanel.add(panel2);
		
		Panel panel3 = new Panel();
		panel3.setBorder(BorderFactory.createKeyLabelBorder(Color.DARK_GRAY, Color.LIGHT_GRAY));
		mainPanel.add(panel3);
		
		Panel panel4 = new Panel();
		panel4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		mainPanel.add(panel4);
		
		Panel panel5 = new Panel();
		panel5.setBorder(BorderFactory.createLoweredEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		mainPanel.add(panel5);
		
		Panel panel6 = new Panel();
		panel6.setBorder(BorderFactory.createMatteBorder(4, 2, 1, 10, Color.WHITE));
		mainPanel.add(panel6);
		
		Panel panel7 = new Panel();
		panel7.setBorder(BorderFactory.createMessageBoxBorder(Color.WHITE, Color.BLACK));
		mainPanel.add(panel7);
		
		Panel panel8 = new Panel();
		panel8.setBorder(BorderFactory.createRaisedEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		mainPanel.add(panel8);
		
		Panel panel9 = new Panel();
		panel9.setBorder(BorderFactory.createTitledBorder("Untitled", 2, Color.GRAY, Color.WHITE));
		mainPanel.add(panel9);

		UiElement uiRoot = getUiRoot();
		uiRoot.add(mainPanel);
	}

}
