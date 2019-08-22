package ui.layout;

import ui.UiElement;

public class LayoutCrop {
	
	private UiElement uiElement;
	private UiElement parent;
	
	public void crop(UiElement uiElement) {
		if (uiElement.isRoot())
			return;
		
		setUiElement(uiElement);
		setParentFromElement();
		crop();
	}
	
	private void crop() {
		if (needToCropHeight())
			cropHeight();
		
		if (needToCropWidth())
			cropWidth();
	}
	
	private void cropWidth() {
		int croppedWidth = getParentInnerWidth();
		croppedWidth -= getLeftMargin();
		croppedWidth -= getRightMargin();
		uiElement.setWidth(croppedWidth);
	}
	
	private void cropHeight() {
		int croppedHeight = getParentInnerHeight();
		croppedHeight -= getTopMargin();
		croppedHeight -= getBottomMargin();
		uiElement.setHeight(croppedHeight);
	}
	
	private boolean needToCropHeight() {
		return calculateNeededHeight() > getParentInnerWidth();
	}
	
	private boolean needToCropWidth() {
		return calculateNeededWidth() > getParentInnerWidth();
	}
	
	private int calculateNeededWidth() {
		int neededWidth = uiElement.getWidth();
		neededWidth += getLeftMargin();
		neededWidth += getRightMargin();
		return neededWidth;
	}
	
	private int calculateNeededHeight() {
		int neededHeight = uiElement.getHeight();
		neededHeight += getTopMargin();
		neededHeight += getBottomMargin();
		return neededHeight;
	}
	
	private int getLeftMargin() {
		return uiElement.getMargin().left;
	}
	
	private int getRightMargin() {
		return uiElement.getMargin().right;
	}
	
	private int getTopMargin() {
		return uiElement.getMargin().top;
	}
	
	private int getBottomMargin() {
		return uiElement.getMargin().bottom;
	}
	
	private int getParentInnerWidth() {
		return parent.getInnerWidth();
	}
	
	private int getParentInnerHeight() {
		return parent.getInnerHeight();
	}
	
	private void setUiElement(UiElement uiElement) {
		this.uiElement = uiElement;
	}
	
	private void setParentFromElement() {
		parent = uiElement.getParent();
	}
	
}
