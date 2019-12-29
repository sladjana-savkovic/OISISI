/**
 * 
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 * @author Sladjana Savkovic
 *
 */
public class PretragaProfesora {
	
	String ime;
	String prezime;
	String datumRodjenja;
	String adresaStanovanje;
	String telefon;
	String email;
	String adresaKancelarije;
	String brLicneKarte;
	String titula;
	String zvanje;
	
	public PretragaProfesora(String pretraga,TableRowSorter<AbstractTableModelProfesor> sorter) {
		
		ime="";
		prezime="";
		datumRodjenja="";
		adresaStanovanje="";
		telefon="";
		email="";
		adresaKancelarije="";
		brLicneKarte="";
		titula="";
		zvanje="";
		
		int rezultatPretrage = pretrazi(pretraga);
		
		if(rezultatPretrage == 0 && !pretraga.equals("")) {
			JOptionPane.showMessageDialog(null, "Pogresan unos za pretragu!","Greška",JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int i=0;i<rezultatPretrage;i++) {
				if(!ime.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(ime,0));
				else if(!prezime.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(prezime,1));
				else if(!datumRodjenja.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(datumRodjenja,2));
				else if(!adresaStanovanje.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(adresaStanovanje,3));
				else if(!telefon.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(telefon,4));
				else if(!email.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(email,5));
				else if(!adresaKancelarije.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(adresaKancelarije,6));
				else if(!brLicneKarte.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(brLicneKarte,7));
				else if(!titula.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(titula,8));
				else if(!zvanje.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(zvanje,9));
			}
		}
		
	}
	public int pretrazi(String pretraga) {
		int brojac = 0;

		String[] podaci=new String[10];
		podaci=pretraga.split(";");
			
		for(int i=0;i<podaci.length;i++) {
			
			String[] pom = new String[2];
			pom=podaci[i].split(":");
				
			if(pom[0].toUpperCase().equals("IME") && (pom.length > 1)) {
				ime=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("PREZIME") && (pom.length > 1)) {
				prezime=pom[1];
				brojac++;
			}
			else if( (pom[0].toUpperCase().equals("DATUM ROĐENJA") || pom[0].toUpperCase().equals("DATUM RODJENJA")) && (pom.length > 1) ) {
				datumRodjenja=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("ADRESA STANOVANJA") && (pom.length > 1)) {
				adresaStanovanje=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("KONTAKT TELEFON") && (pom.length > 1)) {
				telefon=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("E-MAIL ADRESA") && (pom.length > 1)) {
				email=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("ADRESA KANCELARIJE") && (pom.length > 1)) {
				adresaKancelarije=pom[1];
				brojac++;
			}
			else if((pom[0].toUpperCase().equals("BROJ LIČNE KARTE") || pom[0].toUpperCase().equals("BROJ LICNE KARTE"))&& (pom.length > 1)) {
				brLicneKarte=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("TITULA") && (pom.length > 1)) {
				titula=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("ZVANJE") && (pom.length > 1)) {
				zvanje=pom[1];	
				brojac++;
			}
		}
		return brojac;
	}
}
