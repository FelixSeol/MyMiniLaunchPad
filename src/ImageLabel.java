import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
	public ImageLabel(){
		super();
		setIcon(createImageIcon("ableton_logo.jpg","ableton_logo"));
		setVisible(true);
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			ImageIcon icon = new ImageIcon(imgURL, description);
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 100, 100, java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			return icon;
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}