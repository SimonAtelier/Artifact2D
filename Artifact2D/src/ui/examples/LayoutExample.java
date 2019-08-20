package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.UiElement;
import ui.border.Border;
import ui.border.BorderFactory;
import ui.layout.Anchor;
import ui.layout.HorizontalBoxLayout;
import ui.layout.VerticalBoxLayout;

public class LayoutExample extends Game {

	public static void main(String[] args) {
		LayoutExample game = new LayoutExample();
		game.setSize(480, 270, 3);
		game.start();
	}

	private Panel mainPanel;
	private Panel leftPanel;
	private Panel centerPanel;
	private Panel rightPanel;

	@Override
	public void onInitialize() {
		UiElement uiRoot = getUiRoot();
		uiRoot.add(getMainPanel());
	}

	private Panel getMainPanel() {
		if (mainPanel == null) {
			mainPanel = new Panel();
			mainPanel.setLayoutAnchor(Anchor.FULL_RECTANGLE);
			mainPanel.setOpaque(false);
			mainPanel.setBorder(BorderFactory.createEmptyBorder(40));
			mainPanel.setLayout(new HorizontalBoxLayout(5));
			mainPanel.add(getLeftPanel());
			mainPanel.add(getCenterPanel());
			mainPanel.add(getRightPanel());
		}
		return mainPanel;
	}

	private Panel getLeftPanel() {
		if (leftPanel == null) {
			leftPanel = createBoxPanel(Color.RED, 5);
		}
		return leftPanel;
	}

	private Panel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = createBoxPanel(Color.GREEN, 10);
		}
		return centerPanel;
	}

	private Panel getRightPanel() {
		if (rightPanel == null) {
			rightPanel = createBoxPanel(Color.BLUE, 15);
		}
		return rightPanel;
	}

	private Panel createBoxPanel(Color color, int gap) {
		Panel panel = new Panel();
		panel.setLayout(new VerticalBoxLayout(0));
		panel.setBackground(color);
		panel.setBorder(createBoxPanelBorder());
		for (int i = 0; i < 5; i++)
			panel.add(createPanel());
		return panel;
	}
	
	private Border createBoxPanelBorder() {
		Border innerBorder = BorderFactory.createLineBorder(10, Color.DARK_GRAY);
		Border outerBorder = BorderFactory.createMessageBoxBorder(Color.WHITE, Color.BLACK);
		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		return compoundBorder;
	}

	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setBorder(BorderFactory.createMessageBoxBorder(Color.WHITE, Color.BLACK));
		return panel;
	}

}
