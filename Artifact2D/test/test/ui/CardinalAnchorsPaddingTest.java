package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.border.LineBorder;
import ui.layout.Anchor;

public class CardinalAnchorsPaddingTest extends Game {

	public static void main(String[] args) {
		CardinalAnchorsPaddingTest game = new CardinalAnchorsPaddingTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		setupRoot();
		addPanels();
	}
	
	private void setupRoot() {
		getUiRoot().setWidth(480 - 40);
		getUiRoot().setHeight(270 - 40);
		getUiRoot().setPadding(20);
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
		UiElement root = getUiRoot();
		Panel panel = createPanel();
		panel.setLayoutAnchor(anchor);
		root.add(panel);
	}

	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setWidth(90);
		panel.setHeight(50);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(4, Color.YELLOW));
		return panel;
	}

}
