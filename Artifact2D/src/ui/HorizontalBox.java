package ui;

import ui.layout.HorizontalBoxLayout;

public class HorizontalBox extends UiElement {
	
	private HorizontalBoxLayout layout;
	
	public HorizontalBox() {
		layout = new HorizontalBoxLayout(0);
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
