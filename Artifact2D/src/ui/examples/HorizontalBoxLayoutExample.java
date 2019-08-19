package ui.examples;

import java.awt.Color;

import game.Game;
import ui.HorizontalBox;
import ui.Panel;
import ui.UiElement;
import ui.border.LineBorder;
import ui.border.MessageBoxBorder;
import ui.layout.Anchor;

public class HorizontalBoxLayoutExample extends Game {

	public static void main(String[] args) {
		HorizontalBoxLayoutExample game = new HorizontalBoxLayoutExample();
		game.setSize(480, 270, 3);
		game.start();
	}

	@Override
	public void onInitialize() {
		HorizontalBox horizontalBox = new HorizontalBox();
		horizontalBox.setGap(5);
		horizontalBox.setWidth(200);
		horizontalBox.setHeight(100);
		horizontalBox.setLayoutAnchor(Anchor.CENTER);
		horizontalBox.setBackground(Color.DARK_GRAY);
		horizontalBox.setBorder(new MessageBoxBorder(Color.WHITE, Color.BLACK));
		
		for (int i = 0; i < 5; i++)
			horizontalBox.add(createPanel());
		
		UiElement root = getUiRoot();
		root.add(horizontalBox);
	}
	
	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(1, Color.WHITE));
		return panel;
	}

}
