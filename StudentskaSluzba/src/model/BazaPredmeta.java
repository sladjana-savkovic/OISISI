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
	
	private static final long serialVersionUID = 1L;
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	//samo da ubacim neke podatke za pocetak
	private ArrayList<Predmet> predmeti;
	private ArrayList<String> studenti;
	
	
	public BazaPredmeta() {
		initPredmete();
		writePredmeti();
	}
	public void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		this.studenti = new ArrayList<String>();
		studenti.add("RA1/2017");
		studenti.add("RA78/2015");
		studenti.add("RA25/2016");
		predmeti.add(new Predmet("E2123","Matematička analiza 1", "Nebojša Ralevic", 1, 1, studenti));
		predmeti.add(new Predmet("E2485", "Arhitektura racunara", "Miroslav Hajduković", 2, 1, studenti));
		predmeti.add(new Predmet("E2458", "Fizika", "Ljuba Budinski", 2, 1, studenti));
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
	
	private void writePredmeti(){
		try {
			File f=new File("predmeti.dat");
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			out.writeObject(predmeti);
		    out.close();
		} catch (Exception e) {
		      e.printStackTrace();
	    }
	}
	private void readPredmeti(){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("predmeti.dat"));
			Object obj;
			while((obj = in.readObject()) != null) {
				predmeti.add((Predmet)obj);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
