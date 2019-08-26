package ui.layout;

import ui.UiElement;

public class GridLayout implements Layout {

	private int rows;
	private int cols;
	private int layoutY;
	private int layoutX;
	private int maxRowWidth;
	private int maxRowHeight;
	private UiElement parent;

	public GridLayout(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	private void reset() {
		maxRowWidth = maxRowHeight = layoutY = layoutX = 0;
	}

	@Override
	public void layout(UiElement uiElement) {
		reset();
		setUiElement(uiElement);
		
		int childIndex = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (childIndex >= uiElement.getChildCount())
					break;
				UiElement child = uiElement.getChildAt(childIndex);
				child.setLayoutX(layoutX);
				child.setLayoutY(layoutY);
				childIndex++;
				int childWidth = child.getBorderBoxWidth() + child.getMargin().getHorizontalInsets();
				int childHeight = child.getBorderBoxHeight() + child.getMargin().getVerticalInsets();
				layoutX += childWidth;
				maxRowHeight = childHeight > maxRowHeight ? childHeight : maxRowHeight;
			}
			maxRowWidth = layoutX > maxRowWidth ? layoutX : maxRowWidth;
			layoutX = 0;
			layoutY += maxRowHeight;
		}

		if (maxRowWidth > uiElement.getWidth()) {
			uiElement.setLayoutWidth(maxRowWidth - uiElement.getWidth());
		} else {
			uiElement.setLayoutWidth(0);
		}

		if (layoutY > uiElement.getHeight()) {
			uiElement.setLayoutHeight(layoutY - uiElement.getHeight());
		} else {
			uiElement.setLayoutHeight(0);
		}

	}
	
	private void setUiElement(UiElement parent) {
		this.parent = parent;
	}

}
