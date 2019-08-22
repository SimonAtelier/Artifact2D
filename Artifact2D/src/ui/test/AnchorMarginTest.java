package ui.test;

import org.junit.Assert;
import org.junit.Test;

import ui.Panel;
import ui.layout.Anchor;

public class AnchorMarginTest {

	private Panel createOuterPanel() {
		Panel panel = new Panel();
		panel.setWidth(100);
		panel.setHeight(100);
		return panel;
	}
	
	private Panel createInnerPanel(Anchor anchor) {
		Panel panel = new Panel();
		panel.setWidth(50);
		panel.setHeight(50);
		panel.setLayoutAnchor(anchor);
		panel.setMargin(10);
		return panel;
	}
	
	@Test
	public void testTopLeftAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.TOP_LEFT);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 10);
	}
	
	@Test
	public void testTopRightAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.TOP_RIGHT);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		
		Assert.assertEquals(innerPanel.getX(), 40);
		Assert.assertEquals(innerPanel.getY(), 10);
	}
	
	@Test
	public void testCenterTopAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.CENTER_TOP);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 25);
		Assert.assertEquals(innerPanel.getY(), 10);
	}
	
	@Test
	public void testCenterLeftAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.CENTER_LEFT);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 25);
	}
	
	@Test
	public void testCenterAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.CENTER);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 25);
		Assert.assertEquals(innerPanel.getY(), 25);
	}
	
	@Test
	public void testCenterRightAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.CENTER_RIGHT);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 40);
		Assert.assertEquals(innerPanel.getY(), 25);
	}
	
	@Test
	public void testBottomLeftAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.BOTTOM_LEFT);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 40);
	}
	
	@Test
	public void testCenterBottomAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.CENTER_BOTTOM);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 25);
		Assert.assertEquals(innerPanel.getY(), 40);
	}
	
	@Test
	public void testBottomRightAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.BOTTOM_RIGHT);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 40);
		Assert.assertEquals(innerPanel.getY(), 40);
	}
	
	@Test
	public void testFullRectangle() {
		Panel innerPanel = createInnerPanel(Anchor.FULL_RECTANGLE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 10);
		Assert.assertEquals(innerPanel.getWidth(), 80);
		Assert.assertEquals(innerPanel.getHeight(), 80);
	}
	
	@Test
	public void testTopWideAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.TOP_WIDE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 10);
		Assert.assertEquals(innerPanel.getWidth(), 80);
		Assert.assertEquals(innerPanel.getHeight(), 50);
	}
	
	@Test
	public void testLeftWideAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.LEFT_WIDE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 10);
		Assert.assertEquals(innerPanel.getWidth(), 50);
		Assert.assertEquals(innerPanel.getHeight(), 80);
	}
	
	@Test
	public void testRightWideAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.RIGHT_WIDE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 40);
		Assert.assertEquals(innerPanel.getY(), 10);
		Assert.assertEquals(innerPanel.getWidth(), 50);
		Assert.assertEquals(innerPanel.getHeight(), 80);
	}
	
	@Test
	public void testVerticalCenterAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.VERTICAL_CENTER_WIDE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 25);
		Assert.assertEquals(innerPanel.getY(), 10);
		Assert.assertEquals(innerPanel.getWidth(), 50);
		Assert.assertEquals(innerPanel.getHeight(), 80);
	}
	
	@Test
	public void testHorizontalCenterWide() {
		Panel innerPanel = createInnerPanel(Anchor.HORIZONTAL_CENTER_WIDE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 25);
		Assert.assertEquals(innerPanel.getWidth(), 80);
		Assert.assertEquals(innerPanel.getHeight(), 50);
	}
	
	@Test
	public void testBottomWideAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.BOTTOM_WIDE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 40);
		Assert.assertEquals(innerPanel.getWidth(), 80);
		Assert.assertEquals(innerPanel.getHeight(), 50);
	}
	
	@Test
	public void testNoneAnchor() {
		Panel innerPanel = createInnerPanel(Anchor.NONE);
		Panel outerPanel = createOuterPanel();
		outerPanel.add(innerPanel);
		Assert.assertEquals(innerPanel.getX(), 10);
		Assert.assertEquals(innerPanel.getY(), 10);
		Assert.assertEquals(innerPanel.getWidth(), 50);
		Assert.assertEquals(innerPanel.getHeight(), 50);
	}
	
}
