package ui.layout;

import ui.UiElement;

public class LayoutCrop {

	public void crop(UiElement uiElement) {
		if (uiElement.isRoot())
			return;
		
		UiElement parent = uiElement.getParent();
		
		int parentWidth = parent.getWidth();
		parentWidth -= parent.getInsets().left;
		parentWidth -= parent.getInsets().right;
		
		int parentHeight = parent.getHeight();
		parentHeight -= parent.getInsets().top;
		parentHeight -= parent.getInsets().bottom;
		
		int width = uiElement.getWidth();
		width += uiElement.getMargin().left;
		width += uiElement.getMargin().right;
		
		int height = uiElement.getHeight();
		height += uiElement.getMargin().top;
		height += uiElement.getMargin().bottom;
		
		if (height > parentHeight) {
			int croppedHeight = parentHeight;
			croppedHeight -= uiElement.getMargin().top;
			croppedHeight -= uiElement.getMargin().bottom;
			uiElement.setHeight(croppedHeight);
		}
		
		if (width > parentWidth) {
			int croppedWidth = parentWidth;
			croppedWidth -= uiElement.getMargin().left;
			croppedWidth -= uiElement.getMargin().right;
			uiElement.setWidth(croppedWidth);
		}
		
	}
	
}
