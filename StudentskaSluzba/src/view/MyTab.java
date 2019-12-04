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
	
	/**
	 * 
	 */
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
			basicPanel.add(new JLabel("Test " + this.tabName));
			this.add(basicPanel, BorderLayout.NORTH);
		}
		else if(tabName.equals("Profesori")) {
			basicPanel.add(new JLabel("Test " + this.tabName));
			this.add(basicPanel, BorderLayout.NORTH);
		}
		else {
			basicPanel.add(new JLabel("Test " + this.tabName));
			this.add(basicPanel, BorderLayout.NORTH);
		}
	}
}
