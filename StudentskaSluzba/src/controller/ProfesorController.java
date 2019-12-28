/**
 * 
 */
package controller;

import java.util.ArrayList;

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
	public void obrisiPredmetProfesora(int tableSelectedIndex,int listSelectedIndex) {
		Profesor profesor = BazaProfesora.getInstance().getProfesorIndex(tableSelectedIndex);
		if(listSelectedIndex != -1) {	//Ako se klikne na dugme Prikazi, neki red u tabeli ce sigurno biti selektovan
			BazaProfesora.getInstance().obrisiPredmet(profesor.getBrLicneKarte(),listSelectedIndex);
		}else {
			return;
		}
	}
	public ArrayList<String> predmetiProfesora(int row){
		ArrayList<String> predmeti = new ArrayList<String>();
		if(BazaProfesora.getInstance().spisakPredmetaProfesora(row) != null) {
			predmeti = BazaProfesora.getInstance().spisakPredmetaProfesora(row);
			return predmeti;
		}
		return null;
	}
}
