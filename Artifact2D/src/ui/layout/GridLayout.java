package ui.layout;

import ui.UiElement;

public class GridLayout implements Layout {

	private int rows;
	private int cols;
	private int layoutY;
	private int layoutX;
	private int minimumHeight;
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
			translateLayoutY(getMaxRowHeight());
			expandMinimumHeight(getMaxRowHeight());
			updateMaxRowWidth();
			setMaxRowHeight(0);
			setLayoutX(0);
		}
	}
	
	private void expandMinimumHeight(int amount) {
		minimumHeight += amount;
	}
	
	private void updateMaxRowWidth() {
		maxRowWidth = getLayoutX() > maxRowWidth ? getLayoutX() : maxRowWidth;
	}
	
	private void updateMaxRowHeight() {
		maxRowHeight = getNeededHeightOfChild() > maxRowHeight ? getNeededHeightOfChild() : maxRowHeight;
	}
	
	private void reset() {
		maxRowWidth = maxRowHeight = layoutY = layoutX = minimumHeight = 0;
	}

	private void translateLayoutX(int amount) {
		layoutX += amount;
	}

	private void translateLayoutY(int amount) {
		layoutY += amount;
	}

	private void applyLayoutCoordinatesToChild() {
		child.setLayoutX(getLayoutX());
		child.setLayoutY(getLayoutY());
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
		int layoutHeight = minimumHeight > parent.getHeight() ? minimumHeight - parent.getHeight() : 0;
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
	
	private int getLayoutY() {
		return layoutY;
	}
	
	private int getLayoutX() {
		return layoutX;
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
	
	private int getMaxRowHeight() {
		return maxRowHeight;
	}
	
	private void setMaxRowHeight(int maxRowHeight) {
		this.maxRowHeight = maxRowHeight;
	}

	protected int getRows() {
		return rows;
	}

	protected void setRows(int rows) {
		this.rows = rows;
	}

	protected int getCols() {
		return cols;
	}

	protected void setCols(int cols) {
		this.cols = cols;
	}

}
