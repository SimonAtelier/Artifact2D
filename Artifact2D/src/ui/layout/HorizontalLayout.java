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
		translateLayoutX(getNeededWidthOfChild());
	}

	private void updateMinimumWidth() {
		expandMinimumWidthBy(getNeededWidthOfChild());
	}

	private void updateMinimumHeight() {
		int childHeight = getNeededHeightOfChild();
		int minimumHeight = childHeight > getMinimumHeight() ? childHeight : getMinimumHeight();
		setMinimumHeight(minimumHeight);
	}

}
