/**
 * 
 */
package model;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Sladjana Savkovic
 *
 */
public class BazaPredmeta implements Serializable{
	
	private static final long serialVersionUID = 8628871629589964560L;
	
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private ArrayList<Predmet> predmeti;
	
	private BazaPredmeta() {  
		readPredmeti();
	}
	
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	public Predmet getPredmetIndex(int index) {
		return this.predmeti.get(index);
	}
	public int getIndexOfPredmet(String sifra) {
		for(int i=0;i<predmeti.size();i++) {
			Predmet p=predmeti.get(i);
			if (p.getSifra().equals(sifra))
				return i;
		}
		return -1;
	}
	public String getValueAt(int row, int column) {
		Predmet predmet=this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return Integer.toString(predmet.getGodinaStudija());
		case 3:
			return Integer.toString(predmet.getSemestar());
		case 4:
			if(predmet.getPredmetniProfesor() != null)
				return "\""+predmet.getPredmetniProfesor().getBrLicneKarte()+"\", "
					+predmet.getPredmetniProfesor().getIme()+" "+predmet.getPredmetniProfesor().getPrezime(); 
			else
				return null;
		case 5:
			return Integer.toString(predmet.getBrojStudenata());
		default:
			return null;
		}
	}
	
	public void writePredmeti(){
		try {
			ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("data_files/predmeti.dat")));
			out.writeObject(predmeti);
		    out.close();
		} catch (IOException e) {
		      e.printStackTrace();
	    }
	}
	@SuppressWarnings("unchecked")
	public void readPredmeti(){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data_files/predmeti.dat"));
			predmeti = (ArrayList<Predmet>) in.readObject();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	public void obrisiPredmet(String sifPredmeta) {
		for (Predmet p : predmeti) {
			if (p.getSifra().equals(sifPredmeta)) {
				predmeti.remove(p);
				break;
			}
		}
	}
	public boolean dodajPredmet(Predmet p) {
		for(Predmet pr : predmeti) {
			if(!(pr.getSifra().equals(p.getSifra()))) {
				predmeti.add(p);
				return true;
			}
		}
		return false;
	}
	public Predmet getPredmet(String sifraPredmeta) {
		for(Predmet p : predmeti) {
			if(p.getSifra().equals(sifraPredmeta)) {
				return p;
			}
		}
		return null;
	}
	
	public void obrisiStudenta(String sifraPredmeta,int indeksStudentaListe) {
		Predmet p = getPredmet(sifraPredmeta);
		if(p != null) {
			p.getSpisakStudenata().remove(indeksStudentaListe);
		}else {
			return;
		}
	}
	public ArrayList<String> spisakStudenataNaPredmetu(int index){
		ArrayList<String> spisakStudenata = getPredmetIndex(index).getSpisakStudenata();
		return spisakStudenata;
	}
	public void izmijeniPredmet(Predmet predmet, Predmet t) {
		for(Predmet p : predmeti) {
			if(predmet.getSifra().equals(p.getSifra())) {
				if(!(t.getSifra().equals(p.getSifra()))) {
					p.setSifra(t.getSifra());
				}
				p.setNaziv(t.getNaziv());
				p.setPredmetniProfesor(t.getPredmetniProfesor());
				p.setSemestar(t.getSemestar());
				p.setGodinaStudija(t.getGodinaStudija());
			}
		}
	}
	public void profesorNaPredmet(String licnaKarta,int index) {
		Predmet predmet = getPredmetIndex(index);
		Profesor profesor = BazaProfesora.getInstance().getProfesor(licnaKarta);
		
		//Pronalazim broj licne karte profesora koji je nekad predavao predmet, ako takav postoji
		String stariProfesor;
		
		if(predmet.getPredmetniProfesor() != null) {
			stariProfesor = predmet.getPredmetniProfesor().getBrLicneKarte();
		} else {
			stariProfesor = "";
		}
						
		//Ako smo nasli profesora, brisem iz njegove liste predmeta, onaj predmet koji je nekad predavao
		if(!stariProfesor.equals("")) {
			BazaProfesora.getInstance().getProfesor(stariProfesor).getSpisakPredmeta().remove(predmet.getSifra());
		}
		
		predmet.setPredmetniProfesor(profesor);
		
		//Novom profesoru dodajem predmet u listu njegovih predmeta
		BazaProfesora.getInstance().getProfesor(licnaKarta).getSpisakPredmeta().add(predmet.getSifra());
	}
}
