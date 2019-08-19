package ui.layout;

import ui.UiElement;
import ui.border.Insets;

public class HorizontalBoxLayout implements Layout {

	private int childCount;
	private int childWidth;
	private int gap;
	private Insets insets;
	private UiElement uiElement;

	public HorizontalBoxLayout(int gap) {
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
		setChildWidth(calculateChildWidth());
		layoutChildren();
		pack();
	}
		
	private void layoutChildren() {
		int x = getInnerX();
		for (int i = 0; i < childCount; i++) {
			UiElement child = uiElement.getChildAt(i);
			child.setX(x);
			child.setY(getInnerY());
			child.setWidth(childWidth);
			child.setHeight(getInnerHeight());
			x += childWidth + gap;
		}
	}

	private void pack() {
		int width = 0;
		width += insets.left;
		width += insets.right;
		width += childCount * childWidth;
		width += (childCount - 1) * gap;
		uiElement.setWidth(width);
	}

	private int calculateChildWidth() {
		int childCount = uiElement.getChildCount();
		return (uiElement.getInnerWidth() - ((childCount - 1) * gap)) / childCount;
	}

	private void setChildWidth(int childHeight) {
		this.childWidth = childHeight;
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

	private int getInnerHeight() {
		return uiElement.getInnerHeight();
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

}
