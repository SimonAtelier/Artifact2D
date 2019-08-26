package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.LineBorder;
import ui.layout.Anchor;

public class CardinalAnchorsMarginTest extends Game {

	public static void main(String[] args) {
		CardinalAnchorsMarginTest game = new CardinalAnchorsMarginTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	private Panel centerPanel;
	
	@Override
	public void onInitialize() {
		getUiRoot().add(getCenterPanel());
	}
	
	private Panel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new Panel();
			centerPanel.setBackground(Color.DARK_GRAY);
			centerPanel.setWidth(420);
			centerPanel.setHeight(210);
			centerPanel.setPadding(10);
			centerPanel.setMargin(20);
			addPanels();
		}
		return centerPanel;
	}
	
	private void addPanels() {
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
		Panel panel = new Panel();
		panel.setWidth(90);
		panel.setHeight(50);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(4, Color.YELLOW));
		panel.setLayoutAnchor(anchor);
		getCenterPanel().add(panel);
	}

}
