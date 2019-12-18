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
	
	private static final long serialVersionUID = 1L;
	private String tabName;
	static private StudentJTable tabelaStudenata = new StudentJTable();
	static private ProfesorJTable tabelaProfesora = new ProfesorJTable();
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
			/*basicPanel.add(new JLabel("Test " + this.tabName));
			this.add(basicPanel, BorderLayout.NORTH);*/
			
			//StudentJTable tabelaStudenata = new StudentJTable();

			JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
		}
		else if(tabName.equals("Profesori")) {
			//ProfesorJTable tabelaProfesora = new ProfesorJTable();

			JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
			add(scrollPane, BorderLayout.CENTER);
			
			azurirajPrikaz();
			
			setVisible(true);
		}
		else {			
			//PredmetJTable tabelaPredmeta = new PredmetJTable();

			JScrollPane scrollPane = new JScrollPane(tabelaPredmeta);
			add(scrollPane, BorderLayout.CENTER);
			
			azurirajPrikaz();
			
			setVisible(true);
		}
	}
	static public void azurirajPrikaz() {
		
		modelProfesor.fireTableDataChanged();
		modelProfesor.fireTableDataChanged();
		modelPredmet.fireTableDataChanged();
		
	}
}
