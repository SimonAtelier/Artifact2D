package ui.border;

import java.awt.Graphics2D;

public interface Border {

	void renderBorder(Graphics2D g2d, int x, int y, int width, int height);
	
	Insets getInsets();
	
}
