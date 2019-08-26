package ui.painter;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

public class GlossyButtonPainter implements Painter {

	private int arcWidth;
	private int arcHeight;
	private Color color1;
	private Color color2;
	
	public GlossyButtonPainter() {
		this(20, 20, Color.GRAY.brighter(), Color.GRAY.darker());
	}

	public GlossyButtonPainter(int arcWidth, int arcHeight, Color color1, Color color2) {
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
		this.color1 = color1;
		this.color2 = color2;
	}
	
	@Override
	public void paint(Graphics2D g2d, int x, int y, int width, int height) {
		Point2D pt1 = new Point2D.Double(x + (width / 2), y);
		Point2D pt2 = new Point2D.Double(x + (width / 2), y + (height / 2));
		GradientPaint gradientPaint = new GradientPaint(pt1, color1, pt2, color2);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setPaint(gradientPaint);
		g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
		drawHighlight(g2d, x, y, width, height);
	}
	
	private void drawHighlight(Graphics2D g2d, int x, int y, int width, int height) {
		Point2D pt1 = new Point2D.Double(x + (width / 2), y);
		Point2D pt2 = new Point2D.Double(x + (width / 2), y + (height / 2));
		Color color1 = new Color(255, 255, 255, 128);
		Color color2 = new Color(255, 255, 255, 20);
		GradientPaint gradientPaint = new GradientPaint(pt1, color1, pt2, color2);
		g2d.setPaint(gradientPaint);
		g2d.drawRoundRect(x, y, width - 1, height - 1, arcWidth, arcHeight);
	}

	public int getArcWidth() {
		return arcWidth;
	}

	public void setArcWidth(int arcWidth) {
		this.arcWidth = arcWidth;
	}

	public int getArcHeight() {
		return arcHeight;
	}

	public void setArcHeight(int arcHeight) {
		this.arcHeight = arcHeight;
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
