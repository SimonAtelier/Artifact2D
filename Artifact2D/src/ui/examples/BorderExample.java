package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.Border;
import ui.border.BorderFactory;
import ui.layout.Anchor;
import ui.layout.GridLayout;

public class BorderExample extends Game {

	public static void main(String[] args) {
		BorderExample game = new BorderExample();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	private Panel mainPanel;
	
	@Override
	public void onInitialize() {
		initializeMainPanel();
		addBorderPanels();
		getUiRoot().add(mainPanel);
	}
	
	private void initializeMainPanel() {
		mainPanel = createMainPanel();
	}
	
	private void addBorderPanels() {
		addBorderPanel(BorderFactory.createBevelBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		addBorderPanel(BorderFactory.createCornerSquaresBorder(5, Color.WHITE));
		addBorderPanel(BorderFactory.createCornerSquaresInlinedBorder(5, Color.WHITE, Color.GRAY));
		addBorderPanel(BorderFactory.createKeyLabelBorder(Color.DARK_GRAY, Color.LIGHT_GRAY));
		addBorderPanel(BorderFactory.createLineBorder(Color.WHITE));
		addBorderPanel(BorderFactory.createLoweredEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		addBorderPanel(BorderFactory.createMatteBorder(4, 2, 1, 10, Color.WHITE));
		addBorderPanel(BorderFactory.createMessageBoxBorder(Color.WHITE, Color.BLACK));
		addBorderPanel(BorderFactory.createRaisedEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		addBorderPanel(BorderFactory.createTitledBorder("Untitled", 2, Color.GRAY, Color.WHITE));
		addBorderPanel(BorderFactory.createCornerGapBorder(3, Color.LIGHT_GRAY));
	}
	
	private Panel createMainPanel() {
		Panel mainPanel = new Panel();
		mainPanel.setBackground(new Color(20, 20, 20));
		mainPanel.setLayoutAnchor(Anchor.FULL_RECTANGLE);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10));
		mainPanel.setLayout(new GridLayout(6, 2, 5, 5));
		return mainPanel;
	}
	
	private void addBorderPanel(Border border) {
		mainPanel.add(createBorderPanel(border));
	}
	
	private Panel createBorderPanel(Border border) {
		Panel panel = new Panel();
		panel.setBorder(border);
		return panel;
	}

}
