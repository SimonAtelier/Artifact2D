package ui.examples;

import java.awt.Color;

import game.Game;
import ui.UiElement;
import ui.border.CornerSquaresBorder;
import ui.border.MessageBoxBorder;
import ui.layout.Anchor;

public class SimpleGameExample extends Game {

	public static void main(String[] args) {
		SimpleGameExample game = new SimpleGameExample();
		game.setSize(480, 270, 3);
		game.setTitle("My Game");
		game.start();
	}

	@Override
	public void onInitialize() {
		UiElement uiElement = new UiElement();
		uiElement.setWidth(200);
		uiElement.setHeight(100);
		uiElement.setBackground(Color.DARK_GRAY);
		uiElement.setBorder(new MessageBoxBorder(Color.WHITE, Color.BLACK));
		uiElement.setLayoutAnchor(Anchor.CENTER);

		UiElement uiRoot = getUiRoot();
		uiRoot.setBorder(new CornerSquaresBorder(5, Color.LIGHT_GRAY));
		uiRoot.add(uiElement);
	}

}
