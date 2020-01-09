/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.sun.glass.events.KeyEvent;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractActionZatvaranje extends AbstractAction{

	private static final long serialVersionUID = 1675939898889578775L;

	public AbstractActionZatvaranje() {
		putValue(SHORT_DESCRIPTION, "Zatvaranje");
		putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	Object[] options = {"Da","Ne"};
		//ImageIcon icon = new ImageIcon("logo_images/g.jpg");
		int input0 = JOptionPane.showOptionDialog(MainFrame.getInstance(), "Da li ste sigurni da \u017eelite da zatvorite aplikaciju?","Zatvaranje aplikacije",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if(input0!=JOptionPane.YES_OPTION) {
			MainFrame.getInstance().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}else {
			MainFrame.getInstance().dispose();
			BazaStudenata.getInstance().writeStudenti();
			BazaPredmeta.getInstance().writePredmeti();
			BazaProfesora.getInstance().writeProfesori();
			
			System.exit(0);
		}
	}
}
