/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * @author Sladjana Savkovic
 *
 */
public class TabbedPane extends JTabbedPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TabbedPane() {
		setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 20 ) );
		Color darkerBlue= new Color(0,200,200);
		setBackground(darkerBlue);
		
		MyTab firstTab=new MyTab("Studenti");
		this.addTab("Studenti", firstTab);
		this.setMnemonicAt(0, KeyEvent.VK_1);
		
		MyTab secondTab=new MyTab("Profesori");
		this.addTab("Profesori", secondTab);
		this.setMnemonicAt(1, KeyEvent.VK_2);
		
		MyTab thirdTab=new MyTab("Predmeti");
		this.addTab("Predmeti", thirdTab);
		this.setMnemonicAt(2, KeyEvent.VK_3);
		
	}
}
