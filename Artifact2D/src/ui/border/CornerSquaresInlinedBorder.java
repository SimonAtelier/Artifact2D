package ui.border;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class CornerSquaresInlinedBorder extends AbstractBorder {

	private int x;
	private int y;
	private int width;
	private int height;
	private Graphics2D g2d;
	
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

	private void updatePolypon() {
		resetPolygon();
		addPointToPolygon(x + sizePlusOne, y);
		addPointToPolygon(x + width - sizePlusTwo, y);
		addPointToPolygon(x + width - sizePlusTwo, y + sizePlusOne);
		addPointToPolygon(x + width - 1, y + sizePlusOne);
		addPointToPolygon(x + width - 1, y + height - sizePlusTwo);
		addPointToPolygon(x + width - sizePlusTwo, y + height - sizePlusTwo);
		addPointToPolygon(x + width - sizePlusTwo, y + height - 1);
		addPointToPolygon(x + sizePlusOne, y + height - 1);
		addPointToPolygon(x + sizePlusOne, y + height - sizePlusTwo);
		addPointToPolygon(x, y + height - sizePlusTwo);
		addPointToPolygon(x, y + sizePlusOne);
		addPointToPolygon(x + sizePlusOne, y + sizePlusOne);
	}
	
	private void resetPolygon() {
		polygon.reset();
	}
	
	private void addPointToPolygon(int x, int y) {
		polygon.addPoint(x, y);
	}

	private void updateRectangle() {
		int x = this.x + sizePlusTwo;
		int y = this.y + sizePlusTwo;
		int width = this.width - (squareSize + squareSize + 4);
		int height = this.height - (squareSize + squareSize + 4);
		rectangle.setRect(x, y, width, height);
	}

	private void renderArea() {
		Area area = new Area(polygon);
		Area area2 = new Area(rectangle);
		area.subtract(area2);
		g2d.setColor(fill);
		g2d.fill(area);
	}

	private void renderPolygon() {
		g2d.setColor(color);
		g2d.draw(polygon);
	}

	private void renderCornerRectangles() {
		g2d.drawRect(x, y, squareSize - 1, squareSize - 1);
		g2d.drawRect(x + width - squareSize, y, squareSize - 1, squareSize - 1);
		g2d.drawRect(x + width - squareSize, y + height - squareSize, squareSize - 1, squareSize - 1);
		g2d.drawRect(x, y + height - squareSize, squareSize - 1, squareSize - 1);
	}

	@Override
	public void renderBorder(Graphics2D g2d, int x, int y, int width, int height) {
		setBorderFrame(x, y, width, height);
		setGraphicsContext(g2d);
		updatePolypon();
		updateRectangle();
		renderArea();
		renderPolygon();
		renderCornerRectangles();
	}

	@Override
	public Insets getInsets() {
		return new Insets(squareSize + 2, squareSize + 2, squareSize + 2, squareSize + 2);
	}
	
	private void setBorderFrame(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	private void setGraphicsContext(Graphics2D g2d) {
		this.g2d = g2d;
	}

}
