/**
 * 
 */
package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		minew.setMnemonic('N');
		minew.setIcon(new ImageIcon("logo_images/add.jpg"));
		JMenuItem miclose = new JMenuItem("Close");
		miclose.setMnemonic('C');
		miclose.setIcon(new ImageIcon("logo_images/close.png"));
		mnew.add(minew);
		mnew.addSeparator();
		mnew.add(miclose);
		mnew.addSeparator();
		
		JMenu edit = new JMenu("Edit");
		edit.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
		
		JMenuItem miedit = new JMenuItem("Edit");
		miedit.setMnemonic('E');
		miedit.setIcon(new ImageIcon("logo_images/edit.jpg"));
		JMenuItem midelete = new JMenuItem("Delete");
		midelete.setMnemonic('D');
		midelete.setIcon(new ImageIcon("logo_images/garbage.jpg"));
		edit.add(miedit);
		edit.addSeparator();
		edit.add(midelete);
		edit.addSeparator();
		
		JMenu help = new JMenu("Help");
		help.setFont(new Font( "ForMenu", Font.PLAIN|Font.CENTER_BASELINE, 15 ));
		
		JMenuItem mihelp = new JMenuItem("Help");
		mihelp.setMnemonic('H');
		mihelp.setIcon(new ImageIcon("logo_images/help.png"));
		JMenuItem miabout = new JMenuItem("About");
		miabout.setMnemonic('A');
		miabout.setIcon(new ImageIcon("logo_images/about.jpg"));
		help.add(mihelp);
		help.addSeparator();
		help.add(miabout);
		help.addSeparator();
		
		add(mnew);
		add(edit);
		add(help);
	}

}
