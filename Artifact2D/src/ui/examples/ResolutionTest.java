package ui.examples;

import game.Game;
import game.Resolution;

public class ResolutionTest extends Game {

	public static void main(String[] args) {
		ResolutionTest game = new ResolutionTest();
		game.setSize(Resolution.GAMEBOY_160x144, 4);
		game.start();
	}

}
