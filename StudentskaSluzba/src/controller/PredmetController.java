/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
import model.Predmet;
import view.MyTab;

/**
 * @author Sladjana Savkovic
 *
 */
public class PredmetController {
	
	private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void obrisiPredmet(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Predmet predmet = BazaPredmeta.getInstance().getPredmetIndex(rowSelectedIndex);
    	BazaPredmeta.getInstance().obrisiPredmet(predmet.getSifra());	
    	// azuriranje prikaza
    	MyTab.azurirajPrikaz();
    }
	public boolean dodajPredmet(Predmet p) {
		if(!(BazaPredmeta.getInstance().dodajPredmet(p))) {
			return false;
		}
		MyTab.azurirajPrikaz();
		return true;
	}
	public void obrisiStudentaSaPredmeta(int tableSelectedIndex,int listSelectedIndex) {
		Predmet predmet = BazaPredmeta.getInstance().getPredmetIndex(tableSelectedIndex);
		if(listSelectedIndex != -1) {	//Ako se klikne na dugme Prikazi, neki red u tabeli ce sigurno biti selektovan
			BazaPredmeta.getInstance().obrisiStudenta(predmet.getSifra(), listSelectedIndex);
		}else {
			return;
		}
	}
	public ArrayList<String> studentiNaPredmetu(int row){
		ArrayList<String> studenti = new ArrayList<String>();
		if(BazaPredmeta.getInstance().spisakStudenataNaPredmetu(row) != null) {
			studenti = BazaPredmeta.getInstance().spisakStudenataNaPredmetu(row);
			return studenti;
		}
		return null;
	}
	public Predmet vratiSelektovanPredmet(int rowSelectedIndex) {
		Predmet p =null;
		if(rowSelectedIndex<0) {
			return p;
		}
		p = BazaPredmeta.getInstance().getPredmetIndex(rowSelectedIndex);
		return p;
	}
	
	//izmjena
	public boolean izmjeniPredmet(int rowSelectedIndex, Predmet predmet, Predmet t) {
		if(rowSelectedIndex < 0) {
			return false;
		}
		if(predmet.getSifra().equals(t.getSifra())) {
			BazaPredmeta.getInstance().izmjeniPredmet(predmet, t);
			MyTab.azurirajPrikaz();
			return true;
		}else {
			 //nova metosa koja provjerava da li postoji st sa tim br indeksa ako postoji(vrati true) ret, a ako ne opet pozovi izmjenu
			if(BazaPredmeta.getInstance().getPredmet(t.getSifra()) != null){
				return false;
			}else {
				BazaPredmeta.getInstance().izmjeniPredmet(predmet, t);
				MyTab.azurirajPrikaz();
				return true;
			}
		}
	}
	//dodavanje ili izmjena profesora na predmetu
	public void dodajProfesoraNaPredmet(String licnaKarta,int rowSelectedIndex) {
		if(rowSelectedIndex < 0){
			return;
		}
		BazaPredmeta.getInstance().profesorNaPredmet(licnaKarta, rowSelectedIndex);	
		MyTab.azurirajPrikaz();
	}
	public void obrisiProfesoraSaPredmeta(int rowSelectedIndex) {
		if(rowSelectedIndex < 0){
			return;
		}
		BazaPredmeta.getInstance().getPredmetIndex(rowSelectedIndex).setPredmetniProfesor("");
		MyTab.azurirajPrikaz();
	}
}
