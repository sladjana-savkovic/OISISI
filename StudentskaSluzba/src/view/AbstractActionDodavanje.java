/**
 * 
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractActionDodavanje extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8602721840638190765L;

	public AbstractActionDodavanje() {
		putValue(SHORT_DESCRIPTION, "Dodavanje");
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (TabbedPane.activeTab == 0) {
			
				DodavanjeStudenata dod = new DodavanjeStudenata(null, "Dodavanje studenta", true);
				dod.setVisible(true);
		

		}else if(TabbedPane.activeTab == 1) {
			//to do

		}else if(TabbedPane.activeTab == 2) {
			//to do
		}
		
	}
	

}
