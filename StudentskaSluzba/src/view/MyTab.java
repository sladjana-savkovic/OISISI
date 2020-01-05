/**
 * 
 */
package view;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * @author Sladjana Savkovic
 *
 */
public class MyTab extends JPanel{
	
	private static final long serialVersionUID = 6362644799363305766L;
	
	private String tabName;
	static private StudentJTable tabelaStudenata = new StudentJTable();
	static private ProfesorJTable tabelaProfesora = new ProfesorJTable();
	//static private ProfesorJTable tabelaProfesora = ProfesorJTable.getInstance();
	static private PredmetJTable tabelaPredmeta = new PredmetJTable();
	
	static public AbstractTableModelProfesor modelProfesor = (AbstractTableModelProfesor) tabelaProfesora.getModel();
	static public AbstractTableModelPredmet modelPredmet = (AbstractTableModelPredmet) tabelaPredmeta.getModel();
	static public AbstractTableModelStudent modelStudent = (AbstractTableModelStudent) tabelaStudenata.getModel();
	
	MyTab(String name) {
		this.tabName=name;
		this.setLayout(new BorderLayout());
		createTable();
	}
	public void createTable() {
		if(tabName.equals("Studenti")) {
			JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
		}
		else if(tabName.equals("Profesori")) {
			JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
			add(scrollPane, BorderLayout.CENTER);
			
			azurirajPrikaz();
			
			setVisible(true);
		}
		else {			
			JScrollPane scrollPane = new JScrollPane(tabelaPredmeta);
			add(scrollPane, BorderLayout.CENTER);
			
			azurirajPrikaz();
			
			setVisible(true);			
		}
	}
	static public void azurirajPrikaz() {
		
		modelStudent.fireTableDataChanged();
		modelProfesor.fireTableDataChanged();
		modelPredmet.fireTableDataChanged();
		
	}
}
