/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
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
		if(listSelectedIndex != -1) {	
			BazaPredmeta.getInstance().obrisiStudenta(predmet.getSifra(), listSelectedIndex);
			MyTab.azurirajPrikaz(); 
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

	public boolean izmijeniPredmet(int rowSelectedIndex, Predmet predmet, Predmet t) {
		if(rowSelectedIndex < 0) {
			return false;
		}
		//ako je sifra ostala ista, treba da se pozove izmjena nad ostalim podacima
		if(predmet.getSifra().equals(t.getSifra())) {
			BazaPredmeta.getInstance().izmijeniPredmet(predmet, t);
			MyTab.azurirajPrikaz();
			return true;
		//ako sifra nije ista
		}else {
			 //provjera da li postoji predmet sa tom sifrom, ako postoji vrati false, a ako ne opet pozove izmjenu
			if(BazaPredmeta.getInstance().getPredmet(t.getSifra()) != null){
				return false;
			}else {
				BazaPredmeta.getInstance().izmijeniPredmet(predmet, t);
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
		BazaPredmeta.getInstance().getPredmetIndex(rowSelectedIndex).setPredmetniProfesor(null);
		MyTab.azurirajPrikaz();
	}
	public void uklanjanjeProfesoraSaPredmeta(String sifraPredmeta) {
		
		BazaPredmeta.getInstance().getPredmet(sifraPredmeta).setPredmetniProfesor(null);
		MyTab.azurirajPrikaz();
	}
	public void uklanjanjeProfesoraSaSvakogPredmeta(int rowSelectedIndex) {
		
		Profesor p = BazaProfesora.getInstance().getProfesorIndex(rowSelectedIndex);
		
		//Nakon brisanja profesora, predmeti na kojima je on predavao sada nemaju profesora
		for(int i=0; i<p.getSpisakPredmeta().size(); i++)
			for(int j=0; j<BazaPredmeta.getInstance().getPredmeti().size(); j++) {
				if(BazaPredmeta.getInstance().getPredmeti().get(j).getSifra().equals(p.getSpisakPredmeta().get(i))) {
					BazaPredmeta.getInstance().getPredmeti().get(j).setPredmetniProfesor(null); 
					break;
				}
		}
	}
	public void dodajStudentaPredmetu(String indeks, int row) {
		studentiNaPredmetu(row).add(indeks);
	}
	public void uklanjanjeStudentaSaSvakogPredmeta(int row){
		
		//u spisku predmeta studenta se nalaze oni kojima treba ukloniti studenta sa tim brojem indeksa
		Student s = BazaStudenata.getInstance().getStudentIndex(row);
		
		for(int i=0; i<s.getSpisakPredmeta().size(); i++) 
			for(int j=0; j<BazaPredmeta.getInstance().getPredmeti().size(); j++) {
				if(BazaPredmeta.getInstance().getPredmeti().get(j).getSifra().equals(s.getSpisakPredmeta().get(i))) {
					BazaPredmeta.getInstance().getPredmeti().get(j).getSpisakStudenata().remove(s.getBrojIndeka());
				}
		}
	}
	public void uklanjanjeStudentaIzListe(int row, String sifraPredmeta) {
		Student s = BazaStudenata.getInstance().getStudentIndex(row);
		
		for(int i=0; i<BazaPredmeta.getInstance().getPredmeti().size(); i++) {
			if(BazaPredmeta.getInstance().getPredmeti().get(i).getSifra().equals(sifraPredmeta)) {
				BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().remove(s.getBrojIndeka());
			}
		}
		MyTab.azurirajPrikaz();
	}
	//Metoda koja ce se pozivati iz klase Izmjena studenta nakon if(izmjenjen)
	public void izmjenaListeStudenata(String stariIndeksStudenta, String noviIndeksStudenta) {
		
		for(int i=0; i<BazaPredmeta.getInstance().getPredmeti().size(); i++)
			for(int j=0; j<BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().size(); j++)
				if(BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().get(j).equals(stariIndeksStudenta)) {
					BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().remove(stariIndeksStudenta);
					BazaPredmeta.getInstance().getPredmeti().get(i).getSpisakStudenata().add(j, noviIndeksStudenta);
				}
	}
	//Metoda koja ce se pozivati iz klase Izmjena profesora i proslijediti stare podatke profesora i nove podatke profesora
	public void izmjenaPredmetnogProfesora(Profesor stariPodaci, Profesor noviPodaci) {
		
		for(int i=0; i<stariPodaci.getSpisakPredmeta().size(); i++)
			for(int j=0; j<BazaPredmeta.getInstance().getPredmeti().size(); j++) 
				if(BazaPredmeta.getInstance().getPredmeti().get(j).getSifra().equals(stariPodaci.getSpisakPredmeta().get(i)))
					BazaPredmeta.getInstance().getPredmeti().get(j).setPredmetniProfesor(noviPodaci);
	}
	public boolean profesorNaPredmetu(String licnaKarta) {
				
		for(int i=0; i<BazaPredmeta.getInstance().getPredmeti().size(); i++){
			if(BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor() != null)
				if(BazaPredmeta.getInstance().getPredmeti().get(i).getPredmetniProfesor().getBrLicneKarte().equals(licnaKarta))
						return true;
		}
		return false;
	}
}
