package ui;

import java.awt.Color;

import ui.border.Border;
import ui.border.BorderFactory;
import ui.layout.GridLayout;

public class Hotbar extends UiElement {

	private int slots;
	private int slotSize;
	private Border slotBorder;

	public Hotbar(int slots, int slotSize) {
		this.slots = slots;
		this.slotSize = slotSize;
		slotBorder = createDefaultSlotBorder();
		setBorder(BorderFactory.createRaisedEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY));
		setLayout(new GridLayout(1, slots));
		addSlots();
		updateDimension();
	}
	
	private void updateDimension() {
		setWidth(calculateWidth());
		setHeight(calculateHeight());
	}

	private int calculateWidth() {
		return slots * (slotSize + slotBorder.getInsets().left + slotBorder.getInsets().right) + getInsets().left
				+ getInsets().right;
	}

	private int calculateHeight() {
		return slotSize + slotBorder.getInsets().left + slotBorder.getInsets().right + getInsets().top
				+ getInsets().bottom;
	}

	private void addSlots() {
		for (int i = 0; i < slots; i++) {
			Panel slot = new Panel();
			slot.setWidth(slotSize);
			slot.setHeight(slotSize);
			slot.setBorder(slotBorder);
			add(slot);
		}
	}
	
	private Border createDefaultSlotBorder() {
		return BorderFactory.createLoweredEtchedBorder(Color.LIGHT_GRAY, Color.DARK_GRAY);
	}
	
	@Override
	public void setBorder(Border border) {
		super.setBorder(border);
		updateDimension();
	}

	public void setSlotBorder(Border slotBorder) {
		this.slotBorder = slotBorder;
		for (int i = 0; i < getChildCount(); i++) {
			UiElement slot = getChildAt(i);
			slot.setBorder(slotBorder);
		}
		updateDimension();
	}	
	
}
