/**
 * 
 */
package main;

import model.BazaPredmeta;
import model.BazaProfesora;
import view.MainFrame;

/**
 * @author Sladjana Savkovic
 *
 */
public class Main {

	public static void main(String[] args) {
		BazaPredmeta.getInstance();
		BazaProfesora.getInstance();
		MainFrame.getInstance();
	}

}
