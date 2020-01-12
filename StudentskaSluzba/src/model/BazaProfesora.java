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
	
	private ArrayList<Profesor> profesori;
	
	public BazaProfesora() {
		readProfesori();
	}
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
			return "\""+profesor.getBrLicneKarte()+"\"";
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
	public void izmijeniProfesora(Profesor profesor, Profesor t) {
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
