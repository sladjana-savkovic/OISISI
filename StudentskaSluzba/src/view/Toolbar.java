/**
 * 
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Sladjana Savkovic
 *
 */
public class Toolbar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Toolbar() {
		// u konstruktor natklase, JToolbar prosledjujemo orijentaciju toolbar-a
		super(SwingConstants.HORIZONTAL);
		Color lightBlue= new Color(160,215,255);
		Color darkBlue= new Color(0,200,200);
		
		JButton buttonAdd = new JButton();
		buttonAdd.setToolTipText("Dodaj(CTRL+A)");
		buttonAdd.setIcon(new ImageIcon("logo_images/plus.jpg"));
		buttonAdd.setMnemonic(KeyEvent.VK_A);
		buttonAdd.setBackground(lightBlue);
		add(buttonAdd);
		
		JButton buttonModify = new JButton();
		buttonModify.setToolTipText("Izmijeni(CTRL+M)");
		buttonModify.setIcon(new ImageIcon("logo_images/pencil.jpg"));
		buttonAdd.setMnemonic(KeyEvent.VK_M);
		buttonModify.setBackground(lightBlue);
		add(buttonModify);
		
		JButton buttonDelete = new JButton();
		buttonDelete.setToolTipText("Obrisi(CTRL+D)");
		buttonDelete.setIcon(new ImageIcon("logo_images/delete.jpg"));
		buttonAdd.setMnemonic(KeyEvent.VK_D);
		buttonDelete.setBackground(lightBlue);
		add(buttonDelete);
		
		JButton buttonAddStudent = new JButton();
		buttonAddStudent.setToolTipText("Dodaj studenta(CTRL+S)");
		buttonAddStudent.setIcon(new ImageIcon("logo_images/add_student.jpg"));
		buttonAdd.setMnemonic(KeyEvent.VK_S);
		buttonAddStudent.setBackground(lightBlue);
		add(buttonAddStudent);
		buttonAddStudent.setVisible(true);
		
		JButton buttonAddProfessor = new JButton();
		buttonAddProfessor.setToolTipText("Dodaj profesora(CTRL+P)");
		buttonAddProfessor.setIcon(new ImageIcon("logo_images/add_professor.jpg"));
		buttonAdd.setMnemonic(KeyEvent.VK_P);
		buttonAddProfessor.setBackground(lightBlue);
		add(buttonAddProfessor);
		buttonAddProfessor.setVisible(true);
		
		//Dodaje horizontalni razmak izmedju dugmica sa lijeve i desne strane
		//add(Box.createHorizontalGlue());
		add(Box.createHorizontalStrut(900));
		
		JPanel panelSearch=new JPanel();
		JTextField textSearch=new JTextField();
		textSearch.setPreferredSize(new Dimension(200,30));
		textSearch.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		panelSearch.add(textSearch);
		add(panelSearch);
		
		JButton buttonSearch = new JButton();
		buttonSearch.setToolTipText("Pretraži(CTRL+F)");
		buttonSearch.setIcon(new ImageIcon("logo_images/search.jpg"));
		buttonAdd.setMnemonic(KeyEvent.VK_F);
		buttonSearch.setBackground(lightBlue);
		add(buttonSearch);
		buttonSearch.setVisible(true);
	}
}
