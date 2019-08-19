package game;

public enum Resolution {

	RESOLUTION_800x600(800, 600),
	RESOLUTION_1024x768(1024, 768),
	GAMEBOY_160x144(160, 144),
	NES_PAL_256x240(256, 240),
	NES_NTSC_256x224(256, 224),
	NINTENDO_3DS_LOWER_SCREEN_320x240(320, 240),
	MEGA_DRIVE_320x240(320, 240);
	
	private int width;
	private int height;
	
	private Resolution(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
