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
	private UiElement child;

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
		setParent(uiElement);
		layoutChildren();
		applyLayoutDimensionToParent();
	}
	
	private void layoutChildren() {
		int childIndex = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (childIndex >= parent.getChildCount())
					break;
				UiElement child = parent.getChildAt(childIndex);
				setChild(child);
				applyLayoutCoordinatesToChild();
				childIndex++;
				int childWidth = getNeededChildWidth();
				int childHeight = getNeededChildHeight();
				translateLayoutX(childWidth);
				maxRowHeight = childHeight > maxRowHeight ? childHeight : maxRowHeight;
			}
			maxRowWidth = layoutX > maxRowWidth ? layoutX : maxRowWidth;
			layoutX = 0;
			translateLayoutY(maxRowHeight);
		}
	}
	
	private void translateLayoutX(int amount) {
		layoutX += amount;
	}
	
	private void translateLayoutY(int amount) {
		layoutY += amount;
	}
	
	private void applyLayoutCoordinatesToChild() {
		child.setLayoutX(layoutX);
		child.setLayoutY(layoutY);
	}
	
	private int getNeededChildWidth() {
		return child.getBorderBoxWidth() + child.getMargin().getHorizontalInsets();
	}
	
	private int getNeededChildHeight() {
		return child.getBorderBoxHeight() + child.getMargin().getVerticalInsets();
	}

	private void applyLayoutDimensionToParent() {
		applyLayoutWidth();
		applyLayoutHeight();
	}
	
	private void applyLayoutWidth() {
		int layoutWidth = maxRowWidth > parent.getWidth() ? maxRowWidth - parent.getWidth() : 0;
		parent.setLayoutWidth(layoutWidth);
	}
	
	private void applyLayoutHeight() {
		int layoutHeight = layoutY > parent.getHeight() ? layoutY - parent.getHeight() : 0;
		parent.setLayoutHeight(layoutHeight);
	}

	private void setParent(UiElement parent) {
		this.parent = parent;
	}
	
	private void setChild(UiElement child) {
		this.child = child;
	}

}
