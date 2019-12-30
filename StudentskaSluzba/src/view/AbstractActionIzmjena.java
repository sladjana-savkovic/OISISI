/**
 * 
 */
package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractActionIzmjena extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5915071679133354891L;

	public AbstractActionIzmjena() {
		putValue(SHORT_DESCRIPTION, "Izmijeni");
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(TabbedPane.activeTab == 0 && ButtonColumnStudent.selectedRow != -1) {
			IzmjenaStudenata i1 = new IzmjenaStudenata(null, "Izmjena studenta", true);
			i1.setVisible(true);
			
		}else if(TabbedPane.activeTab == 1 && ButtonColumnProfesor.selectedRow != -1) {
			IzmjenaProfesora i2 = new IzmjenaProfesora(null, "Izmjena profesora", true);
			i2.setVisible(true);
			
		}else if(TabbedPane.activeTab == 2 && ButtonColumnPredmet.selectedRow != -1){
			IzmjenaPredmeta i3 = new IzmjenaPredmeta(null, "Izmjena predmeta", true);
			i3.setVisible(true);
			
		}else if(ButtonColumnStudent.selectedRow == -1 || ButtonColumnProfesor.selectedRow == -1 || ButtonColumnPredmet.selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Izaberite neki red u tabeli!","Greška",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
