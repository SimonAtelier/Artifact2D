package ui.layout;

public class VerticalLayout extends AbstractAxisLayout {

	@Override
	protected void updateLayoutCoordinates() {
		updateLayoutY();
	}

	@Override
	protected void updateMinimumDimension() {
		updateMinimumWidth();
		updateMinimumHeight();
	}

	private void updateLayoutY() {
		setLayoutY(getLayoutY() + getChildHeight());
	}

	private void updateMinimumWidth() {
		int childWidth = getChildWidth();
		int minimumWidth = childWidth > getMinimumWidth() ? childWidth : getMinimumWidth();
		setMinimumWidth(minimumWidth);
	}

	private void updateMinimumHeight() {
		expandMinimumHeight(getChildHeight());
	}

}
