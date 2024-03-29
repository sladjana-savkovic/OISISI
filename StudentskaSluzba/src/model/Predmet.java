/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Sladjana Savkovic
 *
 */
public class Predmet implements Serializable{

	private static final long serialVersionUID = 1640112284986110952L;
	
	private String sifra,naziv;
	private Profesor predmetniProfesor;
	private int semestar,godinaStudija;
	//U ArrayList-i cuvam indekse studenata jer su mi oni "primarni kljucevi" za studenta
	private ArrayList<String> spisakStudenata=new ArrayList<String>();
	
	public Predmet() {}
	public Predmet(String sifra, String naziv, Profesor predmetniProfesor, int semestar, int godinaStudija,
			ArrayList<String> spisakStudenata) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.predmetniProfesor = predmetniProfesor;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.spisakStudenata = spisakStudenata;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getSemestar() {
		return semestar;
	}

	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public ArrayList<String> getSpisakStudenata() {
		return spisakStudenata;
	}

	public void setSpisakStudenata(ArrayList<String> spisakStudenata) {
		this.spisakStudenata = spisakStudenata;
	}
	public int getBrojStudenata() {
		return this.spisakStudenata.size();
	}
}
