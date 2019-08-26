package ui.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

public class RadialGradientBackgroundPainter implements Painter {

	private float radius;
	private int width;
	private int height;
	private static final float[] FRACTIONS = new float[] { 0f, 0.5f, 1f};
	private Color[] colors = new Color[] { Color.BLACK, Color.WHITE , Color.BLACK};
	
	private RadialGradientPaint getGradientPaint() {
		float radius = getRadius();
		float[] fractions = FRACTIONS;
		Color[] colors = getColors();
		Point2D center = getCenter();
		return new RadialGradientPaint(center, radius, fractions, colors);
	}
	
	@Override
	public void paint(Graphics2D g2d, int x, int y, int width, int height) {
		this.width = width;
		this.height = height;
		g2d.setPaint(getGradientPaint());
		g2d.fillRect(0, 0, width, height);
	}
	
	private Color[] getColors() {
		return colors;
	}

	private Point2D getCenter() {
		return new Point2D.Float(getHalfWidth(), getHalfHeight());
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	private float getRadius() {
		return radius > 0 ? radius : 0.0001f;
	}

	private int getWidth() {
		return width;
	}

	private int getHeight() {
		return height;
	}

	private int getHalfWidth() {
		return getWidth() / 2;
	}

	private int getHalfHeight() {
		return getHeight() / 2;
	}

	public Color getColor1() {
		return colors[0];
	}

	public void setColor1(Color color1) {
		colors[0] = color1;
	}

	public Color getColor2() {
		return colors[1];
	}

	public void setColor2(Color color2) {
		this.colors[1] = color2;
	}
	
}
