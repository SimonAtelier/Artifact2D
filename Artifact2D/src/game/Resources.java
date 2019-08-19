package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {

	public static BufferedImage load(String file) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(Resources.class.getResource("/" + file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
