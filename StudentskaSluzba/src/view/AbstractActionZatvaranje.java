/**
 * 
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractActionZatvaranje extends AbstractAction{

	public AbstractActionZatvaranje() {
		putValue(SHORT_DESCRIPTION, "Zatvaranje");
		putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] options = {"Da","Ne"};
		//ImageIcon icon = new ImageIcon("logo_images/g.jpg");
		int input0 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da \u017eelite da zatvorite aplikaciju?","Zatvaranje aplikacije",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(input0==JOptionPane.YES_OPTION) {
			MainFrame.getInstance().dispose();
		}
		
	}
}
