package test.ui.anchor;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.border.LineBorder;
import ui.layout.Anchor;

public class CardinalAnchorsTest extends Game {

	public static void main(String[] args) {
		CardinalAnchorsTest game = new CardinalAnchorsTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		addPanel(Anchor.TOP_LEFT);
		addPanel(Anchor.CENTER_TOP);
		addPanel(Anchor.TOP_RIGHT);
		addPanel(Anchor.CENTER_LEFT);
		addPanel(Anchor.CENTER);
		addPanel(Anchor.CENTER_RIGHT);
		addPanel(Anchor.BOTTOM_LEFT);
		addPanel(Anchor.CENTER_BOTTOM);
		addPanel(Anchor.BOTTOM_RIGHT);
	}

	private void addPanel(Anchor anchor) {
		UiElement root = getUiRoot();
		Panel panel = createPanel();
		panel.setLayoutAnchor(anchor);
		root.add(panel);
	}

	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(50);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(4, Color.YELLOW));
		return panel;
	}

}
