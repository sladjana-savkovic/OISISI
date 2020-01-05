/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractActionDodavanjeProfesora extends AbstractAction{
	
	private static final long serialVersionUID = 2017847519561773694L;
	
	public AbstractActionDodavanjeProfesora() {
		putValue(SHORT_DESCRIPTION, "Dodaj profesora na predmet");
		putValue(MNEMONIC_KEY, KeyEvent.VK_F);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if((TabbedPane.activeTab == 2) && (ButtonColumnPredmet.selectedRow != -1)) {
			DodavanjeProfesoraNaPredmet d = new DodavanjeProfesoraNaPredmet(null, "Predmet-dodavanje profesora", true);
			d.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Izaberite neki red u tabeli!","Gre\u0161ka",JOptionPane.ERROR_MESSAGE);
			//System.out.println(ButtonColumnPredmet.selectedRow);
		}
	}

}
