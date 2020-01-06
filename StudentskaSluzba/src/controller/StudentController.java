/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import view.MyTab;

/**
 * @author Dragana Carapic
 *
 */
public class StudentController {
	
	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public void obrisiStudent(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Student student = BazaStudenata.getInstance().getStudentIndex(rowSelectedIndex);
    	BazaStudenata.getInstance().obrisiStudenta(student.getBrojIndeka());
    	MyTab.azurirajPrikaz();
    	
	}
	public boolean dodajStudenta(Student t) {
		if(!(BazaStudenata.getInstance().dodajStudenta(t))) {
			return false;
		}
    	MyTab.azurirajPrikaz();
		return true;
	}
	
	public Student vratiSelektovanogStudenta(int rowSelectedIndex) {
		Student s =null;
		if(rowSelectedIndex<0) {
			return s;
		}
		s = BazaStudenata.getInstance().getStudentIndex(rowSelectedIndex);
		return s;
	}
	
	//izmjena
	public boolean izmjeniStudenta(int rowSelectedIndex, Student student, Student t) {
		if(rowSelectedIndex < 0) {
			return false;
		}
		
		if(student.getBrojIndeka().equals(t.getBrojIndeka())){
			BazaStudenata.getInstance().izmjeniStudenta(student, t);
			MyTab.azurirajPrikaz();
			return true;
		}else {
			 //nova metosa koja provjerava da li postoji st sa tim br indeksa ako postoji(vrati true) ret, a ako ne opet pozovi izmjenu
			if(BazaStudenata.getInstance().getStudent(t.getBrojIndeka())!=null) {
				return false;
			}else {
				BazaStudenata.getInstance().izmjeniStudenta(student, t);
				MyTab.azurirajPrikaz();
				return true;
			}
		}
	}
	
	public void obrisiPredmetStudenta(int tableSelectedIndex,int listSelectedIndex) {
		Student student = BazaStudenata.getInstance().getStudentIndex(tableSelectedIndex);
		
		if(listSelectedIndex != -1) {
			BazaStudenata.getInstance().obrisiPredmet(student.getBrojIndeka(), listSelectedIndex);
		}else {
			return;
		}
	}
	
	public ArrayList<String> predmetiStudenata(int row){
		ArrayList<String> predmeti = new ArrayList<String>();
			if(BazaStudenata.getInstance().spisakPredmetaStudenata(row) != null) {
				predmeti = BazaStudenata.getInstance().spisakPredmetaStudenata(row);
				
				return predmeti;
			}
			return null;
	}
	
	public ArrayList<Student> sviStudenti(){
		return BazaStudenata.getInstance().getStudenti();
	}
	
	public void dodajPredmetStudentu(String indeks, String sifraPredmeta) {
		BazaStudenata.getInstance().spisakPredmetaPoIndeksu(indeks).add(sifraPredmeta);
		MyTab.azurirajPrikaz();
	}
	
	public void uklanjanjePredmetaIzListe(int row) {
		
		Predmet p = BazaPredmeta.getInstance().getPredmetIndex(row);
		
		int indeksStudent=-1;
		int indeksPredmet=-1;
		
		for(int i=0; i<BazaStudenata.getInstance().getStudenti().size(); i++) {
			for(int j=0; j<BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().size(); j++)
				if(BazaStudenata.getInstance().getStudenti().get(i).getSpisakPredmeta().get(j).equals(p.getSifra())) {
					indeksStudent=i;
					indeksPredmet=j;
					break;
				}
		}
		
		if(indeksStudent!=-1 && indeksPredmet!=-1) {
			obrisiPredmetStudenta(indeksStudent, indeksPredmet);
		}
		
	}

	
}
