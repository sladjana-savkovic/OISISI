package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Dragana Carapic
 *
 */
public class Student implements Serializable{

	private static final long serialVersionUID = 4142896913368939462L;

	public enum statusStudenta{
		B,S
	}
	
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresaStanovanja;
	private String BrojTelefona;
	private String emailAdresa;
	private String brojIndeka;
	private String datumUpisa;
	private String trenutnaGodinaStudija;
	private double prosjecnaOcjena;
	private statusStudenta status;
	private ArrayList<String> spisakPredmeta=new ArrayList<String>();
	
	public Student(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String brojTelefona,
			String emailAdresa, String brojIndeka, String datumUpisa, String trenutnaGodinaStudija,
			double prosjecnaOcjena, statusStudenta status, ArrayList<String> spisakPredmeta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.BrojTelefona = brojTelefona;
		this.emailAdresa = emailAdresa;
		this.brojIndeka = brojIndeka;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.prosjecnaOcjena = prosjecnaOcjena;
		this.status = status;
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

	public String getBrojTelefona() {
		return BrojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		BrojTelefona = brojTelefona;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getBrojIndeka() {
		return brojIndeka;
	}

	public void setBrojIndeka(String brojIndeka) {
		this.brojIndeka = brojIndeka;
	}

	public String getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(String trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public double getProsjecnaOcjena() {
		return prosjecnaOcjena;
	}

	public void setProsjecnaOcjena(double prosjecnaOcjena) {
		this.prosjecnaOcjena = prosjecnaOcjena;
	}
	
	public statusStudenta getStatus() {
		return status;
	}

	public void setStatus(statusStudenta status) {
		this.status = status;
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
