package game;

import java.awt.Graphics2D;

import ui.UiElement;

public class Scene {

	private UiElement uiRoot;
	
	public Scene() {
		uiRoot = new UiElement();
	}
	
	public void update(float deltaTime) {
		onUpdate(deltaTime);
	}
	
	public void render(Graphics2D g2d) {
		onRender(g2d);
	}
	
	public void onUpdate(float deltaTime) {
		
	}
	
	public void onRender(Graphics2D g2d) {
		
	}
	
	public UiElement getUiRoot() {
		return uiRoot;
	}
	
}
