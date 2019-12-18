/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import model.BazaPredmeta;

/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractActionPretrazi extends AbstractAction{
	
	private static final long serialVersionUID = -9043326786403157765L;

	public AbstractActionPretrazi() {
		putValue(SHORT_DESCRIPTION, "Pretraži");
		putValue(MNEMONIC_KEY, KeyEvent.VK_T);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(TabbedPane.activeTab == 2) {
			new PretragaPredmeta(Toolbar.textSearch.getText());
			MyTab.azurirajPrikaz();
		}
	}
}
