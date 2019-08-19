package ui.border;

public class Insets {

	public int top;
	public int left;
	public int bottom;
	public int right;
	
	public Insets(Insets insets) {
		this(insets.top, insets.left, insets.bottom, insets.right);
	}
	
	public Insets(int top, int left, int bottom, int right) {
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}
	
	public void add(Insets other) {
		top += other.top;
		left += other.left;
		bottom += other.bottom;
		right += other.right;
	}
	
}
