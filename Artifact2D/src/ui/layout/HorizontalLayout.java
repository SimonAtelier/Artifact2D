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
		setLayoutX(getLayoutX() + getNeededWidthOfChild());
	}

	private void updateMinimumWidth() {
		expandMinimumWidth(getNeededWidthOfChild());
	}

	private void updateMinimumHeight() {
		int childHeight = getNeededHeightOfChild();
		int minimumHeight = childHeight > getMinimumHeight() ? childHeight : getMinimumHeight();
		setMinimumHeight(minimumHeight);
	}

}
