package ui.layout;

import ui.UiElement;

public class VerticalLayout implements Layout {

	private GridLayout gridLayout;
	
	public VerticalLayout() {
		gridLayout = new GridLayout(0, 0);
	}
	
	@Override
	public void layout(UiElement uiElement) {
		gridLayout.setRows(uiElement.getChildCount());
		gridLayout.setCols(1);
		gridLayout.layout(uiElement);
	}

}
