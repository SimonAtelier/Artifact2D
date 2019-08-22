package ui.layout;

import ui.UiElement;
import ui.border.Insets;

public class LayoutAnchor {

	private UiElement uiElement;
	private UiElement parent;
	private Insets insets;
	private Anchor anchor;

	public LayoutAnchor(Anchor anchor) {
		this.anchor = anchor;
	}

	public void anchor(UiElement uiElement) {
		if (uiElement.isRoot())
			return;

		setUiElement(uiElement);
		setParent(uiElement.getParent());
		setInsetsFromParent();
		layoutByAnchor();
	}

	private void layoutByAnchor() {
		switch (anchor) {
		case TOP_LEFT:
			layoutTopLeft();
			break;
		case TOP_RIGHT:
			layoutTopRight();
			break;
		case BOTTOM_RIGHT:
			layoutBottomRight();
			break;
		case BOTTOM_LEFT:
			layoutBottomLeft();
			break;
		case CENTER_LEFT:
			layoutCenterLeft();
			break;
		case CENTER_TOP:
			layoutCenterTop();
			break;
		case CENTER_RIGHT:
			layoutCenterRight();
			break;
		case CENTER_BOTTOM:
			layoutCenterBottom();
			break;
		case CENTER:
			layoutCenter();
			break;
		case LEFT_WIDE:
			layoutLeftWide();
			break;
		case TOP_WIDE:
			layoutTopWide();
			break;
		case RIGHT_WIDE:
			layoutRightWide();
			break;
		case BOTTOM_WIDE:
			layoutBottomWide();
			break;
		case VERTICAL_CENTER_WIDE:
			layoutVerticalCenterWide();
			break;
		case HORIZONTAL_CENTER_WIDE:
			layoutHorizontalCenterWide();
			break;
		case FULL_RECTANGLE:
			layoutFullRectangle();
			break;
		default:
			break;
		}
	}
	
	private void setUiElement(UiElement uiElement) {
		this.uiElement = uiElement;
	}

	private void setParent(UiElement parent) {
		this.parent = parent;
	}
	
	private void setInsetsFromParent() {
		insets = parent.getInsets();
	}

	private void setToParentInnerCoordinates() {
		setToParentInnerX();
		setToParentInnerY();
	}

	private void setToParentInnerX() {
		uiElement.setX(parent.getInnerX());
	}

	private void setToParentInnerY() {
		uiElement.setY(parent.getInnerY());
	}

	private void setToParentInnerWidth() {
		uiElement.setWidth(parent.getInnerWidth());
	}

	private void setToParentInnerHeight() {
		uiElement.setHeight(parent.getInnerHeight());
	}

	private void centerVertical() {
		int offsetX = (parent.getInnerWidth() - uiElement.getWidth()) / 2;
		uiElement.setX(parent.getX() + insets.left + offsetX);
	}

	private void centerHorizontal() {
		int offsetY = (parent.getInnerHeight() - uiElement.getHeight()) / 2;
		uiElement.setY(parent.getY() + insets.top + offsetY);
	}

	private void anchorRight() {
		uiElement.setX(parent.getX() + parent.getWidth() - uiElement.getWidth() - insets.right);
	}

	private void anchorBottom() {
		uiElement.setY(parent.getY() + parent.getHeight() - uiElement.getHeight() - insets.bottom);
	}

	private void layoutTopLeft() {
		setToParentInnerCoordinates();
	}

	private void layoutTopRight() {
		anchorRight();
		setToParentInnerY();
	}

	private void layoutBottomRight() {
		anchorRight();
		anchorBottom();
	}

	private void layoutBottomLeft() {
		setToParentInnerX();
		anchorBottom();
	}

	private void layoutCenterLeft() {
		setToParentInnerX();
		centerHorizontal();
	}

	private void layoutCenterTop() {
		setToParentInnerY();
		centerVertical();
	}

	private void layoutCenterRight() {
		centerHorizontal();
		anchorRight();
	}

	private void layoutCenterBottom() {
		centerVertical();
		anchorBottom();
	}

	private void layoutCenter() {
		centerVertical();
		centerHorizontal();
	}

	private void layoutLeftWide() {
		setToParentInnerCoordinates();
		setToParentInnerHeight();
	}

	private void layoutTopWide() {
		setToParentInnerCoordinates();
		setToParentInnerWidth();
	}

	private void layoutRightWide() {
		anchorRight();
		setToParentInnerY();
		setToParentInnerHeight();
	}

	private void layoutBottomWide() {
		setToParentInnerX();
		anchorBottom();
		setToParentInnerWidth();
	}

	private void layoutVerticalCenterWide() {
		centerVertical();
		setToParentInnerY();
		setToParentInnerHeight();
	}

	private void layoutHorizontalCenterWide() {
		setToParentInnerX();
		setToParentInnerWidth();
		centerHorizontal();
	}

	private void layoutFullRectangle() {
		setToParentInnerCoordinates();
		setToParentInnerWidth();
		setToParentInnerHeight();
	}
	
	public Anchor getAnchor() {
		return anchor;
	}
	
	public void setAnchor(Anchor anchor) {
		this.anchor = anchor;
	}

}
