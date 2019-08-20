package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.DashedBorder;
import ui.layout.Anchor;

public class DashedBorderExample extends Game {

	public static void main(String[] args) {
		DashedBorderExample game = new DashedBorderExample();
		game.setSize(480, 240, 3);
		game.start();
	}
	
	private DashedBorder border;
	
	@Override
	public void onInitialize() {
		border = new DashedBorder(Color.LIGHT_GRAY);
		
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayoutAnchor(Anchor.CENTER);
		panel.setBorder(border);
		getUiRoot().add(panel);
	}
	
	@Override
	public void onUpdate(float deltaTime) {
		border.setOffset(border.getOffset() + (deltaTime * 10f));
	}

}
