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
				setChild(getParent().getChildAt(childIndex));
				applyLayoutCoordinatesToChild();
				translateLayoutX(getNeededWidthOfChild());
				updateMaxRowHeight();
				childIndex++;
			}
			updateMaxRowWidth();
			setLayoutX(0);
			translateLayoutY(maxRowHeight);
		}
	}
	
	private void updateMaxRowWidth() {
		maxRowWidth = layoutX > maxRowWidth ? layoutX : maxRowWidth;
	}
	
	private void updateMaxRowHeight() {
		maxRowHeight = getNeededHeightOfChild() > maxRowHeight ? getNeededHeightOfChild() : maxRowHeight;
	}
	
	private void reset() {
		maxRowWidth = maxRowHeight = layoutY = layoutX = 0;
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
	
	protected int getNeededWidthOfChild() {
		return getChildBorderBoxWidth() + getHorizontalChildMargin();
	}
	
	protected int getNeededHeightOfChild() {
		return getChildBorderBoxHeight() + getVerticalChildMargin();
	}
	
	private int getHorizontalChildMargin() {
		return child.getMargin().getHorizontalInsets();
	}
	
	private int getVerticalChildMargin() {
		return child.getMargin().getVerticalInsets();
	}
	
	private int getChildBorderBoxWidth() {
		return child.getBorderBoxWidth();
	}
	
	private int getChildBorderBoxHeight() {
		return child.getBorderBoxHeight();
	}
	
	private void setLayoutX(int layoutX) {
		this.layoutX = layoutX;
	}
	
	private UiElement getParent() {
		return parent;
	}

	private void setParent(UiElement parent) {
		this.parent = parent;
	}

	private void setChild(UiElement child) {
		this.child = child;
	}

}
