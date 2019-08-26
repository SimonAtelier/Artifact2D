package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.BorderFactory;
import ui.border.RoundLineBorder;
import ui.layout.Anchor;
import ui.layout.HorizontalLayout;
import ui.layout.VerticalLayout;

public class VerticalHorizontalLayoutTest extends Game {

	public static void main(String[] args) {
		VerticalHorizontalLayoutTest game = new VerticalHorizontalLayoutTest();
		game.setSize(480, 270, 3);
		game.setTitle("Layout Test");
		game.start();
	}

	@Override
	public void onInitialize() {
		Panel verticalPanel = new Panel();
		verticalPanel.setLayout(new VerticalLayout());
		verticalPanel.setLayoutAnchor(Anchor.CENTER);
		verticalPanel.setOpaque(false);

		for (int i = 0; i < 5; i++) {
			Panel panel1 = new Panel();
			panel1.setMargin(0);
			panel1.setBackground(Color.DARK_GRAY);
			panel1.setPadding(0);
			panel1.setBorder(BorderFactory.createNineSliceBorder("borders/border_5.png", true));
			panel1.setLayout(new HorizontalLayout());
			panel1.setMarginBottom(3);

			for (int j = 0; j < 10; j++) {
				Panel panel = new Panel();
				panel.setLayout(new VerticalLayout());
				panel.setWidth(17);
				panel.setHeight(17);
				panel.setBackground(Color.DARK_GRAY);
				panel.setMargin(i);
				panel.setBorder(new RoundLineBorder(Color.WHITE));
				panel.setPadding(2);
				panel1.add(panel);
			}

			verticalPanel.add(panel1);
		}

		getUiRoot().add(verticalPanel);
	}

}
