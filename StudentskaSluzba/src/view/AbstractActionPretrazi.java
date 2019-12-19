/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;


/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractActionPretrazi extends AbstractAction{
	
	private static final long serialVersionUID = -9043326786403157765L;

	public AbstractActionPretrazi() {
		putValue(SHORT_DESCRIPTION, "Pretraži");
		putValue(MNEMONIC_KEY, KeyEvent.VK_T);
		//BazaProfesora.getInstance().writeProfesoriIn("data_files/profesori_pom.dat");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(TabbedPane.activeTab == 0) {
			//Implementacija
		}
		else if(TabbedPane.activeTab == 1) {
			new PretragaProfesora(Toolbar.textSearch.getText());
			MyTab.azurirajPrikaz();
		}
		else if(TabbedPane.activeTab == 2) {
			new PretragaPredmeta(Toolbar.textSearch.getText());
			MyTab.azurirajPrikaz();
		}
	}
}
