/**
 * 
 */
package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Sladjana Savkovic
 *
 */
public class Toolbar extends JToolBar{
	
	private static final long serialVersionUID = 748775439327687207L;
	
	static JButton buttonAddProfessor = new JButton();;
	static JButton buttonAddStudent = new JButton();

	public Toolbar() {
		// u konstruktor natklase, JToolbar prosledjujemo orijentaciju toolbar-a
		super(SwingConstants.HORIZONTAL);
		Color lightBlue= new Color(160,215,255);
		//Color darkBlue= new Color(0,200,200);
		
		JButton buttonAdd = new JButton();
		buttonAdd.setToolTipText("Dodaj(CTRL+A)");
		buttonAdd.setIcon(new ImageIcon("logo_images/plus.jpg"));
		buttonAdd.setBackground(lightBlue);
		add(buttonAdd);
		
		JButton buttonModify = new JButton();
		buttonModify.setToolTipText("Izmijeni(CTRL+M)");
		buttonModify.setIcon(new ImageIcon("logo_images/pencil.jpg"));
		buttonModify.setBackground(lightBlue);
		add(buttonModify);
		
		JButton buttonDelete = new JButton();
		buttonDelete.setToolTipText("Obrisi(CTRL+D)");
		buttonDelete.setIcon(new ImageIcon("logo_images/delete.jpg"));
		buttonDelete.setBackground(lightBlue);
		add(buttonDelete);
		
		buttonAddStudent.setToolTipText("Dodaj studenta(CTRL+S)");
		buttonAddStudent.setIcon(new ImageIcon("logo_images/add_student.jpg"));
		buttonAddStudent.setBackground(lightBlue);
		add(buttonAddStudent);
		buttonAddStudent.setVisible(true);
		
		buttonAddProfessor.setToolTipText("Dodaj profesora(CTRL+P)");
		buttonAddProfessor.setIcon(new ImageIcon("logo_images/add_professor.jpg"));
		buttonAddProfessor.setBackground(lightBlue);
		add(buttonAddProfessor);
		buttonAddProfessor.setVisible(true);
		
		//Dodaje horizontalni razmak izmedju dugmica sa lijeve i desne strane
		add(Box.createHorizontalGlue());
		//add(Box.createHorizontalStrut(900));
		
		JTextField textSearch=new JTextField();
		textSearch.setMaximumSize(new Dimension(200,30));
		textSearch.setFont(new Font("TimesRoman", Font.PLAIN, 18));

		textSearch.setMaximumSize(new Dimension(8160,80));
		add(textSearch);
		
		JButton buttonSearch = new JButton();
		buttonSearch.setToolTipText("Pretraži(CTRL+F)");
		buttonSearch.setIcon(new ImageIcon("logo_images/search.jpg"));
		buttonSearch.setBackground(lightBlue);
		add(buttonSearch);
		buttonSearch.setVisible(true);
	}
}
