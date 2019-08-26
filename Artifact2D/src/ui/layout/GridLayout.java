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
		for (int row = 0; row < getRows(); row++) {
			for (int col = 0; col < getCols(); col++) {
				if (childIndex >= getChildCount())
					break;
				setChild(getParent().getChildAt(childIndex));
				updateCol();
				childIndex++;
			}
			updateRow();
		}
	}

	private void updateCol() {
		applyLayoutCoordinatesToChild();
		translateLayoutX(getNeededWidthOfChild());
		updateMaxRowHeight();
	}

	private void updateRow() {
		translateLayoutY(getMaxRowHeight());
		expandMinimumHeight(getMaxRowHeight());
		updateMaxRowWidth();
		setMaxRowHeight(0);
		setLayoutX(0);
	}

	private void expandMinimumHeight(int amount) {
		minimumHeight += amount;
	}

	private void updateMaxRowWidth() {
		if (needToUpdateMaxRowWidth())
			setMaxRowWidth(getLayoutX());
	}

	private void updateMaxRowHeight() {
		if (needToUpdateMaxRowHeight())
			setMaxRowHeight(getNeededHeightOfChild());
	}

	private void reset() {
		maxRowWidth = maxRowHeight = minimumHeight = layoutX = layoutY = 0;
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
		setParentLayoutWidth(needToApplyLayoutWidth() ? calculateLayoutWidth() : 0);
	}

	private void applyLayoutHeight() {
		setParentLayoutHeight(needToApplyLayoutHeight() ? calculateLayoutHeight() : 0);
	}

	private boolean needToApplyLayoutWidth() {
		return getMaxRowWidth() > getParentWidth();
	}

	private boolean needToApplyLayoutHeight() {
		return getMinimumHeight() > getParentHeight();
	}

	private boolean needToUpdateMaxRowWidth() {
		return getLayoutX() > getMaxRowWidth();
	}

	private boolean needToUpdateMaxRowHeight() {
		return getNeededHeightOfChild() > getMaxRowHeight();
	}

	private int calculateLayoutWidth() {
		return getMaxRowWidth() - getParentWidth();
	}

	private int calculateLayoutHeight() {
		return getMinimumHeight() - getParentHeight();
	}

	private int getNeededWidthOfChild() {
		return getChildBorderBoxWidth() + getHorizontalChildMargin();
	}

	private int getNeededHeightOfChild() {
		return getChildBorderBoxHeight() + getVerticalChildMargin();
	}

	private void setParentLayoutWidth(int layoutWidth) {
		getParent().setLayoutWidth(layoutWidth);
	}

	private void setParentLayoutHeight(int layoutHeight) {
		getParent().setLayoutHeight(layoutHeight);
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

	private int getParentWidth() {
		return getParent().getWidth();
	}

	private int getParentHeight() {
		return getParent().getHeight();
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

	private int getMaxRowWidth() {
		return maxRowWidth;
	}

	private void setMaxRowWidth(int maxRowWidth) {
		this.maxRowWidth = maxRowWidth;
	}

	private int getMinimumHeight() {
		return minimumHeight;
	}

	private int getChildCount() {
		return getParent().getChildCount();
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
