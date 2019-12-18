/**
 * 
 */
package view;

import java.util.ArrayList;

import controller.PredmetController;
import model.BazaPredmeta;
import model.Predmet;

/**
 * @author Sladjana Savkovic
 *
 */
public class PretragaPredmeta {
	
	String sifra="";
	String naziv="";
	String predmetniProfesor="";
	int semestar=0;
	int godinaStudija=0;
	//ArrayList<Predmet> lista; //Lista u kojoj ce se nalaziti svi koji nisu ukljuceni u pretragu
	String[] sifre=new String[100]; //pamtim na kojim indeksima u listi su nekad bili predmeti koji su u listi
	int brojac=0;
	
	public PretragaPredmeta(String pretraga) {
		if(pretraga.equals(""))
			ResetPretrage();
		
		//lista = new ArrayList<Predmet>();
		String[] podaci=new String[5];
		podaci=pretraga.split(";");
		
		for(int i=0;i<podaci.length;i++) {
			String[] pom = new String[2];
			pom=podaci[i].split(":");
			if(pom[0].toUpperCase().equals("ŠIFRA") || (pom[0].toUpperCase().equals("SIFRA")))
					sifra=pom[1];
			else if(pom[0].toUpperCase().equals("NAZIV"))
				naziv=pom[1];
			else if(pom[0].toUpperCase().equals("GODINA"))
				godinaStudija=Integer.parseInt(pom[1]);
			else if(pom[0].toUpperCase().equals("SEMESTAR"))
				semestar=Integer.parseInt(pom[1]);
			else if(pom[0].toUpperCase().equals("PROFESOR"))
				predmetniProfesor=pom[1];
		}
		modifikujBazuPredmeta();
	}
	public void modifikujBazuPredmeta() {
		int size=BazaPredmeta.getInstance().getPredmeti().size(); //Pocetna duzina,prije izmjene
		for(int i=0; i<size; i++) {
			//System.out.println(i);
			Predmet p = BazaPredmeta.getInstance().getPredmetIndex(i);
			boolean flag=true;
			for(int j=0; j<5; j++) {
				if(!sifra.equals(p.getSifra()) && !sifra.equals("")) { //BACA GRESKU AKO UNESEM NESTO KAO Sifra:
					flag=false;
				}
				if(!naziv.equals(p.getNaziv()) && !naziv.equals("")) {
					flag=false;
				}
				if(godinaStudija!=p.getGodinaStudija() && godinaStudija!=0)	{
					flag=false;
				}
				if(semestar!=p.getSemestar() && semestar!=0) {
					flag=false;
				}
				if(!predmetniProfesor.equals(p.getPredmetniProfesor()) && !predmetniProfesor.equals("")) {
					flag=false;
				}
			}
			//Ako je flag postao false, znaci da nam vrijednost iz baze predmeta ne treba u bazi, pa je smjestam u pomocnu listu
			if(flag == false) {
				//lista.add(p);
				sifre[brojac++]=p.getSifra();
			}
		}
		//Dodani predmet brisem iz baze ali ga trazim po sifri jer se indeksi mijenjaju usljed brisanja
		for(int k=0; k<brojac; k++) {
			int pozicija = BazaPredmeta.getInstance().getIndexOfPredmet(sifre[k]);
			PredmetController.getInstance().obrisiPredmet(pozicija);
		}
	}
	public void ResetPretrage() {
		BazaPredmeta.getInstance().readPredmeti();
	}
}
