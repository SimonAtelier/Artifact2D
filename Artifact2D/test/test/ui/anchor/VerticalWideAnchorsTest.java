package test.ui.anchor;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.border.LineBorder;
import ui.layout.Anchor;

public class VerticalWideAnchorsTest extends Game {

	public static void main(String[] args) {
		VerticalWideAnchorsTest game = new VerticalWideAnchorsTest();
		game.setSize(480, 270, 3);
		game.start();
	}

	@Override
	public void onInitialize() {
		addPanel(Anchor.LEFT_WIDE);
		addPanel(Anchor.VERTICAL_CENTER_WIDE);
		addPanel(Anchor.RIGHT_WIDE);
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
		panel.setBorder(new LineBorder(2, Color.YELLOW));
		return panel;
	}

}
