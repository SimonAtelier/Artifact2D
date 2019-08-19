package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.UiElement;

public class Game {

	private int width;
	private int height;
	private int scale;
	private boolean running;
	private boolean fullScreen;
	private GameLoop gameLoop;
	private Input input;
	private BufferedImage buffer;
	private JPanel jPanel;
	private JFrame jFrame;
	private BufferStrategy bufferStrategy;
	private UiElement uiRoot;
	private Color clearColor;
	private Font font;
	private String title;

	public Game() {
		this(800, 600, 1);
	}

	public Game(Resolution resolution, int scale) {
		this(resolution.getWidth(), resolution.getHeight(), scale);
	}

	public Game(int width, int height, int scale) {
		setSize(width, height, scale);
	}

	public void onInitialize() {
	}

	public void onRender(Graphics2D g2d) {
	}

	public void onUpdate(float deltaTime) {
	}

	private void initialize() {
		gameLoop = new GameLoop(this);
		input = new Input();
		clearColor = Color.BLACK;
		initializeUiRoot();
		initializeBuffer();
		loadFont();
		registerFont();
		onInitialize();
	}

	private void initializeUiRoot() {
		uiRoot = createUiRoot();
	}

	private void initializeBuffer() {
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	private void loadFont() {
		try {
			InputStream is = Game.class.getResourceAsStream("/fonts/monogram_extended.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void registerFont() {
		if (font == null)
			return;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(font);
		font = new Font("monogramextended", Font.PLAIN, 16);
	}

	private UiElement createUiRoot() {
		UiElement uiRoot = new UiElement();
		uiRoot.setWidth(width);
		uiRoot.setHeight(height);
		uiRoot.setOpaque(false);
		return uiRoot;
	}

	private void displayFrame() {
		getJFrame().setVisible(true);
		getJFrame().createBufferStrategy(2);
		bufferStrategy = getJFrame().getBufferStrategy();
	}

	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setTitle(title);
			jFrame.setSize(width * scale, height * scale);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setIgnoreRepaint(true);
			jFrame.setContentPane(getJPanel());
			jFrame.setResizable(false);
			if (fullScreen) {
				jFrame.setUndecorated(true);
				jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			} else {
				jFrame.pack();
			}
			jFrame.setLocationRelativeTo(null);
		}
		return jFrame;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			Dimension dimension = new Dimension(width * scale, height * scale);
			jPanel = new JPanel();
			jPanel.setSize(dimension);
			jPanel.setPreferredSize(dimension);
			jPanel.setMinimumSize(dimension);
			jPanel.setMaximumSize(dimension);
			jPanel.setIgnoreRepaint(true);
			jPanel.addMouseListener(input);
			jPanel.addMouseMotionListener(input);
		}
		return jPanel;
	}

	public void update(float deltaTime) {
		input.update();
		onUpdate(deltaTime);
	}

	public void render() {
		Graphics2D g2d = (Graphics2D) buffer.getGraphics();
		g2d.setColor(clearColor);
		g2d.fillRect(0, 0, width, height);
		g2d.setFont(font);
		onRender(g2d);
		uiRoot.render(g2d);
		g2d.setColor(Color.WHITE);
		g2d.dispose();
		swap();
	}

	private void swap() {
		Graphics2D g2d = (Graphics2D) bufferStrategy.getDrawGraphics();
		g2d.translate(getJFrame().getInsets().left, getJFrame().getInsets().top);
		g2d.drawImage(buffer, 0, 0, width * scale, height * scale, null);
		g2d.setFont(font);
		g2d.setColor(Color.WHITE);
		g2d.drawString("fps: " + gameLoop.getFramesPerSecond(), 10, 17);
		g2d.dispose();
		bufferStrategy.show();
	}

	public void start() {
		if (running)
			return;
		running = true;
		initialize();
		displayFrame();
		loop();
	}

	public void stop() {
		if (!running)
			return;
		running = false;
	}

	private void loop() {
		gameLoop.loop();
	}

	public void setTitle(String title) {
		this.title = title;
		if (running)
			getJFrame().setTitle(title);
	}

	public UiElement getUiRoot() {
		return uiRoot;
	}

	public void setFullScreen(boolean fullScreen) {
		this.fullScreen = fullScreen;
	}

	public void setClearColor(Color clearColor) {
		this.clearColor = clearColor;
	}

	public void setSize(int width, int height, int scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;
	}

	public void setSize(Resolution resolution, int scale) {
		setSize(resolution.getWidth(), resolution.getHeight(), scale);
	}

}
