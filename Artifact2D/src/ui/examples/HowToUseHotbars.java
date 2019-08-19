package ui.examples;

import java.awt.Color;

import game.Game;
import ui.Hotbar;
import ui.border.Border;
import ui.border.BorderFactory;
import ui.border.CompoundBorder;
import ui.layout.Anchor;

public class HowToUseHotbars extends Game {
	
	public static void main(String[] args) {
		HowToUseHotbars game = new HowToUseHotbars();
		game.setTitle("How to use hotbars");
		game.setSize(480, 270, 3);
		game.start();
	}
	
	@Override
	public void onInitialize() {
		Border outerBorder = BorderFactory.createEmptyBorder(5);
		Border innerBorder = BorderFactory.createRaisedEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY);
		Hotbar bottomHotbar = new Hotbar(12, 16);
		bottomHotbar.setBorder(new CompoundBorder(outerBorder, innerBorder));
		bottomHotbar.setLayoutAnchor(Anchor.CENTER_BOTTOM);
		getUiRoot().add(bottomHotbar);
		
		Hotbar centerHotBar = new Hotbar(5, 30);
		centerHotBar.setSlotBorder(BorderFactory.createRaisedEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		centerHotBar.setLayoutAnchor(Anchor.CENTER);
		getUiRoot().add(centerHotBar);
	}

}
