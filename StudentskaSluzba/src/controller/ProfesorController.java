/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
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
			MyTab.azurirajPrikaz(); //novo
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
			return null;
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
	//metoda za prikaz licnih karti svih profesora u combo box-u
	public String[] getLicneKarte(int rowSelectedIndex){
		
		String[] licneKarte = new String[BazaProfesora.getInstance().getProfesori().size()];
		
		//ime i prezime profesora
		String predmetniProfesor = BazaPredmeta.getInstance().getPredmetIndex(rowSelectedIndex).getPredmetniProfesor();
		String licnaPredmetnogProfesora = "";
		boolean flag=true;
		
		if(!predmetniProfesor.equals("")){
			for(int i=0; i<BazaProfesora.getInstance().getProfesori().size(); i++)
				if(predmetniProfesor.contains(BazaProfesora.getInstance().getProfesori().get(i).getIme()) && 
						predmetniProfesor.contains(BazaProfesora.getInstance().getProfesori().get(i).getPrezime()))
							licnaPredmetnogProfesora = BazaProfesora.getInstance().getProfesori().get(i).getBrLicneKarte();
		}
		
		if(licnaPredmetnogProfesora.equals("")) {
			flag=false;
			for(int i=0; i<licneKarte.length; i++) {
				licneKarte[i] = BazaProfesora.getInstance().getProfesori().get(i).getBrLicneKarte();
			}
		}else {
			for(int i=0; i<licneKarte.length; i++) {
				if(!BazaProfesora.getInstance().getProfesori().get(i).getBrLicneKarte().equals(licnaPredmetnogProfesora))
					licneKarte[i] = BazaProfesora.getInstance().getProfesori().get(i).getBrLicneKarte();
			}
		}
		
		//Uklanjanje praznih polja iz stringa
		if(flag) {
			String[] rezultat = new String[licneKarte.length-1];
			int j=0;
			for(int i=0; i<licneKarte.length; i++) {
				if(licneKarte[i] != null) {
					rezultat[j++] = licneKarte[i];
				}
			}
			return rezultat;
		}else {
			return licneKarte;
		}	
	}
	/*public boolean provjeriVelicinuListe() {
		return BazaProfesora.getInstance().getProfesori().isEmpty();
	}*/
	
	public void uklanjanjePredmetaIzListe(int rowSelectedIndex) {
		//rowSelectedIndex predstavlja selektovan red predmeta u tabeli
		
		Predmet p = BazaPredmeta.getInstance().getPredmetIndex(rowSelectedIndex);
		//Da li obrisali predmet pomocu napisane metode, treba mi informacija o indeksu profesora kojem brisem predmet i o indeksu predmeta
		//profesora u listi predmeta
		
		int indeksProfesora = -1;
		int indeksPredmeta = -1;
		
		for(int i=0; i<BazaProfesora.getInstance().getProfesori().size(); i++) {
			for(int j=0; j<BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size(); j++)
				if(BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j).equals(p.getSifra())) {
					indeksProfesora = i;
					indeksPredmeta = j;
					break;
				}
		}
		
		if((indeksProfesora != -1) && (indeksPredmeta != -1))
			obrisiPredmetProfesora(indeksProfesora, indeksPredmeta);
	}
	public void izmjenaListePredmeta(String staraSifraPredmeta, String novaSifraPredmeta) {
		
		for(int i=0; i<BazaProfesora.getInstance().getProfesori().size(); i++)
			for(int j=0; j<BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().size(); j++) {
				if(BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().get(j).equals(staraSifraPredmeta)) {
					BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().remove(staraSifraPredmeta);
					BazaProfesora.getInstance().getProfesori().get(i).getSpisakPredmeta().add(j, novaSifraPredmeta);
				}
			}
	}
}
