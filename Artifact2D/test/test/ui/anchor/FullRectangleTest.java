package test.ui.anchor;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.BorderFactory;
import ui.layout.Anchor;

public class FullRectangleTest extends Game {

	public static void main(String[] args) {
		FullRectangleTest game = new FullRectangleTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		Panel contentPanel = new Panel();
		contentPanel.setLayoutAnchor(Anchor.FULL_RECTANGLE);
		
		Panel centerPanel = new Panel();
		centerPanel.setBackground(Color.BLACK);
		centerPanel.setLayoutAnchor(Anchor.FULL_RECTANGLE);
		centerPanel.setBorder(BorderFactory.createCornerSquaresInlinedBorder(5, Color.WHITE, Color.BLACK));
		centerPanel.add(contentPanel);
		centerPanel.setPadding(20);
		
		Panel mainPanel = new Panel();
		mainPanel.setLayoutAnchor(Anchor.FULL_RECTANGLE);
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setPadding(20);
		mainPanel.add(centerPanel);
		
		getUiRoot().add(mainPanel);
	}

}
