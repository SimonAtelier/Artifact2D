package ui.border;

import java.awt.Graphics2D;

public class EmptyBorder extends AbstractBorder {

	private Insets insets;

	public EmptyBorder(int top, int left, int bottom, int right) {
		insets = new Insets(top, left, bottom, right);
	}

	@Override
	public void renderBorder(Graphics2D g2d, int x, int y, int width, int height) {
	}

	@Override
	public Insets getInsets() {
		return new Insets(insets);
	}

}
