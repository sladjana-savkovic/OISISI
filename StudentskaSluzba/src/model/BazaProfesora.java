/**
 * 
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Sladjana Savkovic
 *
 */
public class BazaProfesora implements Serializable{
	
	private static final long serialVersionUID = -1577699150536258996L;
	
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	//samo da ubacim neke podatke za pocetak
	private ArrayList<Profesor> profesori;
	/*private ArrayList<String> predmeti1;
	private ArrayList<String> predmeti2;
	private ArrayList<String> predmeti3;*/
	
	public BazaProfesora() {
		readProfesori();
		//initProfesore();
		//writeProfesori();
	}
	/*public void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		this.predmeti1 = new ArrayList<String>();
		this.predmeti2 = new ArrayList<String>();
		this.predmeti3 = new ArrayList<String>();
		predmeti1.add("E2123");
		predmeti1.add("MA750");
		predmeti2.add("E2485");
		predmeti2.add("II802");
		predmeti3.add("E2458");
		predmeti3.add("E1042");
		profesori.add(new Profesor("Nebojša","Ralević","23.08.1965.","Ćirpanova 25","062/782-41-02","rale65@gmail.com",
				"Trg Dositeja Obradovića 10","124kl789","doktor","redovni prof.",predmeti1));
		profesori.add(new Profesor("Miroslav","Hajduković","17.11.1983.","Narodnog fronta 105","062/581-00-72","miroslav.hajdukovic@1981@gmail.com",
				"Trg Dositeja Obradovića 10","581af102","doktor","vanredni prof.",predmeti2));
		profesori.add(new Profesor("Ljuba","Budinski","01.12.1959.","Bulevar oslobodjenja 108a","063/250-78-44","ljuba.budinski59@gmail.com",
				"Trg Dositeja Obradovića 10","102af188","doktor","redovni prof.",predmeti3));
	}*/
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	public Profesor getProfesorIndex(int index) {
		return this.profesori.get(index);
	}
	public int getIndexOfProfesor(String licnaKarta) {
		for(int i=0;i<profesori.size();i++) {
			Profesor p=profesori.get(i);
			if (p.getBrLicneKarte().equals(licnaKarta))
				return i;
		}
		return -1;
	}
	public String getValueAt(int row, int column) {
		Profesor profesor=this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getDatumRodjenja();
		case 3:
			return profesor.getAdresaStanovanja();
		case 4:
			return profesor.getTelefon();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		case 10:
			return Integer.toString(profesor.getBrojPredmeta());
		default:
			return null;
		}
	}
	public void writeProfesori(){
		try {
			ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("data_files/profesori.dat")));
			out.writeObject(profesori);
		    out.close();
		} catch (IOException e) {
		      e.printStackTrace();
	    }
	}
	@SuppressWarnings("unchecked")
	private void readProfesori(){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data_files/profesori.dat"));
			profesori = (ArrayList<Profesor>) in.readObject();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	public void obrisiProfesora(String brLicneKarte) {
		for (Profesor p : profesori) {
			if (p.getBrLicneKarte().equals(brLicneKarte)) {
				profesori.remove(p);
				break;
			}
		}
	}
	public boolean dodajProfesora(Profesor p) {
		for(Profesor pr : profesori) {
			if(!(pr.getBrLicneKarte().equals(p.getBrLicneKarte()))) {
				profesori.add(p);
				return true;
			}
			break;
		}
		return false;
	}
	@Override
	public String toString() {
		return "BazaProfesora [profesori=" + profesori + "]";
	}
	
	public Profesor getProfesor(String licnaKartaProfesora) {
		for(Profesor p : profesori) {
			if(p.getBrLicneKarte().equals(licnaKartaProfesora)) {
				return p;
			}
		}
		return null;
	}
	public void obrisiPredmet(String licnaKartaProfesora,int indeksPredmetaListe) {
		Profesor p = getProfesor(licnaKartaProfesora);
		if(p != null) {
			p.getSpisakPredmeta().remove(indeksPredmetaListe);
		}else {
			return;
		}
	}
	public ArrayList<String> spisakPredmetaProfesora(int index){
		ArrayList<String> spisakPredmeta = getProfesorIndex(index).getSpisakPredmeta();
		return spisakPredmeta;
	}
	public void izmjeniProfesora(Profesor profesor, Profesor t) {
		for(Profesor p : profesori) {
			
			if(profesor.getBrLicneKarte().equals(p.getBrLicneKarte())) {
				if(!(t.getBrLicneKarte().equals(p.getBrLicneKarte()))) {
					p.setBrLicneKarte(t.getBrLicneKarte());
				}
				p.setIme(t.getIme());
				p.setPrezime(t.getPrezime());
				p.setDatumRodjenja(t.getDatumRodjenja());
				p.setAdresaStanovanja(t.getAdresaStanovanja());
				p.setTelefon(t.getTelefon());
				p.setEmail(t.getEmail());
				p.setAdresaKancelarije(t.getAdresaKancelarije());
				p.setTitula(t.getTitula());
				p.setZvanje(t.getZvanje());
			}
		}
	}
}
