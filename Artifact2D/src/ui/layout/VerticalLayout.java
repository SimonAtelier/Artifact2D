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
		setLayoutY(getLayoutY() + getNeededHeightOfChild());
	}

	private void updateMinimumWidth() {
		int childWidth = getNeededWidthOfChild();
		int minimumWidth = childWidth > getMinimumWidth() ? childWidth : getMinimumWidth();
		setMinimumWidth(minimumWidth);
	}

	private void updateMinimumHeight() {
		expandMinimumHeightBy(getNeededHeightOfChild());
	}

}
