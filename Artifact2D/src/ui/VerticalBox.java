package ui;

import ui.layout.VerticalBoxLayout;

public class VerticalBox extends UiElement {
	
	private VerticalBoxLayout layout;
	
	public VerticalBox() {
		layout = new VerticalBoxLayout(0);
		setLayout(layout);
	}
	
	public int getGap() {
		return layout.getGap();
	}
	
	public void setGap(int gap) {
		layout.setGap(gap);
		layout();
	}

}
