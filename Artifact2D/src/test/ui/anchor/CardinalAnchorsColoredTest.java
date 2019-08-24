package test.ui.anchor;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.BorderFactory;
import ui.layout.Anchor;

public class CardinalAnchorsColoredTest extends Game {

	public static void main(String[] args) {
		CardinalAnchorsColoredTest game = new CardinalAnchorsColoredTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	private Panel panel;
	
	@Override
	public void onInitialize() {
		panel = new Panel();
		panel.setWidth(300);
		panel.setHeight(200);
		panel.setLayoutAnchor(Anchor.CENTER);
		panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		getUiRoot().add(panel);

		addAnchorPanel(Color.BLUE, Anchor.TOP_LEFT);
		addAnchorPanel(Color.RED, Anchor.TOP_RIGHT);
		addAnchorPanel(Color.MAGENTA, Anchor.BOTTOM_LEFT);
		addAnchorPanel(Color.DARK_GRAY, Anchor.BOTTOM_RIGHT);
		addAnchorPanel(Color.ORANGE, Anchor.CENTER_TOP);
		addAnchorPanel(Color.CYAN, Anchor.CENTER_BOTTOM);
		addAnchorPanel(Color.PINK, Anchor.CENTER);
		addAnchorPanel(Color.BLACK, Anchor.CENTER_LEFT);
		addAnchorPanel(Color.YELLOW, Anchor.CENTER_RIGHT);
	}
	
	private void addAnchorPanel(Color color, Anchor anchor) {
		Panel panel = new Panel();
		panel.setWidth(30);
		panel.setHeight(30);
		panel.setBackground(color);
		panel.setLayoutAnchor(anchor);
		panel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.panel.add(panel);
	}

}
