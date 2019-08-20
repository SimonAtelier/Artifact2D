package ui.examples;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.Game;
import game.Resources;
import ui.Panel;
import ui.border.NineSliceBorder;
import ui.layout.Anchor;

public class NineSliceBorderExample extends Game {

	public static void main(String[] args) {
		NineSliceBorderExample game = new NineSliceBorderExample();
		game.setSize(480, 270, 3);
		game.start();
	}

	private BufferedImage borderImage;

	@Override
	public void onInitialize() {
		borderImage = Resources.load("borders/border.png");

		Panel panel = new Panel();
		panel.setBorder(new NineSliceBorder(borderImage));
		panel.setWidth(200);
		panel.setHeight(100);
		panel.setBackground(Color.WHITE);
		panel.setLayoutAnchor(Anchor.CENTER);

		getUiRoot().setOpaque(true);
		getUiRoot().setBackground(Color.DARK_GRAY);
		getUiRoot().add(panel);
	}
	
	@Override
	public void onRender(Graphics2D g2d) {
		g2d.drawImage(borderImage, 0, 0, null);
	}

}
