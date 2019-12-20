/**
 * 
 */
package controller;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
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
}
