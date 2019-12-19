/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.PredmetController;
import controller.ProfesorController;
import model.BazaPredmeta;
import model.BazaProfesora;

/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractActionBrisanje extends AbstractAction{
	
	private static final long serialVersionUID = 5247764763731153150L;

	public AbstractActionBrisanje() {
		putValue(SHORT_DESCRIPTION, "Obriši");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K,KeyEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] options = {"Odustanak","Potvrda"};
		ImageIcon icon = new ImageIcon("logo_images/garbage.jpg");
		if ((TabbedPane.activeTab == 0) && (ButtonColumnProfesor.selectedRow==10) /*OVDJE CE ICI NESTO DRUGO*/) {
			int input0 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete studenta?","Brisanje studenta",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input0 == JOptionPane.NO_OPTION) {
				//Implementacija
			}
		} else if ((TabbedPane.activeTab == 1) && (ButtonColumnProfesor.selectedRow != -1)) {
			int input1 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete profesora?","Brisanje profesora",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input1 == JOptionPane.NO_OPTION) {
				//System.out.println(BazaProfesora.getInstance());
				ProfesorController.getInstance().obrisiProfesora(ButtonColumnProfesor.selectedRow);
				//System.out.println(BazaProfesora.getInstance());
				MyTab.azurirajPrikaz();
				BazaProfesora.getInstance().writeProfesoriIn("data_files/profesori_pom.dat");
			}
			//Implementacija
		} else if ((TabbedPane.activeTab == 2) && (ButtonColumnPredmet.selectedRow != -1)) {
			int input2 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete profesora?","Brisanje profesora",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input2 == JOptionPane.NO_OPTION) {
				//System.out.println(BazaPredmeta.getInstance());
				PredmetController.getInstance().obrisiPredmet(ButtonColumnPredmet.selectedRow);
				//System.out.println(BazaPredmeta.getInstance());
				MyTab.azurirajPrikaz();
				BazaPredmeta.getInstance().writePredmetiIn("data_files/predmeti_pom.dat");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Izaberite neki red u tabeli!","Greška",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
