package ui.layout;

import ui.UiElement;

public class LayoutMargin {

	private UiElement uiElement;
	private Anchor anchor;

	public void applyMargin(UiElement uiElement) {
		setUiElement(uiElement);
		setAnchor(uiElement.getAnchor());
		applyMarginByAnchor();
	}

	private void applyMarginByAnchor() {
		switch (anchor) {
		case TOP_LEFT:
			applyMarginTopLeft();
			break;
		case TOP_RIGHT:
			applyMarginTopRight();
			break;
		case BOTTOM_RIGHT:
			applyMarginBottomRight();
			break;
		case BOTTOM_LEFT:
			applyMarginBottomLeft();
			break;
		case CENTER_LEFT:
			applyMarginCenterLeft();
			break;
		case CENTER_TOP:
			applyMarginCenterTop();
			break;
		case CENTER_RIGHT:
			applyMarginCenterRight();
			break;
		case CENTER_BOTTOM:
			applyMarginCenterBottom();
			break;
		case CENTER:
			// TODO
			break;
		case LEFT_WIDE:
			applyMarginLeftWide();
			break;
		case TOP_WIDE:
			applyMarginTopWide();
			break;
		case RIGHT_WIDE:
			applyMarginRightWide();
			break;
		case BOTTOM_WIDE:
			applyMarginBottomWide();
			break;
		case VERTICAL_CENTER_WIDE:
			applyMarginVerticalCenterWide();
			break;
		case HORIZONTAL_CENTER_WIDE:
			applyMarginHorizontalCenterWide();
			break;
		case FULL_RECTANGLE:
			applyMarginFullRectangle();
			break;
		default:
			break;
		}
	}

	private void applyMarginTopLeft() {
		setX(getX() + getMarginLeft());
		setY(getY() + getMarginTop());
	}

	private void applyMarginTopRight() {
		setX(getX() - getMarginRight());
		setY(getY() + getMarginTop());
	}

	private void applyMarginBottomRight() {
		setX(getX() - getMarginRight());
		setY(getY() - getMarginBottom());
	}

	private void applyMarginBottomLeft() {
		setX(getX() + getMarginLeft());
		setY(getY() - getMarginBottom());
	}

	private void applyMarginCenterLeft() {
		setX(getX() + getMarginLeft());
	}

	private void applyMarginTopWide() {
		setX(getX() + getMarginLeft());
		setY(getY() + getMarginTop());
		setWidth(getWidth() - getMarginLeft() - getMarginRight());
	}

	private void applyMarginCenterTop() {
		setY(getY() + getMarginTop());
	}

	private void applyMarginBottomWide() {
		setX(getX() + getMarginLeft());
		setY(getY() - getMarginBottom());
		setWidth(getWidth() - getMarginLeft() - getMarginRight());
	}

	private void applyMarginVerticalCenterWide() {
		setY(getY() + getMarginTop());
		setHeight(getHeight() - getMarginTop() - getMarginBottom());
	}

	private void applyMarginCenterRight() {
		setX(getX() - getMarginRight());
	}

	private void applyMarginHorizontalCenterWide() {
		setX(getX() + getMarginLeft());
		setWidth(getWidth() - getMarginLeft() - getMarginRight());
	}

	private void applyMarginCenterBottom() {
		setY(getY() - getMarginBottom());
	}

	private void applyMarginFullRectangle() {
		setX(getX() + getMarginLeft());
		setY(getY() + getMarginTop());
		setWidth(getWidth() - getMarginLeft() - getMarginRight());
		setHeight(getHeight() - getMarginTop() - getMarginBottom());
	}
	
	private void applyMarginLeftWide() {
		setX(getX() + getMarginLeft());
		setY(getY() + getMarginTop());
		setHeight(getHeight() - getMarginTop() - getMarginBottom());
	}
	
	private void applyMarginRightWide() {
		setX(getX() - getMarginRight());
		setY(getY() + getMarginTop());
		setHeight(getHeight() - getMarginTop() - getMarginBottom());
	}

	private void setUiElement(UiElement uiElement) {
		this.uiElement = uiElement;
	}

	private void setAnchor(Anchor anchor) {
		this.anchor = anchor;
	}

	private int getX() {
		return uiElement.getX();
	}

	private void setX(int x) {
		uiElement.setX(x);
	}

	private int getY() {
		return uiElement.getY();
	}

	private void setY(int y) {
		uiElement.setY(y);
	}

	private int getWidth() {
		return uiElement.getWidth();
	}

	private void setWidth(int width) {
		uiElement.setWidth(width);
	}

	private int getHeight() {
		return uiElement.getHeight();
	}

	private void setHeight(int height) {
		uiElement.setHeight(height);
	}

	private int getMarginTop() {
		return uiElement.getMargin().top;
	}

	private int getMarginLeft() {
		return uiElement.getMargin().left;
	}

	private int getMarginBottom() {
		return uiElement.getMargin().bottom;
	}

	private int getMarginRight() {
		return uiElement.getMargin().right;
	}

}
