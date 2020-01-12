/**
 * 
 */
package main;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import view.MainFrame;

/**
 * @author Sladjana Savkovic
 *
 */
public class Main {

	public static void main(String[] args) {
		BazaStudenata.getInstance();
		BazaProfesora.getInstance();
		BazaPredmeta.getInstance();
		MainFrame.getInstance();
	}

}
