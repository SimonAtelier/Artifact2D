package ui.border;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class CornerSquaresInlinedBorder extends AbstractBorder {

	private int sizePlusOne;
	private int sizePlusTwo;

	private int squareSize;
	private Color color;
	private Color fill;
	private Polygon polygon;
	private Rectangle2D rectangle;

	public CornerSquaresInlinedBorder(int squareSize, Color color, Color fill) {
		this.squareSize = squareSize;
		this.color = color;
		this.fill = fill;
		polygon = new Polygon();
		rectangle = new Rectangle2D.Double();
		sizePlusOne = squareSize + 1;
		sizePlusTwo = squareSize + 2;
	}

	private void updatePolypon(int x, int y, int width, int height) {
		polygon.reset();
		polygon.addPoint(x + sizePlusOne, y);
		polygon.addPoint(x + width - sizePlusTwo, y);
		polygon.addPoint(x + width - sizePlusTwo, y + sizePlusOne);
		polygon.addPoint(x + width - 1, y + sizePlusOne);
		polygon.addPoint(x + width - 1, y + height - sizePlusTwo);
		polygon.addPoint(x + width - sizePlusTwo, y + height - sizePlusTwo);
		polygon.addPoint(x + width - sizePlusTwo, y + height - 1);
		polygon.addPoint(x + sizePlusOne, y + height - 1);
		polygon.addPoint(x + sizePlusOne, y + height - sizePlusTwo);
		polygon.addPoint(x, y + height - sizePlusTwo);
		polygon.addPoint(x, y + sizePlusOne);
		polygon.addPoint(x + sizePlusOne, y + sizePlusOne);
	}

	private void updateRectangle(int x, int y, int width, int height) {
		x += sizePlusTwo;
		y += sizePlusTwo;
		width -= (squareSize + squareSize + 4);
		height -= (squareSize + squareSize + 4);
		rectangle.setRect(x, y, width, height);
	}

	private void renderArea(Graphics2D g2d, int x, int y, int width, int height) {
		Area area = new Area(polygon);
		Area area2 = new Area(rectangle);
		area.subtract(area2);
		g2d.setColor(fill);
		g2d.fill(area);
	}

	private void renderPolygon(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.setColor(color);
		g2d.draw(polygon);
	}

	private void renderCornerRectangles(Graphics2D g2d, int x, int y, int width, int height) {
		g2d.drawRect(x, y, squareSize - 1, squareSize - 1);
		g2d.drawRect(x + width - squareSize, y, squareSize - 1, squareSize - 1);
		g2d.drawRect(x + width - squareSize, y + height - squareSize, squareSize - 1, squareSize - 1);
		g2d.drawRect(x, y + height - squareSize, squareSize - 1, squareSize - 1);
	}

	@Override
	public void renderBorder(Graphics2D g2d, int x, int y, int width, int height) {
		updatePolypon(x, y, width, height);
		updateRectangle(x, y, width, height);
		renderArea(g2d, x, y, width, height);
		renderPolygon(g2d, x, y, width, height);
		renderCornerRectangles(g2d, x, y, width, height);
	}

	@Override
	public Insets getInsets() {
		return new Insets(squareSize + 2, squareSize + 2, squareSize + 2, squareSize + 2);
	}

}
