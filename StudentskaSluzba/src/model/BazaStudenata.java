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
 * @author Dragana Carapic
 *
 */
public class BazaStudenata implements Serializable{

	private static final long serialVersionUID = -2220866782731925699L;
	
	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if(instance==null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private ArrayList<Student> studenti;
	
	private BazaStudenata() {
		readStudenti();
	}
	
	public ArrayList<Student> getStudenti(){
		return studenti;
	}
	
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	public Student getStudentIndex(int index) {
		return this.studenti.get(index);
	}
	
	public String getValueAt(int row, int column) {
		Student student=this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getIme();
		case 1:
			return student.getPrezime();
		case 2:
			return student.getDatumRodjenja();
		case 3:
			return student.getAdresaStanovanja();
		case 4:
			return student.getBrojTelefona();
		case 5:
			return student.getEmailAdresa();
		case 6:
			return student.getBrojIndeka();
		case 7:
			return student.getDatumUpisa();
		case 8:
			return Integer.toString(student.getTrenutnaGodinaStudija());
		case 9:
			return Double.toString(student.getProsjecnaOcjena());
		case 10:
			return student.getStatus().name();
		case 11:
			return Integer.toString(student.getBrojPredmeta());
		default:
			return null;
		}
	}
	
	public void writeStudenti(){
		try {
			ObjectOutputStream out = new ObjectOutputStream((new FileOutputStream("data_files/studenti.dat")));
			out.writeObject(studenti);
		    out.close();
		} catch (IOException e) {
		      e.printStackTrace();
	    }
	}

	@SuppressWarnings("unchecked")
	private void readStudenti(){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("data_files/studenti.dat"));
			studenti = (ArrayList<Student>) in.readObject();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void obrisiStudenta(String brojIndeksa) {
		for (Student s : studenti) {
			if (s.getBrojIndeka().equals(brojIndeksa)) {
				studenti.remove(s);
				break;
			}
		}
	}
	
	public boolean dodajStudenta(Student t) {
		for(Student s : studenti) {
			if(!(s.getBrojIndeka().equals(t.getBrojIndeka()))) {
				studenti.add(t);
				return true;
			}
			break;
		}
		return false;
	}
	
	
	public void izmjeniStudenta(Student student, Student t) {
		for(Student s : studenti) {
			
				if(student.getBrojIndeka().equals(s.getBrojIndeka())) {
					if(!(t.getBrojIndeka().equals(s.getBrojIndeka()))) {
						s.setBrojIndeka(t.getBrojIndeka());
					}
				s.setIme(t.getIme());
				s.setPrezime(t.getPrezime());
				s.setDatumRodjenja(t.getDatumRodjenja());
				s.setAdresaStanovanja(t.getAdresaStanovanja());
				s.setBrojTelefona(t.getBrojTelefona());
				s.setEmailAdresa(t.getEmailAdresa());
				s.setDatumUpisa(t.getDatumUpisa());
				s.setTrenutnaGodinaStudija(t.getTrenutnaGodinaStudija());
				s.setProsjecnaOcjena(t.getProsjecnaOcjena());
				s.setStatus(t.getStatus()); 
				}
		}
	}
	
	public Student getStudent(String indeks) {
		for(Student s : studenti) {
			if(s.getBrojIndeka().equals(indeks)) {
				return s;
			}
		}
		return null;
	}
	
	public void obrisiPredmet(String indeksStudenta, int indeksPredmetaListe) {
		Student s = getStudent(indeksStudenta);
			if(s != null) {
				s.getSpisakPredmeta().remove(indeksPredmetaListe);
			}else {
				return;
			}
	}

	@Override
	public String toString() {
		return "BazaStudenata [studenti=" + studenti + "]";
	}

	public ArrayList<String> spisakPredmetaStudenata(int index){
		ArrayList<String> spisak = getStudentIndex(index).getSpisakPredmeta();
		return spisak;
	}

	public ArrayList<String> spisakPredmetaPoIndeksu(String indeks){
		ArrayList<String> spisak=null;
		for(int i=0; i<getStudenti().size(); i++) {
		if(getStudenti().get(i).getBrojIndeka().equals(indeks)) {
			spisak = getStudenti().get(i).getSpisakPredmeta();
		}
		}
		return spisak;
	}
	
}
