package ui.layout;

public class HorizontalLayout extends AbstractAxisLayout {

	@Override
	protected void updateLayoutCoordinates() {
		updateLayoutX();
	}

	@Override
	protected void updateMinimumDimension() {
		updateMinimumWidth();
		updateMinimumHeight();
	}

	private void updateLayoutX() {
		setLayoutX(getLayoutX() + getChildWidth());
	}

	private void updateMinimumWidth() {
		expandMinimumWidth(getChildWidth());
	}

	private void updateMinimumHeight() {
		int childHeight = getChildHeight();
		int minimumHeight = childHeight > getMinimumHeight() ? childHeight : getMinimumHeight();
		setMinimumHeight(minimumHeight);
	}

}
