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
	
	private static final long serialVersionUID = 5562711743760452740L;
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		// Podesavamo dimenzije prozora na 3/4 duzine i sirine monitora
		setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
		//postavljamo JFrame na centar ekrana
		setLocationRelativeTo(null);
		 //Postavljamo akciju pri zatvaranju prozora
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//dodavanje listener-a na akciju zatvaranja
		addWindowListener(new MyWindowListener());
		//Podesavanje naslova
		setTitle("Studentska slu\u017eba");	
		//Podesavanje boje pozadine
		Color lightBlue= new Color(221,245,250);
		getContentPane().setBackground(lightBlue);
		//Dodavanje ikonice
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);
		
		createMenuBar();
		createToolbar();
		createTabbedPane();
		createStatusBar();
		
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

	public void createMenuBar() {
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
	}
	public void createStatusBar() {
		StatusBar sbar=new StatusBar();
		add(sbar,BorderLayout.SOUTH);
	}
}
