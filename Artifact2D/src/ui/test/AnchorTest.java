package ui.test;

import org.junit.Assert;
import org.junit.Test;

import ui.Panel;
import ui.layout.Anchor;

public class AnchorTest {

	@Test
	public void testTopLeftAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.TOP_LEFT);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 0);
	}
	
	@Test
	public void testTopRightAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.TOP_RIGHT);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 50);
		Assert.assertEquals(panel2.getY(), 0);
	}
	
	@Test
	public void testCenterTopAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.CENTER_TOP);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 25);
		Assert.assertEquals(panel2.getY(), 0);
	}
	
	@Test
	public void testCenterLeftAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.CENTER_LEFT);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 25);
	}
	
	@Test
	public void testCenterAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.CENTER);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 25);
		Assert.assertEquals(panel2.getY(), 25);
	}
	
	@Test
	public void testCenterRightAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.CENTER_RIGHT);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 50);
		Assert.assertEquals(panel2.getY(), 25);
	}
	
	@Test
	public void testBottomLeftAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.BOTTOM_LEFT);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 50);
	}
	
	@Test
	public void testCenterBottomAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.CENTER_BOTTOM);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 25);
		Assert.assertEquals(panel2.getY(), 50);
	}
	
	@Test
	public void testBottomRightAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.BOTTOM_RIGHT);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 50);
		Assert.assertEquals(panel2.getY(), 50);
	}
	
	@Test
	public void testFullRectangle() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.FULL_RECTANGLE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 0);
		Assert.assertEquals(panel2.getWidth(), 100);
		Assert.assertEquals(panel2.getHeight(), 100);
	}
	
	@Test
	public void testTopWideAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.TOP_WIDE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 0);
		Assert.assertEquals(panel2.getWidth(), 100);
		Assert.assertEquals(panel2.getHeight(), 50);
	}
	
	@Test
	public void testLeftWideAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.LEFT_WIDE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 0);
		Assert.assertEquals(panel2.getWidth(), 50);
		Assert.assertEquals(panel2.getHeight(), 100);
	}
	
	@Test
	public void testRightWideAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.RIGHT_WIDE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 50);
		Assert.assertEquals(panel2.getY(), 0);
		Assert.assertEquals(panel2.getWidth(), 50);
		Assert.assertEquals(panel2.getHeight(), 100);
	}
	
	@Test
	public void testVerticalCenterAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.VERTICAL_CENTER_WIDE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 25);
		Assert.assertEquals(panel2.getY(), 0);
		Assert.assertEquals(panel2.getWidth(), 50);
		Assert.assertEquals(panel2.getHeight(), 100);
	}
	
	@Test
	public void testHorizontalCenterWide() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.HORIZONTAL_CENTER_WIDE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 25);
		Assert.assertEquals(panel2.getWidth(), 100);
		Assert.assertEquals(panel2.getHeight(), 50);
	}
	
	@Test
	public void testBottomWideAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.BOTTOM_WIDE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 50);
		Assert.assertEquals(panel2.getWidth(), 100);
		Assert.assertEquals(panel2.getHeight(), 50);
	}
	
	@Test
	public void testNoneAnchor() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		
		Panel panel2 = new Panel();
		panel2.setWidth(50);
		panel2.setHeight(50);
		panel2.setLayoutAnchor(Anchor.NONE);
		panel.add(panel2);
		
		Assert.assertEquals(panel2.getX(), 0);
		Assert.assertEquals(panel2.getY(), 0);
		Assert.assertEquals(panel2.getWidth(), 50);
		Assert.assertEquals(panel2.getHeight(), 50);
	}
	
}
