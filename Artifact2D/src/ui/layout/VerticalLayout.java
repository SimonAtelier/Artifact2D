package ui.layout;

import ui.UiElement;

public class VerticalLayout implements Layout {

	private int layoutY;
	private int minimumHeight;
	private int minimumWidth;
	private UiElement parent;
	private UiElement child;

	@Override
	public void layout(UiElement uiElement) {
		reset();
		setParent(uiElement);
		layoutChildren();
		applyLayoutDimensionToParent();
	}

	private void layoutChildren() {
		for (int i = 0; i < parent.getChildCount(); i++) {
			setChild(parent.getChildAt(i));
			applyLayoutYToChild();
			updateLayoutY();
			updateMinimumDimension();
		}
	}
	
	private void updateMinimumDimension() {
		updateMinimumWidth();
		updateMinimumHeight();
	}
	
	private void reset() {
		layoutY = minimumHeight = minimumWidth = 0;
	}
	
	private void updateLayoutY() {
		layoutY += getChildHeight();
	}
	
	private void updateMinimumWidth() {
		int childWidth = getChildWidth();
		minimumWidth = childWidth > minimumWidth ? childWidth : minimumWidth;
	}
	
	private void updateMinimumHeight() {
		int childHeight = getChildHeight();
		minimumHeight += childHeight;
	}
	
	private void applyLayoutDimensionToParent() {
		setParentLayoutWidth(calculateLayoutWidth());
		setParentLayoutHeight(calculateLayoutHeight());
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
	
	private void applyLayoutYToChild() {
		child.setLayoutY(layoutY);
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
	
	private int getChildWidth() {
		return child.getBorderBoxWidth() + child.getMargin().getHorizontalInsets();
	}
	
	private int getChildHeight() {
		return child.getBorderBoxHeight() + child.getMargin().getVerticalInsets();
	}
	
	private void setParent(UiElement uiElement) {
		this.parent = uiElement;
	}
	
	private void setChild(UiElement child) {
		this.child = child;
	}
	
	private int getMinimumWidth() {
		return minimumWidth;
	}
	
	private int getMinimumHeight() {
		return minimumHeight;
	}

}
