package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.BorderFactory;
import ui.border.RoundLineBorder;
import ui.layout.Anchor;
import ui.layout.GridLayout;

public class GridLayoutTest extends Game {

	public static void main(String[] args) {
		GridLayoutTest game = new GridLayoutTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	private Panel centerPanel;
	
	@Override
	public void onInitialize() {
		centerPanel = new Panel();
		centerPanel.setLayoutAnchor(Anchor.CENTER);
		centerPanel.setLayout(new GridLayout(3, 3));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		centerPanel.setPadding(2);
		getUiRoot().add(centerPanel);
		
		for (int i = 0; i < 9; i++) {
			Panel titlePanel = new Panel();
			titlePanel.setPadding(2);
			titlePanel.setBackground(Color.LIGHT_GRAY);
			titlePanel.setBorder(BorderFactory.createTitledBorder("Title-" + i, 1, Color.BLACK, Color.WHITE));
			titlePanel.setLayout(new GridLayout(2, 3));
			titlePanel.setMargin(4);
			centerPanel.add(titlePanel);
			
			for (int j = 0; j < 6; j++) {
				Panel panel = new Panel();
				panel.setWidth(20);
				panel.setHeight(20);
				panel.setMargin(2);
				panel.setBorder(new RoundLineBorder(Color.WHITE));
				titlePanel.add(panel);
			}
		}
	}

}
