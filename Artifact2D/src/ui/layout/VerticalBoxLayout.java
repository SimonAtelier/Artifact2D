package ui.layout;

import ui.UiElement;
import ui.border.Insets;

public class VerticalBoxLayout implements Layout {

	private int childCount;
	private int childHeight;
	private int gap;
	private Insets insets;
	private UiElement uiElement;

	public VerticalBoxLayout(int gap) {
		this.gap = gap;
	}

	@Override
	public void layout(UiElement uiElement) {
		if (uiElement == null)
			return;

		if (uiElement.getChildCount() == 0)
			return;

		setUiElement(uiElement);
		setInsetsFromUiElement();
		setChildCountFromUiElement();
		setChildHeight(calculateChildHeight());
		layoutChildren();
		pack();
	}
		
	private void layoutChildren() {
		int y = getInnerY();
		for (int i = 0; i < childCount; i++) {
			UiElement child = uiElement.getChildAt(i);
			child.setX(getInnerX());
			child.setY(y);
			child.setWidth(getInnerWidth());
			child.setHeight(childHeight);
			y += childHeight + gap;
		}
	}

	private void pack() {
		int height = 0;
		height += insets.top;
		height += insets.bottom;
		height += childCount * childHeight;
		height += (childCount - 1) * gap;
		uiElement.setHeight(height);
	}

	private int calculateChildHeight() {
		int childCount = uiElement.getChildCount();
		return (uiElement.getInnerHeight() - ((childCount - 1) * gap)) / childCount;
	}

	private void setChildHeight(int childHeight) {
		this.childHeight = childHeight;
	}

	private void setInsetsFromUiElement() {
		insets = uiElement.getInsets();
	}

	private void setUiElement(UiElement uiElement) {
		this.uiElement = uiElement;
	}

	private void setChildCountFromUiElement() {
		childCount = uiElement.getChildCount();
	}

	private int getInnerX() {
		return uiElement.getX() + insets.left;
	}

	private int getInnerY() {
		return uiElement.getY() + insets.top;
	}

	private int getInnerWidth() {
		return uiElement.getInnerWidth();
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

}
