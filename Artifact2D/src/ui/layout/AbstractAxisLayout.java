package ui.layout;

import ui.UiElement;

public abstract class AbstractAxisLayout implements Layout {

	private int layoutX;
	private int layoutY;
	private int minimumHeight;
	private int minimumWidth;
	private UiElement parent;
	private UiElement child;
	
	protected abstract void updateLayoutCoordinates();
	
	protected abstract void updateMinimumDimension();
	
	@Override
	public void layout(UiElement uiElement) {
		reset();
		setParent(uiElement);
		layoutChildren();
		applyLayoutDimensionToParent();
	}
	
	private void layoutChildren() {
		for (int i = 0; i < getParent().getChildCount(); i++) {
			setChild(getParent().getChildAt(i));
			applyLayoutCoordinates();
			updateLayoutCoordinates();
			updateMinimumDimension();
		}
	}

	private void reset() {
		setMinimumWidth(0);
		setMinimumHeight(0);
		setLayoutX(0);
		setLayoutY(0);
	}
	
	protected void expandMinimumWidthBy(int amount) {
		minimumWidth += amount;
	}
	
	protected void expandMinimumHeightBy(int amount) {
		minimumHeight += amount;
	}
	
	private int calculateLayoutWidth() {
		return needToApplyLayoutWidth() ? getMinimumWidth() - getParentWidth() : 0;
	}
	
	private int calculateLayoutHeight() {
		return needToApplyLayoutHeight() ? getMinimumHeight() - getParentHeight() : 0;
	}
	
	private boolean needToApplyLayoutWidth() {
		return getMinimumWidth() > getParentWidth();
	}
	
	private boolean needToApplyLayoutHeight() {
		return getMinimumHeight() > getParentHeight();
	}
	
	private void applyLayoutDimensionToParent() {
		setParentLayoutWidth(calculateLayoutWidth());
		setParentLayoutHeight(calculateLayoutHeight());
	}
	
	private void applyLayoutCoordinates() {
		applyLayoutXToChild();
		applyLayoutYToChild();
	}
	
	private void applyLayoutXToChild() {
		getChild().setLayoutX(layoutX);
	}
	
	private void applyLayoutYToChild() {
		getChild().setLayoutY(layoutY);
	}
	
	private UiElement getParent() {
		return parent;
	}
	
	private UiElement getChild() {
		return child;
	}
	
	protected int getMinimumHeight() {
		return minimumHeight;
	}

	protected void setMinimumHeight(int minimumHeight) {
		this.minimumHeight = minimumHeight;
	}

	protected int getMinimumWidth() {
		return minimumWidth;
	}

	protected void setMinimumWidth(int minimumWidth) {
		this.minimumWidth = minimumWidth;
	}
		
	private void setParentLayoutWidth(int layoutWidth) {
		parent.setLayoutWidth(layoutWidth);
	}
	
	private void setParentLayoutHeight(int layoutHeight) {
		parent.setLayoutHeight(layoutHeight);
	}
	
	private int getParentWidth() {
		return parent.getWidth();
	}
	
	private int getParentHeight() {
		return parent.getHeight();
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
	
	private void setParent(UiElement uiElement) {
		this.parent = uiElement;
	}
	
	private void setChild(UiElement child) {
		this.child = child;
	}

	protected int getLayoutX() {
		return layoutX;
	}

	protected void setLayoutX(int layoutX) {
		this.layoutX = layoutX;
	}

	protected int getLayoutY() {
		return layoutY;
	}

	protected void setLayoutY(int layoutY) {
		this.layoutY = layoutY;
	}
	
}
