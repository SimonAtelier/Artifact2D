package ui.layout;

import ui.UiElement;

public class GridLayout implements Layout {

	private int rows;
	private int cols;
	private int vGap;
	private int hGap;
	private int maxRowWidth;
	private int maxRowHeight;

	public GridLayout(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	private void reset() {
		maxRowWidth = maxRowHeight = vGap = hGap = 0;
	}

	@Override
	public void layout(UiElement uiElement) {
		reset();
		
		int childIndex = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (childIndex >= uiElement.getChildCount())
					break;
				UiElement child = uiElement.getChildAt(childIndex);
				child.setLayoutX(hGap);
				child.setLayoutY(vGap);
				childIndex++;
				int childWidth = child.getBorderBoxWidth() + child.getMargin().getHorizontalInsets();
				int childHeight = child.getBorderBoxHeight() + child.getMargin().getVerticalInsets();
				hGap += childWidth;
				maxRowHeight = childHeight > maxRowHeight ? childHeight : maxRowHeight;
			}
			maxRowWidth = hGap > maxRowWidth ? hGap : maxRowWidth;
			hGap = 0;
			vGap += maxRowHeight;
		}

		if (maxRowWidth > uiElement.getWidth()) {
			uiElement.setLayoutWidth(maxRowWidth - uiElement.getWidth());
		} else {
			uiElement.setLayoutWidth(0);
		}

		if (vGap > uiElement.getHeight()) {
			uiElement.setLayoutHeight(vGap - uiElement.getHeight());
		} else {
			uiElement.setLayoutHeight(0);
		}

	}

}
