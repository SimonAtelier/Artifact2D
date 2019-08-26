package ui.layout;

import ui.UiElement;

public class HorizontalLayout implements Layout {

	private GridLayout gridLayout;
	
	public HorizontalLayout() {
		gridLayout = new GridLayout(0, 0);
	}
	
	@Override
	public void layout(UiElement uiElement) {
		gridLayout.setRows(1);
		gridLayout.setCols(uiElement.getChildCount());
		gridLayout.layout(uiElement);
	}

}
