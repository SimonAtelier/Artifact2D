package ui.test;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Test;

import ui.Panel;
import ui.border.BorderFactory;

public class CropTest {

	@Test
	public void testCrop() {
		int border = 2;
		int margin = 10;
		
		Panel panel0 = new Panel();
		panel0.setWidth(200);
		panel0.setHeight(300);
		panel0.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		Panel panel1 = new Panel();
		panel1.setWidth(400);
		panel1.setHeight(400);
		panel1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panel1.setMargin(margin);
		panel0.add(panel1);
		
		int width = 200 - margin - margin - border;
		int height = 300 - margin - margin - border;
		
		Assert.assertEquals(width, panel1.getWidth());
		Assert.assertEquals(height, panel1.getHeight());
	}
	
}
