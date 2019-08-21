package ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import ui.border.Border;
import ui.border.Insets;
import ui.event.MouseListener;
import ui.layout.Anchor;
import ui.layout.Layout;
import ui.layout.LayoutAnchor;

public class UiElement {

	private int x;
	private int y;
	private int width;
	private int height;
	private boolean visible;
	private boolean opaque;
	private Color background;
	private Color foreground;
	private Border border;
	private Layout layout;
	private LayoutAnchor layoutAnchor;
	private UiElement parent;
	private List<UiElement> children;
	private List<MouseListener> listeners;

	public UiElement() {
		visible = true;
		opaque = true;
		background = Color.GRAY;
		foreground = Color.WHITE;
		children = new ArrayList<UiElement>();
		listeners = new ArrayList<MouseListener>();
		layoutAnchor = new LayoutAnchor(Anchor.NONE);
	}

	public void relayout() {
		layout();
		if (parent != null)
			parent.relayout();
		else
			layout();
	}

	public void layout() {
		layoutChildren();
		if (layoutAnchor != null)
			layoutAnchor.anchor(this);
		if (layout != null)
			layout.layout(this);
	}

	protected void layoutChildren() {
		for (int i = 0; i < children.size(); i++) {
			UiElement child = children.get(i);
			child.layout();
		}
	}

	protected void renderBackground(Graphics2D g2d) {
		if (!opaque)
			return;
		g2d.setColor(background);
		g2d.fillRect(getInnerX(), getInnerY(), getInnerWidth(), getInnerHeight());
	}

	protected void renderChildren(Graphics2D g2d) {
		for (int i = 0; i < children.size(); i++) {
			UiElement child = children.get(i);
			child.render(g2d);
		}
	}

	protected void renderBorder(Graphics2D g2d) {
		if (border != null)
			border.renderBorder(g2d, x, y, width, height);
	}

	public void render(Graphics2D g2d) {
		if (!visible)
			return;
		renderBackground(g2d);
		renderBorder(g2d);
		renderChildren(g2d);
	}

	public void add(UiElement uiElement) {
		if (uiElement == null)
			return;
		children.add(uiElement);
		uiElement.setParent(this);
		relayout();
	}

	public void addMouseListener(MouseListener listener) {
		if (listener == null)
			return;
		listeners.add(listener);
	}

	public void removeMouseListener(MouseListener listener) {
		if (listener == null)
			return;
		listeners.remove(listener);
	}

	public boolean contains(int x, int y) {
		return x >= getX() && x < (getX() + getWidth()) && y >= getY() && y < (getY() + getHeight());
	}

	public int getChildCount() {
		return children.size();
	}

	public UiElement getChildAt(int index) {
		return children.get(index);
	}

	public boolean isRoot() {
		return parent == null;
	}

	public Insets getInsets() {
		if (border != null)
			return border.getInsets();
		return new Insets(0, 0, 0, 0);
	}

	public int getInnerX() {
		return getX() + getInsets().left;
	}

	public int getInnerY() {
		return getY() + getInsets().top;
	}

	public int getInnerWidth() {
		Insets insets = getInsets();
		return getWidth() - insets.left - insets.right;
	}

	public int getInnerHeight() {
		Insets insets = getInsets();
		return getHeight() - insets.top - insets.bottom;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isOpaque() {
		return opaque;
	}

	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Border getBorder() {
		return border;
	}

	public void setBorder(Border border) {
		this.border = border;
	}

	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public void setLayoutAnchor(Anchor anchor) {
		layoutAnchor.setAnchor(anchor);
	}

	public UiElement getParent() {
		return parent;
	}

	public void setParent(UiElement parent) {
		this.parent = parent;
	}

}
