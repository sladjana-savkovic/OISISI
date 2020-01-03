/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractActionDodNaPredmet extends AbstractAction{


	private static final long serialVersionUID = 7180480662788265608L;
	
	public AbstractActionDodNaPredmet() {
		putValue(SHORT_DESCRIPTION, "Dodaj studenta na predmet");
		putValue(MNEMONIC_KEY, KeyEvent.VK_J);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(TabbedPane.activeTab==2 && ButtonColumnPredmet.selectedRow!=-2) {
			DodavanjeStudentaNaPredmet d = new DodavanjeStudentaNaPredmet(null, "Predmet-dodavanje studenta", true);
			d.setVisible(true);
		}else  if(ButtonColumnPredmet.selectedRow==-1) {
			JOptionPane.showMessageDialog(null, "Izaberite neki red u tabeli!","Greška",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
