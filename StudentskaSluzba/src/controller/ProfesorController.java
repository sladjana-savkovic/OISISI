/**
 * 
 */
package controller;

import model.BazaProfesora;
import model.Profesor;
import view.MyTab;

/**
 * @author Sladjana Savkovic
 *
 */
public class ProfesorController {
	
private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void obrisiProfesora(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Profesor profesor = BazaProfesora.getInstance().getProfesorIndex(rowSelectedIndex);
    	BazaProfesora.getInstance().obrisiProfesora(profesor.getBrLicneKarte());
		// azuriranje prikaza
    	MyTab.azurirajPrikaz();
    }
}
