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
public class AbstractActionHelp extends AbstractAction
{
	private static final long serialVersionUID = -2409538436641952146L;
	
	public AbstractActionHelp() {
		putValue(SHORT_DESCRIPTION, "Pomo\u0107");
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HelpDialog help = new HelpDialog(null, "Pomo\u0107", true);
		help.setVisible(true);
	}
	

}
