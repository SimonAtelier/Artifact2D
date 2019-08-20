package ui.border;

import java.awt.Color;
import java.awt.image.BufferedImage;

import game.Resources;

public class BorderFactory {

	public static Border createNineSliceBorder(String file, boolean fillCenter) {
		NineSliceBorder border = new NineSliceBorder(Resources.load(file));
		border.setFillCenter(fillCenter);
		return border;
	}
	
	public static Border createNineSliceBorder(String file) {
		return createNineSliceBorder(file, false);
	}
	
	public static Border createNineSliceBorder(BufferedImage image, boolean fillCenter) {
		NineSliceBorder border = new NineSliceBorder(image);
		border.setFillCenter(fillCenter);
		return border;
	}
	
	public static Border createNineBorder(BufferedImage image) {
		return createNineSliceBorder(image, false);
	}
	
	public static Border createDashedBorder(Color color) {
		return new DashedBorder(color);
	}

	public static Border createBevelBorder(Color light, Color shadow) {
		return new BevelBorder(light, shadow);
	}

	public static Border createCompoundBorder(Border outerBorder, Border innerBorder) {
		return new CompoundBorder(outerBorder, innerBorder);
	}

	public static Border createCornerSquaresBorder(int squareSize, Color color) {
		return new CornerSquaresBorder(squareSize, color);
	}

	public static Border createCornerSquaresInlinedBorder(int squareSize, Color color, Color fill) {
		return new CornerSquaresInlinedBorder(squareSize, color, fill);
	}

	public static Border createEmptyBorder(int top, int left, int bottom, int right) {
		return new EmptyBorder(top, left, bottom, right);
	}
	
	public static Border createEmptyBorder(int size) {
		return createEmptyBorder(size, size, size, size);
	}

	public static Border createKeyLabelBorder(Color shadow, Color background) {
		return new KeyLabelBorder(shadow, background);
	}

	public static Border createLineBorder(int size, Color color) {
		return new LineBorder(size, color);
	}
	
	public static Border createLineBorder(Color color) {
		return new LineBorder(1, color);
	}

	public static Border createLoweredEtchedBorder(Color lightColor, Color darkColor) {
		return new LoweredEtchedBorder(lightColor, darkColor);
	}

	public static Border createMatteBorder(int top, int left, int bottom, int right, Color color) {
		return new MatteBorder(top, left, bottom, right, color);
	}

	public static Border createMessageBoxBorder(Color outerColor, Color innerColor) {
		return new MessageBoxBorder(outerColor, innerColor);
	}

	public static Border createNineSliceBorder(BufferedImage image) {
		return new NineSliceBorder(image);
	}

	public static Border createRaisedEtchedBorder(Color lightColor, Color darkColor) {
		return new RaisedEtchedBorder(lightColor, darkColor);
	}

	public static Border createTitledBorder(String text, int size, Color textColor, Color color) {
		return new TitledBorder(text, size, textColor, color);
	}
	
}
