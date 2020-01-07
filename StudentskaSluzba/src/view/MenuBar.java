/**
 * 
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * @author Dragana Carapic
 *
 */
public class MenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	
	public MenuBar() {
		
		AbstractActionDodavanje ad = new AbstractActionDodavanje();
		AbstractActionZatvaranje az = new AbstractActionZatvaranje();
		AbstractActionBrisanje ab = new AbstractActionBrisanje();
		AbstractActionIzmjena ai = new AbstractActionIzmjena();
		AbstractActionHelp ah = new AbstractActionHelp();
		AbstractActionAbout aa = new AbstractActionAbout();
		
		JMenu mnew = new JMenu("Dodaj");
		mnew.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
	
		JMenuItem minew = new JMenuItem("Dodaj");
		minew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		minew.setIcon(new ImageIcon("logo_images/add.jpg"));
		JMenuItem miclose = new JMenuItem("Iza\u0111i");
		miclose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		miclose.setIcon(new ImageIcon("logo_images/close.png"));
		mnew.add(minew);
		mnew.addSeparator();
		mnew.add(miclose);
		mnew.addSeparator();
		
		minew.addActionListener(ad);
		miclose.addActionListener(az);
		
		JMenu edit = new JMenu("Izmijeni");
		edit.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
		
		JMenuItem miedit = new JMenuItem("Izmijeni");
		miedit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		miedit.setIcon(new ImageIcon("logo_images/edit.jpg"));
		JMenuItem midelete = new JMenuItem("Izbri\u0161i");
		midelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		midelete.setIcon(new ImageIcon("logo_images/garbage.jpg"));
		edit.add(miedit);
		edit.addSeparator();
		edit.add(midelete);
		edit.addSeparator();
		
		midelete.addActionListener(ab);
		miedit.addActionListener(ai);
		
		JMenu help = new JMenu("Pomo\u0107");
		help.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
		
		JMenuItem mihelp = new JMenuItem("Pomo\u0107");
		mihelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		mihelp.setIcon(new ImageIcon("logo_images/help.png"));
		JMenuItem miabout = new JMenuItem("O nama");
		miabout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		miabout.setIcon(new ImageIcon("logo_images/about.jpg"));
		help.add(mihelp);
		help.addSeparator();
		help.add(miabout);
		help.addSeparator();
		
		mihelp.addActionListener(ah);
		miabout.addActionListener(aa);
		
		add(mnew);
		mnew.setVisible(true);
		add(edit);
		edit.setVisible(true);
		add(help);
		help.setVisible(true);
	}

}
