package ui.layout;

import ui.UiElement;
import ui.border.Insets;

public class GridLayout implements Layout {

	private int horizontalGap;
	private int verticalGap;
	private int rows;
	private int cols;
	private Insets insets;
	private UiElement uiElement;
	
	public GridLayout(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}
	
	public GridLayout(int rows, int cols, int horiontalGap, int verticalGap) {
		this.rows = rows;
		this.cols = cols;
		this.horizontalGap = horiontalGap;
		this.verticalGap = verticalGap;
	}

	@Override
	public void layout(UiElement uiElement) {
		if (uiElement == null)
			return;

		if (uiElement.getChildCount() == 0)
			return;

		setUiElement(uiElement);
		setInsetsFromUiElement();
		layoutChildren();
		pack();
	}

	private void layoutChildren() {
		int vGap = 0;
		int hGap = 0;
		int x = 0;
		int y = 0;
		int width = calculateChildWidth();
		int height = calculateChildHeight();
		int childIndex = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (childIndex >= uiElement.getChildCount())
					break;
				UiElement child = uiElement.getChildAt(childIndex);
				x = (width * col) + getInnerX() + hGap;
				y = (height * row) + getInnerY() + vGap;
				child.setX(x);
				child.setY(y);
				child.setWidth(width);
				child.setHeight(height);
				childIndex++;
				hGap += horizontalGap;
			}
			hGap = 0;
			vGap += verticalGap;
		}
	}

	private void pack() {
		packHorizontal();
		packVertical();
	}

	private void packHorizontal() {
		int width = 0;
		width += insets.left;
		width += insets.right;
		width += cols * calculateChildWidth();
		width += (cols - 1) * horizontalGap;
		uiElement.setWidth(width);
	}

	private void packVertical() {
		int height = 0;
		height += insets.top;
		height += insets.bottom;
		height += rows * calculateChildHeight();
		height += (rows - 1) * verticalGap;
		uiElement.setHeight(height);
	}

	private int calculateChildWidth() {
		return (uiElement.getInnerWidth() - ((cols - 1) * horizontalGap)) / cols;
	}

	private int calculateChildHeight() {
		return (uiElement.getInnerHeight() - ((rows - 1) * verticalGap)) / rows;
	}

	private void setInsetsFromUiElement() {
		insets = uiElement.getInsets();
	}

	private void setUiElement(UiElement uiElement) {
		this.uiElement = uiElement;
	}

	private int getInnerX() {
		return uiElement.getX() + insets.left;
	}

	private int getInnerY() {
		return uiElement.getY() + insets.top;
	}

	public int getHorizontalGap() {
		return horizontalGap;
	}

	public void setHorizontalGap(int horizontalGap) {
		this.horizontalGap = horizontalGap;
	}

	public int getVerticalGap() {
		return verticalGap;
	}

	public void setVerticalGap(int verticalGap) {
		this.verticalGap = verticalGap;
	}

}
