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
		
		JMenu mnew = new JMenu("New");
		mnew.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
	
		JMenuItem minew = new JMenuItem("New");
		minew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		minew.setIcon(new ImageIcon("logo_images/add.jpg"));
		JMenuItem miclose = new JMenuItem("Close");
		miclose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miclose.setIcon(new ImageIcon("logo_images/close.png"));
		mnew.add(minew);
		mnew.addSeparator();
		mnew.add(miclose);
		mnew.addSeparator();
		
		JMenu edit = new JMenu("Edit");
		edit.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
		
		JMenuItem miedit = new JMenuItem("Edit");
		miedit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miedit.setIcon(new ImageIcon("logo_images/edit.jpg"));
		JMenuItem midelete = new JMenuItem("Delete");
		midelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		midelete.setIcon(new ImageIcon("logo_images/garbage.jpg"));
		edit.add(miedit);
		edit.addSeparator();
		edit.add(midelete);
		edit.addSeparator();
		
		JMenu help = new JMenu("Help");
		help.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
		
		JMenuItem mihelp = new JMenuItem("Help");
		mihelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		mihelp.setIcon(new ImageIcon("logo_images/help.png"));
		JMenuItem miabout = new JMenuItem("About");
		miabout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miabout.setIcon(new ImageIcon("logo_images/about.jpg"));
		help.add(mihelp);
		help.addSeparator();
		help.add(miabout);
		help.addSeparator();
		
		add(mnew);
		mnew.setVisible(true);
		add(edit);
		edit.setVisible(true);
		add(help);
		help.setVisible(true);
	}

}
