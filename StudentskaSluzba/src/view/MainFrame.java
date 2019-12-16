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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		
		createToolbar();
		createTabbedPane();
		
		//DodavanjePredmeta dodaj = new DodavanjePredmeta();
		//dodaj.setVisible(true);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		setVisible(true);
		
	}
	public void createToolbar() {
		Toolbar toolbar = new Toolbar();
		// dodajem Toolbar u moj Frame, klasa BorderLayout se odnosi na rad sa prostorim rasporedom
		//Toolbar postavljam na vrh glavne forme
		add(toolbar, BorderLayout.NORTH);
	}
	public void createTabbedPane() {
		TabbedPane tabbedPane = new TabbedPane();
		add(tabbedPane,BorderLayout.CENTER);
	}
	
}
