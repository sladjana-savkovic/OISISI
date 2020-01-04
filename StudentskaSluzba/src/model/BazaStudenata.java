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
	/*private ArrayList<String> predmeti1;
	private ArrayList<String> predmeti2;
	private ArrayList<String> predmeti3;
	private ArrayList<String> predmeti4;
	private ArrayList<String> predmeti5;
	private ArrayList<String> predmeti6;*/
	
	private BazaStudenata() {
		readStudenti();
		//initStudent();
		//writeStudenti();
		
	}/*
	public void initStudent() {
		this.studenti = new ArrayList<Student>();
		this.predmeti1 = new ArrayList<String>();
		this.predmeti2 = new ArrayList<String>();
		this.predmeti3 = new ArrayList<String>();
		this.predmeti4 = new ArrayList<String>();
		this.predmeti5 = new ArrayList<String>();
		this.predmeti6 = new ArrayList<String>();
		
		predmeti1.add("E2123");
		predmeti1.add("E2485");
		predmeti2.add("E2458");
		predmeti2.add("E1042");
		predmeti2.add("MA750");
		predmeti2.add("II802");
		predmeti3.add("E1042");
		predmeti3.add("MA750");
		predmeti4.add("E2123");
		predmeti4.add("E2485");
		predmeti5.add("II802");
		predmeti5.add("E1042");
		predmeti5.add("MA750");
		predmeti6.add("E2123");
		predmeti6.add("II802");
		
		studenti.add(new Student("Ana","Mihić","13.05,1998.","Despota Stefana 8", "+38165987654", "anam@gmail.com", "RA1/2017","01.07.2017",3,9.42,statusStudenta.B,predmeti1));
		studenti.add(new Student("Miloš","Lukić","31.12,1996.","Cara Dušana 91", "+38169981132", "milos996@gmail.com", "RA78/2015","03.07.2015",3,7.56,statusStudenta.S,predmeti2));
		studenti.add(new Student("Tijana","Marić","18.10,1997.","Šekspirova 84", "+38162001882", "mtijana1997@gmail.com", "RA25/2016","10.09.2015",4,7.02,statusStudenta.B,predmeti3));
		studenti.add(new Student("Igor","Trivalić","10.03,1998.","Cara Lazara 3", "+38163335789", "igort98@gmail.com", "PSI14/2017","10.07.2017",3,9.50,statusStudenta.B,predmeti4));
		studenti.add(new Student("Aleksa","Tadić","11.08,1996.","Stražilovska 10", "+38165130065", "talek996@gmail.com", "E3154/2015","01.07.2015",3,6.98,statusStudenta.S,predmeti5));
		studenti.add(new Student("Milica","Sarić","10.02,1996.","Maksima Gorkog 23", "+38163133099", "milicas96@gmail.com", "MEH215/2016","04.07.2016",4,8.76,statusStudenta.B,predmeti6));
	
	}*/
	
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
	
	@SuppressWarnings("unused")
	private void writeStudenti(){
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

	
}
