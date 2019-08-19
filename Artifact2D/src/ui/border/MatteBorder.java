package ui.border;

import java.awt.Color;
import java.awt.Graphics2D;

public class MatteBorder extends AbstractBorder {

	private Insets insets;
	private Color color;

	public MatteBorder(int top, int left, int bottom, int right, Color color) {
		insets = new Insets(top, left, bottom, right);
		this.color = color;
	}

	private void renderTopBorder(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.fillRect(x + insets.left, y, width - insets.left - insets.right, insets.top);
	}

	private void renderBottomBorder(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.fillRect(x + insets.left, y + height - insets.bottom, width - insets.left - insets.right, insets.bottom);
	}

	private void renderLeftBorder(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.fillRect(x, y, insets.left, height);
	}

	private void renderRightBorder(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.fillRect(x + width - insets.right, y, insets.right, height);
	}

	@Override
	public void renderBorder(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.setColor(color);
		renderTopBorder(g2d, x, y, width, height);
		renderBottomBorder(g2d, x, y, width, height);
		renderLeftBorder(g2d, x, y, width, height);
		renderRightBorder(g2d, x, y, width, height);
	}

	@Override
	public Insets getInsets() {
		return new Insets(insets);
	}

}
