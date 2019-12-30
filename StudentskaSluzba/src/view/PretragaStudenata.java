/**
 * 
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 * @author Dragana Carapic
 *
 */
public class PretragaStudenata {
	String ime;
	String prezime;
	String datumRodjenja;
	String adresaStanovanja;
	String brojTelefona;
	String emailAdresa;
	String brojIndeksa; 
	String datumUpisa;
	String status;
	
	public PretragaStudenata(String pretraga, TableRowSorter<AbstractTableModelStudent> sorter) {
		ime="";
		prezime="";
		datumRodjenja="";
		adresaStanovanja="";
		brojTelefona="";
		emailAdresa="";
		brojIndeksa="";
		datumUpisa="";
		status="";
		
		int rezPretrage = pretrazi(pretraga);
		
		if(rezPretrage == 0 && !pretraga.equals("")) {
			JOptionPane.showMessageDialog(null, "Pogresan unos za pretragu!","Greška",JOptionPane.ERROR_MESSAGE);
		}else {
			for(int i=0; i<rezPretrage; i++) {
				if(!ime.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(ime, 0));
				}else if(!prezime.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(prezime, 1));
				}else if(!datumRodjenja.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(datumRodjenja, 2));
				}else if(!adresaStanovanja.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(adresaStanovanja, 3));
				}else if(!brojTelefona.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(brojTelefona, 4));
				}else if(!emailAdresa.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(emailAdresa, 5));
				}else if(!brojIndeksa.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(brojIndeksa, 6));
				}else if(!datumUpisa.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(datumUpisa, 7));
				}else if(!status.equals("")) {
					sorter.setRowFilter(RowFilter.regexFilter(status, 10));
				}
			}
		}
	}
	
	public int pretrazi(String pretraga) {
		int brojac=0;
		
		String[] podaci = new String[10];
		podaci = pretraga.split(";");
		
		for(int i=0; i<podaci.length; i++) {
			String[] pom = new String[2];
			pom = podaci[i].split(":");
			
			if(pom[0].toUpperCase().equals("IME") && (pom.length > 1)) {
				ime = pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("PREZIME") && (pom.length > 1)) {
				prezime=pom[1];
				brojac++;
			}else if((pom[0].toUpperCase().equals("DATUM ROĐENJA") || pom[0].toUpperCase().equals("DATUM RODJENJA")) && (pom.length > 1) ) {
				datumRodjenja=pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("ADRESA STANOVANJA") && (pom.length > 1)) {
				adresaStanovanja=pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("BROJ TELEFONA") && (pom.length > 1)) {
				brojTelefona=pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("E-MAIL ADRESA") && (pom.length > 1)) {
				emailAdresa=pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("BROJ INDEKSA") && (pom.length > 1)) {
				brojIndeksa=pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("DATUM UPISA") && (pom.length > 1)) {
				datumUpisa=pom[1];
				brojac++;
			}else if(pom[0].toUpperCase().equals("STATUS") && (pom.length > 1)) {
				status = pom[1];
				brojac++;
			}
		}
		return brojac;
	}
}
