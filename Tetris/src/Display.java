import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Display extends JComponent {
	BufferedImage background;
	
	
	public Display() {
		try {
			background = ImageIO.read(new File("Board.png"));
		} catch (IOException e) {
			System.out.println("Background image does not exist");
			e.printStackTrace();
		}
	}
}
