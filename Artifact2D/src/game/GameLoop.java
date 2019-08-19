package game;

public class GameLoop {

	private int framesPerSecond;
	private int frameCount;
	private float frameSecond;
	private long lastTime;
	private long updateCap = 1000000000 / 60;
	private long timeToProcess;
	private boolean running;
	private Game game;

	public GameLoop(Game game) {
		this.game = game;
	}

	private void updateFps(long deltaTime) {
		float delta = deltaTime / 1000000000f;
		frameSecond += delta;

		if (frameSecond > 1) {
			framesPerSecond = frameCount;
			frameCount = 0;
			frameSecond = 0;
		}
	}

	public void loop() {
		if (running)
			return;
		lastTime = System.nanoTime();
		running = true;

		while (running) {
			boolean render = false;
			long time = System.nanoTime();
			long delta = time - lastTime;
			lastTime = time;
			timeToProcess += delta;

			while (timeToProcess >= updateCap) {
				game.update(1 / 60f);
				timeToProcess -= updateCap;
				render = true;
			}

			updateFps(delta);

			if (render) {
				game.render();
				frameCount++;
			} else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getFramesPerSecond() {
		return framesPerSecond;
	}

}
