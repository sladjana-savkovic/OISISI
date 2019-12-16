/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Sladjana Savkovic
 *
 */
public class BazaProfesora {
	
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	//samo da ubacim neke podatke za pocetak
	private ArrayList<Profesor> profesori;
	private ArrayList<String> predmeti;
	private ArrayList<String> predmeti1;
	
	public BazaProfesora() {
		initProfesore();
		//writeProfesori();
	}
	public void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		this.predmeti = new ArrayList<String>();
		this.predmeti1 = new ArrayList<String>();
		predmeti.add("E2123");
		predmeti.add("E3125");
		predmeti.add("SIIT852");
		predmeti1.add("E1042");
		predmeti1.add("MA750");
		predmeti1.add("II802");
		profesori.add(new Profesor("Nebojša","Ralević","23.08.1965.","Ćirpanova 25","062/782-41-02","rale65@gmail.com",
				"Trg Dositeja Obradovića 10","124kl789","doktor","redovni prof.",predmeti));
		profesori.add(new Profesor("Milan","Rapaić","16.11.1981.","Narodnog fronta 105","062/581-00-72","rapaja1981@gmail.com",
				"Trg Dositeja Obradovića 10","581af102","doktor","vanredni prof.",predmeti1));
	}
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	public Profesor getProfesorIndex(int index) {
		return this.profesori.get(index);
	}
	public String getValueAt(int row, int column) {
		Profesor profesor=this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getDatumRodjenja();
		case 3:
			return profesor.getAdresaStanovanja();
		case 4:
			return profesor.getTelefon();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		case 10:
			return Integer.toString(profesor.getBrojPredmeta());
		default:
			return null;
		}
	}
}
