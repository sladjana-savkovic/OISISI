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
	public boolean dodajProfesora(Profesor p) {
		if(!(BazaProfesora.getInstance().dodajProfesora(p))) {
			return false;
		}
		MyTab.azurirajPrikaz();
		return true;
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
	
	public Profesor vratiSelektovanogProfesora(int rowSelectedIndex) {
		Profesor p =null;
		if(rowSelectedIndex<0) {
			return p;
		}
		p = BazaProfesora.getInstance().getProfesorIndex(rowSelectedIndex);
		return p;
	}
	
	//izmjena
	public boolean izmjeniProfesora(int rowSelectedIndex, Profesor profesor, Profesor t) {
		if(rowSelectedIndex < 0) {
			return false;
		}
		if(profesor.getBrLicneKarte().equals(t.getBrLicneKarte())) {
			BazaProfesora.getInstance().izmjeniProfesora(profesor, t);
			MyTab.azurirajPrikaz();
			return true;
		}else {
			 //nova metosa koja provjerava da li postoji st sa tim br indeksa ako postoji(vrati true) ret, a ako ne opet pozovi izmjenu
			if(BazaProfesora.getInstance().getProfesor(t.getBrLicneKarte()) != null){
				return false;
			}else {
				BazaProfesora.getInstance().izmjeniProfesora(profesor, t);
				MyTab.azurirajPrikaz();
				return true;
			}
		}
	}
}
