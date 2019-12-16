/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Sladjana Savkovic
 *
 */
public class Profesor {
	private String ime,prezime,datumRodjenja,adresaStanovanja,telefon,email,adresaKancelarije,brLicneKarte,titula,zvanje;
	//U ArrayList-i cuvam sifre predmeta jer su mi one "primarni kljuc" za svaki predmet
	private ArrayList<String> spisakPredmeta=new ArrayList<String>();
	
	public Profesor() {}
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanje,
			ArrayList<String> spisakPredmeta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.spisakPredmeta = spisakPredmeta;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public String getBrLicneKarte() {
		return brLicneKarte;
	}
	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public ArrayList<String> getSpisakPredmeta() {
		return spisakPredmeta;
	}
	public void setSpisakPredmeta(ArrayList<String> spisakPredmeta) {
		this.spisakPredmeta = spisakPredmeta;
	}
	public int getBrojPredmeta() {
		return this.spisakPredmeta.size();
	}
	
}
