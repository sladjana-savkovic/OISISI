/**
 * 
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractActionAbout extends AbstractAction{


	private static final long serialVersionUID = -4986114630668210173L;

	public AbstractActionAbout() {
		putValue(SHORT_DESCRIPTION, "O nama");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		AboutDialog ad = new AboutDialog(null, "O nama", true);
		ad.setVisible(true);
	}

}
