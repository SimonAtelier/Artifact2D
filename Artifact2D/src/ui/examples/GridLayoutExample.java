package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.border.LineBorder;
import ui.border.MessageBoxBorder;
import ui.layout.Anchor;
import ui.layout.GridLayout;

public class GridLayoutExample extends Game {

	public static void main(String[] args) {
		GridLayoutExample game = new GridLayoutExample();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		GridLayout gridLayout = new GridLayout(5, 3);
		gridLayout.setVerticalGap(1);
		gridLayout.setHorizontalGap(1);
		
		Panel panel = new Panel();
		panel.setWidth(67);
		panel.setHeight(108);
		panel.setLayoutAnchor(Anchor.CENTER_TOP);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new MessageBoxBorder(Color.WHITE, Color.BLACK));
		panel.setLayout(gridLayout);
		
		for (int i = 0; i < 15; i++)
			panel.add(createPanel());
		
		UiElement root = getUiRoot();
		root.add(panel);
	}

	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(1, Color.WHITE));
		return panel;
	}

}
