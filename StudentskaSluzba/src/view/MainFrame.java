/**
 * 
 */
package view;


import java.awt.*;
import javax.swing.*;

/**
 * @author Sladjana Savkovic
 *
 */
public class MainFrame extends JFrame{
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame() {
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		// Podesavamo dimenzije prozora na 3/4 duzine i sirine monitora
		setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
		//postavljamo JFrame na centar ekrana
		setLocationRelativeTo(null);
		setVisible(true);
		 //Postavljamo akciju pri zatvaranju prozora
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//Podesavanje naslova
		setTitle("Studentska sluzba");
		//Podesavanje boje pozadine
		Color lightBlue= new Color(221,245,250);
		getContentPane().setBackground(lightBlue);
		//Dodavanje ikonice
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);
	}
}
