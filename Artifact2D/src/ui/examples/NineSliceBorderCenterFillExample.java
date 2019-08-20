package ui.examples;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.Game;
import game.Resources;
import ui.Panel;
import ui.border.Border;
import ui.border.NineSliceBorder;
import ui.layout.Anchor;

public class NineSliceBorderCenterFillExample extends Game {

	public static void main(String[] args) {
		NineSliceBorderCenterFillExample game = new NineSliceBorderCenterFillExample();
		game.setSize(480, 270, 3);
		game.start();
	}

	private BufferedImage borderImage;

	@Override
	public void onInitialize() {
		loadImage();
		getUiRoot().add(createPanel());
	}
	
	private void loadImage() {
		borderImage = Resources.load("borders/shaun_spalding_border.png");
	}
	
	private Panel createPanel() {
		Panel panel = new Panel();
		panel.setBorder(createBorder());
		panel.setWidth(200);
		panel.setHeight(112);
		panel.setLayoutAnchor(Anchor.CENTER);
		return panel;
	}
	
	private Border createBorder() {
		NineSliceBorder border = new NineSliceBorder(borderImage);
		border.setFillCenter(true);
		return border;
	}
	
	@Override
	public void onRender(Graphics2D g2d) {
		g2d.drawImage(borderImage, 0, 0, null);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.drawString("All rights of this border image are reserved by 'Shaun Spalding'.", 40, 40);
		g2d.drawString("Support him on patreon and YouTube.", 40, 50);
		g2d.drawString("https://www.patreon.com/shaunjs", 40, 60);
		g2d.drawString("https://www.youtube.com/watch?v=Cgb6yw1WdRw", 40, 70);
	}

}
