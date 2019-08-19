package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseListener, MouseMotionListener {

	private int mouseX;
	private int mouseY;

	public void update() {
	}

	private void updateCoordinates(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		updateCoordinates(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		updateCoordinates(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		updateCoordinates(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		updateCoordinates(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		updateCoordinates(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		updateCoordinates(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		updateCoordinates(e);
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
	
}
