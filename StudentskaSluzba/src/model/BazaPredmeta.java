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
	
	//samo da ubacim neke podatke za pocetak
	private ArrayList<Predmet> predmeti;
	//private ArrayList<String> studenti;
	//private ArrayList<String> studenti1;
	
	
	public BazaPredmeta() {
		readPredmeti();
		//initPredmete();
		//writePredmeti();
	}
	/*public void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		this.studenti = new ArrayList<String>();
		this.studenti1= new ArrayList<String>();
		studenti.add("RA1/2017");
		studenti.add("RA78/2015");
		studenti.add("RA25/2016");
		studenti1.add("PSI14/2017");
		studenti1.add("E3154/2015");
		studenti1.add("MEH215/2016");
		predmeti.add(new Predmet("E2123","Matematička analiza 1", "Nebojša Ralević", 1, 1, studenti));
		predmeti.add(new Predmet("E2485", "Arhitektura računara", "Miroslav Hajduković", 2, 1, studenti));
		predmeti.add(new Predmet("E2458", "Fizika", "Ljuba Budinski", 2, 1, studenti1));
		predmeti.add(new Predmet("E1042", "Mehanika", "Ljuba Budinski", 1, 1, studenti1));
		predmeti.add(new Predmet("MA750", "Algebra", "Nebojša Ralević", 1, 1, studenti1));
		predmeti.add(new Predmet("II802", "Operativni sistemi", "Miroslav Hajduković", 2, 2, studenti1));
		
	}*/
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
			return predmet.getPredmetniProfesor();
		case 5:
			return Integer.toString(predmet.getBrojStudenata());
		default:
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	private void writePredmeti(){
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
	public void writePredmetiIn(String f){
		try {
			ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream(f)));
			out.writeObject(predmeti);
		    out.close();
		} catch (IOException e) {
		      e.printStackTrace();
	    }
	}
	@SuppressWarnings("unchecked")
	public void readPredmetiFrom(String f){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
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
			break;
		}
		return false;
	}

	@Override
	public String toString() {
		return "BazaPredmeta [predmeti=" + predmeti + "]";
	}
}
