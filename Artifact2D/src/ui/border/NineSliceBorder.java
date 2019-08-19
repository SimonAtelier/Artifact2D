package ui.border;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class NineSliceBorder implements Border {

	private int x;
	private int y;
	private int width;
	private int height;
	private Graphics2D g2d;
	private ImageSlicer slicer;
	private Insets insets;

	private Rectangle2D northTextureAnchor;
	private Rectangle2D westTextureAnchor;
	private Rectangle2D southTextureAnchor;
	private Rectangle2D eastTextureAnchor;

	public NineSliceBorder(BufferedImage image) {
		slicer = new ImageSlicer(image);
		insets = new Insets(getSliceHeight(), getSliceWidth(), getSliceHeight(), getSliceWidth());
		initializeTextureAnchors();
	}

	private void initializeTextureAnchors() {
		northTextureAnchor = new Rectangle2D.Double();
		westTextureAnchor = new Rectangle2D.Double();
		southTextureAnchor = new Rectangle2D.Double();
		eastTextureAnchor = new Rectangle2D.Double();
	}

	@Override
	public void renderBorder(Graphics2D g2d, int x, int y, int width, int height) {
		setBorderFrame(x, y, width, height);
		setGraphicsContext(g2d);
		updateTextureAnchors();
		renderSlices();
	}

	private void updateTextureAnchors() {
		updateTextureAnchor(getNorthTextureAnchor(), getX() + getSliceWidth(), getY());
		updateTextureAnchor(getWestTextureAnchor(), getX(), getY() + getSliceHeight());
		updateTextureAnchor(getSouthTextureAnchor(), getX() + getSliceWidth(), getMaxY() - getSliceHeight());
		updateTextureAnchor(getEastTextureAnchor(), getMaxX() - getSliceWidth(), getY() + getSliceHeight());
	}

	private void updateTextureAnchor(Rectangle2D anchor, int x, int y) {
		anchor.setRect(x, y, getSliceWidth(), getSliceHeight());
	}

	private void renderSlices() {
		renderNorthWest();
		renderNorthEast();
		renderSouthWest();
		renderSouthEast();
		renderNorth();
		renderWest();
		renderSouth();
		renderEast();
	}

	private void renderSouthWest() {
		renderImage(getSouthWestSlice(), getX(), getMaxY() - getSliceHeight());
	}

	private void renderNorthWest() {
		renderImage(getNorthWestSlice(), getX(), getY());
	}

	private void renderNorthEast() {
		renderImage(getNorthEastSlice(), getMaxX() - getSliceWidth(), getY());
	}

	private void renderSouthEast() {
		renderImage(getSouthEastSlice(), getMaxX() - getSliceWidth(), getMaxY() - getSliceHeight());
	}

	private void renderNorth() {
		setTexture(getNorthSlice(), getNorthTextureAnchor());
		fillRect(getX() + getSliceWidth(), getY(), getInnerWidth(), getSliceHeight());
	}

	private void renderWest() {
		setTexture(getWestSlice(), getWestTextureAnchor());
		fillRect(getX(), getY() + getSliceHeight(), getSliceWidth(), getInnerHeight());
	}

	private void renderSouth() {
		setTexture(getSouthSlice(), getSouthTextureAnchor());
		fillRect(getX() + getSliceWidth(), getMaxY() - getSliceHeight(), getInnerWidth(), getSliceHeight());
	}

	private void renderEast() {
		setTexture(getEastSlice(), getEastTextureAnchor());
		fillRect(getMaxX() - getSliceWidth(), getY() + getSliceHeight(), getSliceWidth(), getInnerHeight());
	}

	private void fillRect(int x, int y, int width, int height) {
		g2d.fillRect(x, y, width, height);
	}

	private void renderImage(Image image, int x, int y) {
		g2d.drawImage(image, x, y, null);
	}

	private void setTexture(BufferedImage txtr, Rectangle2D anchor) {
		g2d.setPaint(new TexturePaint(txtr, anchor));
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

	private BufferedImage getNorthWestSlice() {
		return slicer.getSliceAt(0);
	}

	private BufferedImage getNorthSlice() {
		return slicer.getSliceAt(1);
	}

	private BufferedImage getNorthEastSlice() {
		return slicer.getSliceAt(2);
	}

	private BufferedImage getWestSlice() {
		return slicer.getSliceAt(3);
	}

	private BufferedImage getEastSlice() {
		return slicer.getSliceAt(5);
	}

	private BufferedImage getSouthWestSlice() {
		return slicer.getSliceAt(6);
	}

	private BufferedImage getSouthSlice() {
		return slicer.getSliceAt(7);
	}

	private BufferedImage getSouthEastSlice() {
		return slicer.getSliceAt(8);
	}

	private int getX() {
		return x;
	}

	private int getY() {
		return y;
	}

	private int getWidth() {
		return width;
	}

	private int getHeight() {
		return height;
	}

	private int getSliceWidth() {
		return slicer.getSliceWidth();
	}

	private int getSliceHeight() {
		return slicer.getSliceHeight();
	}

	private int getMaxX() {
		return x + width;
	}

	private int getMaxY() {
		return y + height;
	}

	private int getInnerWidth() {
		return getWidth() - getSliceWidth() - getSliceWidth();
	}

	private int getInnerHeight() {
		return getHeight() - getSliceHeight() - getSliceHeight();
	}

	@Override
	public Insets getInsets() {
		return insets;
	}

	public Rectangle2D getNorthTextureAnchor() {
		return northTextureAnchor;
	}

	public Rectangle2D getWestTextureAnchor() {
		return westTextureAnchor;
	}

	public Rectangle2D getSouthTextureAnchor() {
		return southTextureAnchor;
	}

	public Rectangle2D getEastTextureAnchor() {
		return eastTextureAnchor;
	}

	private class ImageSlicer {

		private int sliceWidth;
		private int sliceHeight;
		private BufferedImage image;
		private BufferedImage[] slices;

		public ImageSlicer(BufferedImage image) {
			this.image = image;
			slices = new BufferedImage[9];
			sliceWidth = image.getWidth() / 3;
			sliceHeight = image.getHeight() / 3;
			sliceImage();
		}

		private void sliceImage() {
			int sliceIndex = 0;

			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					int x = getSliceWidth() * col;
					int y = getSliceHeight() * row;
					BufferedImage slice = image.getSubimage(x, y, getSliceWidth(), getSliceHeight());
					slices[sliceIndex] = slice;
					sliceIndex++;
				}
			}
		}

		public BufferedImage getSliceAt(int index) {
			return slices[index];
		}

		public int getSliceWidth() {
			return sliceWidth;
		}

		public int getSliceHeight() {
			return sliceHeight;
		}

	}

}
