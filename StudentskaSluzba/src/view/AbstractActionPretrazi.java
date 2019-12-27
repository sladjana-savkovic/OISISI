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
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(TabbedPane.activeTab == 0) {
			//Implementacija
		}
		else if(TabbedPane.activeTab == 1) {
			String text=Toolbar.textSearch.getText();
			if (text.length() == 0) {
                 ProfesorJTable.sorter.setRowFilter(null);
            } else {
           	  new PretragaProfesora(text, ProfesorJTable.sorter);
            }
			Toolbar.textSearch.setText("");
			Toolbar.textSearch.requestFocus();
		}
		else if(TabbedPane.activeTab == 2) {
			String text=Toolbar.textSearch.getText();
			if (text.length() == 0) {
                 PredmetJTable.sorter.setRowFilter(null);
            }else {
           	  new PretragaPredmeta(text, PredmetJTable.sorter);
            }
			Toolbar.textSearch.setText("");
			Toolbar.textSearch.requestFocus();
		}
	}
}
