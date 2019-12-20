/**
 * 
 */
package view;

import javax.swing.JOptionPane;

import controller.ProfesorController;
import model.BazaProfesora;
import model.Profesor;

/**
 * @author Sladjana Savkovic
 *
 */
public class PretragaProfesora {
	
	String ime="";
	String prezime="";
	String datumRodjenja="";
	String adresaStanovanje="";
	String telefon="";
	String email="";
	String adresaKancelarije="";
	String brLicneKarte="";
	String titula="";
	String zvanje="";
	String[] brojeviLicne=new String[100]; //pamtim koji su brojevi licne karte profesora koji su nekad bili u bazi
	int brojac=0;
	
	public PretragaProfesora(String pretraga) {
		if(pretraga.equals(""))
			ResetPretrage();
		
		boolean rezultatPretrage = pretrazi(pretraga);
		if(rezultatPretrage == false && !pretraga.equals(""))
			JOptionPane.showMessageDialog(null, "Pogresan unos za pretragu!","Greška",JOptionPane.ERROR_MESSAGE);
		
		modifikujBazuProfesora();
	}
	public boolean pretrazi(String pretraga) {

		String[] podaci=new String[10];
		podaci=pretraga.split(";");
			
		for(int i=0;i<podaci.length;i++) {
			String[] pom = new String[2];
			pom=podaci[i].split(":");
				
			if(pom[0].toUpperCase().equals("IME") && (pom.length > 1))
				ime=pom[1];
			else if(pom[0].toUpperCase().equals("PREZIME") && (pom.length > 1))
				prezime=pom[1];
			else if( (pom[0].toUpperCase().equals("DATUM ROĐENJA") || pom[0].toUpperCase().equals("DATUM RODJENJA")) && (pom.length > 1) )
				datumRodjenja=pom[1];
			else if(pom[0].toUpperCase().equals("ADRESA STANOVANJA") && (pom.length > 1))
				adresaStanovanje=pom[1];
			else if(pom[0].toUpperCase().equals("KONTAKT TELEFON") && (pom.length > 1))
				telefon=pom[1];
			else if(pom[0].toUpperCase().equals("E-MAIL ADRESA") && (pom.length > 1))
				email=pom[1];
			else if(pom[0].toUpperCase().equals("ADRESA KANCELARIJE") && (pom.length > 1))
				adresaKancelarije=pom[1];
			else if((pom[0].toUpperCase().equals("BROJ LIČNE KARTE") || pom[0].toUpperCase().equals("BROJ LICNE KARTE"))&& (pom.length > 1))
				brLicneKarte=pom[1];
			else if(pom[0].toUpperCase().equals("TITULA") && (pom.length > 1))
				titula=pom[1];
			else if(pom[0].toUpperCase().equals("ZVANJE") && (pom.length > 1))
				zvanje=pom[1];
			else {
				return false;
			}	
		}
		return true;
	}
	public void modifikujBazuProfesora() {
		int size=BazaProfesora.getInstance().getProfesori().size(); //Pocetna duzina,prije izmjene
		for(int i=0; i<size; i++) {
			Profesor p = BazaProfesora.getInstance().getProfesorIndex(i);
			boolean flag=true;
			for(int j=0; j<5; j++) {
				if(!ime.equals(p.getIme()) && !ime.equals("")) { 
					flag=false;
				}
				if(!prezime.equals(p.getPrezime()) && !prezime.equals("")) {
					flag=false;
				}
				if(datumRodjenja!=p.getDatumRodjenja() && !datumRodjenja.equals("")){
					flag=false;
				}
				if(adresaStanovanje!=p.getAdresaStanovanja()&& !adresaStanovanje.equals("")) {
					flag=false;
				}
				if(!telefon.equals(p.getTelefon()) && !telefon.equals("")) {
					flag=false;
				}
				if(!email.equals(p.getEmail()) && !email.equals("")) { 
					flag=false;
				}
				if(!adresaKancelarije.equals(p.getAdresaKancelarije()) && !adresaKancelarije.equals("")) {
					flag=false;
				}
				if(brLicneKarte!=p.getBrLicneKarte() && !brLicneKarte.equals("")){
					flag=false;
				}
				if(titula!=p.getTitula() && !titula.equals("")) {
					flag=false;
				}
				if(!zvanje.equals(p.getZvanje()) && !zvanje.equals("")) {
					flag=false;
				}
			}
			//Ako je flag postao false, znaci da nam vrijednost iz baze predmeta ne treba u bazi, pa je smjestam u pomocnu listu
			if(flag == false) {
				brojeviLicne[brojac++]=p.getBrLicneKarte();
			}
		}
		//Dodani predmet brisem iz baze ali ga trazim po sifri jer se indeksi mijenjaju usljed brisanja
		for(int k=0; k<brojac; k++) {
			int pozicija = BazaProfesora.getInstance().getIndexOfProfesor(brojeviLicne[k]);
			ProfesorController.getInstance().obrisiProfesora(pozicija);
		}
	}
	public void ResetPretrage() {
		//BazaProfesora.getInstance().readProfesoriFrom("data_files/profesori_pom.dat");
	}
}
