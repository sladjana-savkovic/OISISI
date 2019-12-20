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
	
	static public JButton buttonAddProfessor = new JButton();;
	static public JButton buttonAddStudent = new JButton();
	static public JTextField textSearch;

	public Toolbar() {
		// u konstruktor natklase, JToolbar prosledjujemo orijentaciju toolbar-a
		super(SwingConstants.HORIZONTAL);
		Color lightBlue= new Color(160,215,255);
		//Color darkBlue= new Color(0,200,200);
		
		AbstractActionDodavanje dodaj = new AbstractActionDodavanje();
		JButton buttonAdd = new JButton(dodaj);
		buttonAdd.setToolTipText("Dodaj");
		buttonAdd.setIcon(new ImageIcon("logo_images/plus.jpg"));
		buttonAdd.setBackground(lightBlue);
		add(buttonAdd);
		
		JButton buttonModify = new JButton();
		buttonModify.setToolTipText("Izmijeni");
		buttonModify.setIcon(new ImageIcon("logo_images/pencil.jpg"));
		buttonModify.setBackground(lightBlue);
		add(buttonModify);
		
		AbstractActionBrisanje brisanje = new AbstractActionBrisanje();
		JButton buttonDelete = new JButton(brisanje);
		buttonDelete.setToolTipText("Obrisi");
		buttonDelete.setIcon(new ImageIcon("logo_images/delete.jpg"));
		buttonDelete.setBackground(lightBlue);
		add(buttonDelete);
		
		buttonAddStudent.setToolTipText("Dodaj studenta");
		buttonAddStudent.setIcon(new ImageIcon("logo_images/add_student.jpg"));
		buttonAddStudent.setBackground(lightBlue);
		add(buttonAddStudent);
		buttonAddStudent.setVisible(true);
		
		buttonAddProfessor.setToolTipText("Dodaj profesora");
		buttonAddProfessor.setIcon(new ImageIcon("logo_images/add_professor.jpg"));
		buttonAddProfessor.setBackground(lightBlue);
		add(buttonAddProfessor);
		buttonAddProfessor.setVisible(true);
		
		//Dodaje horizontalni razmak izmedju dugmica sa lijeve i desne strane
		add(Box.createHorizontalGlue());
		//add(Box.createHorizontalStrut(900));
		
		textSearch=new JTextField(15);
		textSearch.setMaximumSize(textSearch.getPreferredSize());
		textSearch.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		textSearch.setMaximumSize(new Dimension(8160,80));
		add(textSearch);
		
		AbstractActionPretrazi pretrazi = new AbstractActionPretrazi();
		JButton buttonSearch = new JButton(pretrazi);
		buttonSearch.setToolTipText("Pretraži");
		buttonSearch.setIcon(new ImageIcon("logo_images/search.jpg"));
		buttonSearch.setBackground(lightBlue);
		add(buttonSearch);
		buttonSearch.setVisible(true);
	}
}
