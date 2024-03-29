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
		putValue(MNEMONIC_KEY, KeyEvent.VK_B);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B,KeyEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] options = {"Odustanak","Potvrda"};
		ImageIcon icon = new ImageIcon("logo_images/garbage.jpg");
				
		if ((TabbedPane.activeTab == 0) && (ButtonColumnStudent.selectedRow != -1)) {
			int input0 = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da \u017eelite da obri\u0161ete studenta?","Brisanje studenta",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input0 == JOptionPane.NO_OPTION) {
				
				//prvo se ukloni student sa svakog predmeta kojeg je slusao
				PredmetController.getInstance().uklanjanjeStudentaSaSvakogPredmeta(ButtonColumnStudent.selectedRow);
				//brisanje studenta iz tabele
				StudentController.getInstance().obrisiStudent(ButtonColumnStudent.selectedRow);
				
				ButtonColumnStudent.selectedRow = -1;
				ButtonColumnProfesor.selectedRow = -1;
				ButtonColumnPredmet.selectedRow = -1;
			}
		} else if ((TabbedPane.activeTab == 1) && (ButtonColumnProfesor.selectedRow != -1)) {
			int input1 = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da \u017eelite da obri\u0161ete profesora?","Brisanje profesora",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input1 == JOptionPane.NO_OPTION) {
				
				//prvo se profesor ukloni sa svakog predmeta koji je predavao
				PredmetController.getInstance().uklanjanjeProfesoraSaSvakogPredmeta(ButtonColumnProfesor.selectedRow);
				//zatim se izbrise sam profesor
				ProfesorController.getInstance().obrisiProfesora(ButtonColumnProfesor.selectedRow);
				
				ButtonColumnStudent.selectedRow = -1;
				ButtonColumnProfesor.selectedRow = -1;
				ButtonColumnPredmet.selectedRow = -1;
			}
		} else if ((TabbedPane.activeTab == 2) && (ButtonColumnPredmet.selectedRow != -1)) {
			int input2 = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da \u017eelite da obri\u0161ete predmet?","Brisanje predmeta",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,options[1]);
			if(input2 == JOptionPane.NO_OPTION) {
				
				//ovdje treba da se prvo obrise taj predmet sa spiska predmeta profesora
				ProfesorController.getInstance().uklanjanjePredmetaIzListe(ButtonColumnPredmet.selectedRow);
				//predmet se brise i sa spiska predmeta studenta
				StudentController.getInstance().obrisiPredmetSaSpiskaPredmetaStudenta(ButtonColumnPredmet.selectedRow);
				//zatim se brise sam predmet
				PredmetController.getInstance().obrisiPredmet(ButtonColumnPredmet.selectedRow);
					
				ButtonColumnStudent.selectedRow = -1;
				ButtonColumnProfesor.selectedRow = -1;
				ButtonColumnPredmet.selectedRow = -1;
			}
		} else if((ButtonColumnStudent.selectedRow == -1) || (ButtonColumnProfesor.selectedRow == -1) || (ButtonColumnProfesor.selectedRow == -1)){
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite neki red u tabeli!","Gre\u0161ka",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
