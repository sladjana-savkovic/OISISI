/**
 * 
 */
package controller;

import model.BazaStudenata;
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
	
}
