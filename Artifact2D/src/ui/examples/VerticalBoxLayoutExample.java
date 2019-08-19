package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.VerticalBox;
import ui.border.LineBorder;
import ui.border.MessageBoxBorder;
import ui.layout.Anchor;

public class VerticalBoxLayoutExample extends Game {

	public static void main(String[] args) {
		VerticalBoxLayoutExample game = new VerticalBoxLayoutExample();
		game.setSize(480, 270, 3);
		game.start();
	}

	@Override
	public void onInitialize() {
		VerticalBox verticalBox = new VerticalBox();
		verticalBox.setGap(5);
		verticalBox.setWidth(100);
		verticalBox.setHeight(200);
		verticalBox.setLayoutAnchor(Anchor.CENTER);
		verticalBox.setBackground(Color.DARK_GRAY);
		verticalBox.setBorder(new MessageBoxBorder(Color.WHITE, Color.BLACK));

		for (int i = 0; i < 5; i++)
			verticalBox.add(createPanel());

		UiElement root = getUiRoot();
		root.add(verticalBox);
	}

	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new LineBorder(1, Color.WHITE));
		return panel;
	}

}
