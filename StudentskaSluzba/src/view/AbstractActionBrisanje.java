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
import controller.StudentController;

/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractActionBrisanje extends AbstractAction{
	
	private static final long serialVersionUID = 5247764763731153150L;

	public AbstractActionBrisanje() {
		putValue(SHORT_DESCRIPTION, "Obri\u0161i");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K,KeyEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] options = {"Odustanak","Potvrda"};
		ImageIcon icon = new ImageIcon("logo_images/garbage.jpg");
		if ((TabbedPane.activeTab == 0) && (ButtonColumnStudent.selectedRow != -1)) {
			int input0 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da �elite da obri�ete studenta?","Brisanje studenta",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input0 == JOptionPane.NO_OPTION) {
				StudentController.getInstance().obrisiStudent(ButtonColumnStudent.selectedRow);
			}
		} else if ((TabbedPane.activeTab == 1) && (ButtonColumnProfesor.selectedRow != -1)) {
			int input1 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da �elite da obri�ete profesora?","Brisanje profesora",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input1 == JOptionPane.NO_OPTION) {
				ProfesorController.getInstance().obrisiProfesora(ButtonColumnProfesor.selectedRow);
			}
		} else if ((TabbedPane.activeTab == 2) && (ButtonColumnPredmet.selectedRow != -1)) {
			int input2 = JOptionPane.showOptionDialog(null, "Da li ste sigurni da �elite da obri�ete predmet?","Brisanje predmeta",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input2 == JOptionPane.NO_OPTION) {
				PredmetController.getInstance().obrisiPredmet(ButtonColumnPredmet.selectedRow);
			}
		} else if((ButtonColumnStudent.selectedRow == -1) || (ButtonColumnProfesor.selectedRow == -1) || (ButtonColumnProfesor.selectedRow == -1)){
			JOptionPane.showMessageDialog(null, "Izaberite neki red u tabeli!","Gre�ka",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
