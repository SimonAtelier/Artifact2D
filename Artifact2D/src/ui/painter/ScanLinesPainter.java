package ui.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class ScanLinesPainter implements Painter {

	private int alpha;
	private int lineSize;
	private float offsetY;
	private BufferedImage texture;

	public ScanLinesPainter() {
		this(2, 60);
	}
	
	public ScanLinesPainter(int lineSize, int alpha) {
		this.lineSize = lineSize;
		this.alpha = alpha;
		createTexture();
	}

	private void createTexture() {
		texture = new BufferedImage(lineSize * 2, lineSize * 2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) texture.getGraphics();
		g2d.setColor(new Color(255, 255, 255, alpha));
		for (int i = 0; i < texture.getHeight() / lineSize; i++) {
			if (i % 2 == 0) {
				g2d.fillRect(0, i * lineSize, texture.getWidth(), lineSize);
			}
		}
	}

	@Override
	public void paint(Graphics2D g2d, int x, int y, int width, int height) {
		TexturePaint texturePaint = new TexturePaint(texture,
				new Rectangle2D.Double(x, y + offsetY, texture.getWidth(), texture.getHeight()));
		g2d.setPaint(texturePaint);
		g2d.fillRect(x, y, width, height);
	}
	
	private void clampAlpha() {
		alpha = alpha < 0 ? 0 : alpha;
		alpha = alpha > 255 ? 255 : alpha;
	}

	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
		createTexture();
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
		clampAlpha();
		createTexture();
	}
	
	public void setOffsetY(float offsetY) {
		this.offsetY = offsetY;
	}

}