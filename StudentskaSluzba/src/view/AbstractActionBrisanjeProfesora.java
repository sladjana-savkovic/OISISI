/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.PredmetController;
import controller.ProfesorController;

/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractActionBrisanjeProfesora extends AbstractAction{
	
	private static final long serialVersionUID = -5969090909621537256L;

	public AbstractActionBrisanjeProfesora() {
		putValue(SHORT_DESCRIPTION, "Obri\u0161i profesora sa predmeta");
		putValue(MNEMONIC_KEY, KeyEvent.VK_B);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {"Odustanak","Potvrda"};
		ImageIcon icon = new ImageIcon("logo_images/garbage.jpg");
		
		if((TabbedPane.activeTab == 2) && (ButtonColumnPredmet.selectedRow != -1)) {
			int input1 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da �elite da obri�ete profesora sa predmeta?","Brisanje profesora sa predmeta",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input1 == JOptionPane.NO_OPTION) {
				//Brisanje predmeta sa spiska predmeta za odredjenog profesora
				ProfesorController.getInstance().uklanjanjePredmetaIzListe(ButtonColumnPredmet.selectedRow);
				//Brisanje profesora sa predmeta
				PredmetController.getInstance().obrisiProfesoraSaPredmeta(ButtonColumnPredmet.selectedRow);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Izaberite neki red u tabeli!","Gre\u0161ka",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
