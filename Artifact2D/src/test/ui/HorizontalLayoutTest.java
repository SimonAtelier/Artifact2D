package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.layout.HorizontalLayout;

public class HorizontalLayoutTest extends Game {

	public static void main(String[] args) {
		HorizontalLayoutTest game = new HorizontalLayoutTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		Panel mainPanel = new Panel();
		mainPanel.setLayout(new HorizontalLayout());
		
		Panel leftPanel = new Panel();
		leftPanel.setWidth(100);
		leftPanel.setHeight(270);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(leftPanel);
		
		Panel centerPanel = new Panel();
		centerPanel.setWidth(300);
		centerPanel.setHeight(270);
		centerPanel.setBackground(Color.DARK_GRAY);
		mainPanel.add(centerPanel);
		
		Panel rightPanel = new Panel();
		rightPanel.setWidth(80);
		rightPanel.setHeight(270);
		rightPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(rightPanel);
		
		getUiRoot().add(mainPanel);
	}
	
}
