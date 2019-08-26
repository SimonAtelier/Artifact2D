package ui.painter;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class GradientBackgroundPainter implements Painter {
	
	private Color color1;
	private Color color2;
	
	public GradientBackgroundPainter() {
		this(Color.GRAY, Color.DARK_GRAY);
	}
	
	public GradientBackgroundPainter(Color color1, Color color2) {
		this.color1 = color1;
		this.color2 = color2;
	}

	@Override
	public void paint(Graphics2D g2d, int x, int y, int width, int height) {
		Point2D pt1 = new Point2D.Double(x + (width / 2), y);
		Point2D pt2 = new Point2D.Double(x + (width / 2), y + (height / 2));
		GradientPaint gradientPaint = new GradientPaint(pt1, color1, pt2, color2);
		g2d.setPaint(gradientPaint);
		g2d.fillRect(x, y, width, height);
	}

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

}
