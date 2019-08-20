package ui.border;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DashedBorder implements Border {

	private float offset;
	private Color color;

	public DashedBorder(Color color) {
		this.color = color;
	}

	@Override
	public void renderBorder(Graphics2D g2d, int x, int y, int width, int height) {
		Stroke tmpStroke = g2d.getStroke();
		Stroke dashedStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f,
				new float[] {2.0f}, offset);
		g2d.setColor(color);
		g2d.setStroke(dashedStroke);
		g2d.drawRect(x, y, width - 1, height - 1);
		g2d.setStroke(tmpStroke);
	}
	
	public float getOffset() {
		return offset;
	}

	public void setOffset(float offset) {
		this.offset = offset;
	}

	@Override
	public Insets getInsets() {
		return new Insets(1, 1, 1, 1);
	}

}
