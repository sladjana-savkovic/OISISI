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
	private JPanel basicPanel;
	
	MyTab(String name) {
		this.tabName=name;
		this.setLayout(new BorderLayout());
		this.basicPanel = new JPanel();
		createTable();
	}
	public void createTable() {
		if(tabName.equals("Studenti")) {
			/*basicPanel.add(new JLabel("Test " + this.tabName));
			this.add(basicPanel, BorderLayout.NORTH);*/
			
			StudentJTable tabelaStudenata = new StudentJTable();

			JScrollPane scrollPane = new JScrollPane(tabelaStudenata);
			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
		}
		else if(tabName.equals("Profesori")) {
			ProfesorJTable tabelaProfesora = new ProfesorJTable();

			JScrollPane scrollPane = new JScrollPane(tabelaProfesora);
			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
		}
		else {			
			PredmetJTable tabelaPredmeta = new PredmetJTable();

			JScrollPane scrollPane = new JScrollPane(tabelaPredmeta);
			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
		}
	}
}
