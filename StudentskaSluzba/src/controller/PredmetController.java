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
}
