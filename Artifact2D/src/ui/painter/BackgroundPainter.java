package ui.painter;

import java.awt.Color;
import java.awt.Graphics2D;

public class BackgroundPainter implements Painter {

	private Color color;
	
	public BackgroundPainter() {
		this(Color.BLACK);
	}

	public BackgroundPainter(Color color) {
		this.color = color;
	}

	@Override
	public void paint(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.setColor(getColor());
		g2d.fillRect(x, y, width, height);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
