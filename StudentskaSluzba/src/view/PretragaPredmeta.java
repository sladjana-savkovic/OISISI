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
public class PretragaPredmeta{

	String sifra;
	String naziv;
	String predmetniProfesor;
	
	public PretragaPredmeta(String pretraga,TableRowSorter<AbstractTableModelPredmet> sorter) {
		
		sifra="";
		naziv="";
		predmetniProfesor="";
		
		int rezultatPretrage = pretrazi(pretraga);
		//Ako uneseni podaci nisu dobri,tj ne postoji ni jedan naziv polja po kojem bi se pretraga izvrsila
		if(rezultatPretrage == 0 && !pretraga.equals("")) {
			JOptionPane.showMessageDialog(null, "Pogresan unos za pretragu!","Greška",JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(int i=0;i<rezultatPretrage;i++) {
				if(!sifra.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(sifra,0));
				else if(!naziv.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(naziv,1));
				else if(!predmetniProfesor.equals(""))
					sorter.setRowFilter(RowFilter.regexFilter(predmetniProfesor,4));
			}
		}		
	}
	public int pretrazi(String pretraga) {
		int brojac=0; //brojac koji cuva informaciju koliko podataka za pretragu je korisnik unio
		
		String[] podaci=new String[3];
		podaci=pretraga.split(";");
			
		for(int i=0;i<podaci.length;i++) {
			String[] pom = new String[2];
			pom=podaci[i].split(":");
				
			if((pom[0].toUpperCase().equals("ŠIFRA") || (pom[0].toUpperCase().equals("SIFRA"))) && (pom.length > 1)) {
				sifra=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("NAZIV") && (pom.length > 1)) {
				naziv=pom[1];
				brojac++;
			}
			else if(pom[0].toUpperCase().equals("PROFESOR") && (pom.length > 1)) {
				predmetniProfesor=pom[1];
				brojac++;
			}
		}
		return brojac;
	}	
}
