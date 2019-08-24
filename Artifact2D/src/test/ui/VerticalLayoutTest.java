package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.BorderFactory;
import ui.layout.Anchor;
import ui.layout.VerticalLayout;

public class VerticalLayoutTest extends Game {

	public static void main(String[] args) {
		VerticalLayoutTest game = new VerticalLayoutTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		Panel mainPanel = new Panel();
		mainPanel.setWidth(250);
		mainPanel.setLayout(new VerticalLayout());
		mainPanel.setLayoutAnchor(Anchor.CENTER);
		mainPanel.setPadding(5);
		mainPanel.setBorder(BorderFactory.createCornerSquaresInlinedBorder(4, Color.LIGHT_GRAY, Color.GRAY));

		Panel topPanel = new Panel();
		topPanel.setLayoutAnchor(Anchor.HORIZONTAL_WIDE);
		topPanel.setHeight(20);
		topPanel.setBorder(BorderFactory.createTitledBorder("Title", 2, Color.GRAY, Color.DARK_GRAY));
		topPanel.setBackground(Color.LIGHT_GRAY);
		topPanel.setMarginBottom(10);
		mainPanel.add(topPanel);
		
		Panel centerPanel = new Panel();
		centerPanel.setLayoutAnchor(Anchor.HORIZONTAL_WIDE);
		centerPanel.setHeight(100);
		centerPanel.setBorder(BorderFactory.createLoweredEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		centerPanel.setMarginBottom(10);
		mainPanel.add(centerPanel);
		
		Panel bottomPanel = new Panel();
		bottomPanel.setLayoutAnchor(Anchor.HORIZONTAL_WIDE);
		bottomPanel.setHeight(20);
		bottomPanel.setBorder(BorderFactory.createLoweredEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		mainPanel.add(bottomPanel);
		
		getUiRoot().add(mainPanel);
	}
	
}
