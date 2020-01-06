/**
 * 
 */
package view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

/**
 * @author Sladjana Savkovic
 *
 */
public class MyWindowListener implements WindowListener{
	
	public MyWindowListener() {
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		JFrame frame = (JFrame) arg0.getComponent();
		Object[] options = {"Da","Ne"};
		
		int code = JOptionPane.showOptionDialog(frame, "Da li ste sigurni da \u017eelite da zatvorite aplikaciju?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		if (code != JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			//upis u fajl 
			/*BazaStudenata.getInstance().writeStudenti();
			BazaPredmeta.getInstance().writePredmeti();
			BazaProfesora.getInstance().writeProfesori();*/
			
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

}
