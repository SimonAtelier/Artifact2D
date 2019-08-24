package test.ui;

import java.awt.Color;

import game.Game;
import ui.Panel;
import ui.border.Border;
import ui.border.BorderFactory;
import ui.layout.Anchor;
import ui.layout.GridLayout;

public class BordersTest extends Game {

	public static void main(String[] args) {
		BordersTest game = new BordersTest();
		game.setSize(480, 270, 3);
		game.start();
	}
	
	private Panel borderPanel;
	
	@Override
	public void onInitialize() {
		getUiRoot().add(getBorderPanel());
		getUiRoot().setOpaque(false);
	}
	
	private Panel getBorderPanel() {
		if (borderPanel == null) {
			borderPanel = new Panel();
			borderPanel.setLayout(new GridLayout(5, 3));
			borderPanel.setLayoutAnchor(Anchor.CENTER);
			borderPanel.setPadding(2);
			addPanels();
		}
		return borderPanel;
	}
	
	private void addPanels() {
		addPanel(BorderFactory.createBevelBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		addPanel(BorderFactory.createColoredCornersBorder(2, Color.WHITE, Color.DARK_GRAY));
		addPanel(BorderFactory.createCornerGapBorder(Color.LIGHT_GRAY));
		addPanel(BorderFactory.createCornerSquaresBorder(4, Color.WHITE));
		addPanel(BorderFactory.createCornerSquaresInlinedBorder(5, Color.WHITE, Color.DARK_GRAY));
		addPanel(BorderFactory.createDashedBorder(Color.WHITE));
		addPanel(BorderFactory.createKeyLabelBorder(Color.DARK_GRAY, Color.LIGHT_GRAY));
		addPanel(BorderFactory.createLineBorder(Color.WHITE));
		addPanel(BorderFactory.createLoweredEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		addPanel(BorderFactory.createMatteBorder(2, 3, 5, 2, Color.WHITE));
		addPanel(BorderFactory.createMessageBoxBorder(Color.WHITE, Color.BLACK));
		addPanel(BorderFactory.createNineSliceBorder("borders/border_5.png", true));
		addPanel(BorderFactory.createRaisedEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		addPanel(BorderFactory.createTitledBorder("Title", 2, Color.GRAY, Color.DARK_GRAY));
		addPanel(BorderFactory.createRoundLineBorder(Color.WHITE));
	}

	private void addPanel(Border border) {
		Panel panel = new Panel();
		panel.setWidth(100 - border.getInsets().getHorizontalInsets());
		panel.setHeight(40 - border.getInsets().getVerticalInsets());
		panel.setMargin(2);
		panel.setBorder(border);
		getBorderPanel().add(panel);
	}

}
