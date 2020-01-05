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
	
	Color lightBlue;
	JButton buttonAdd;
	JButton buttonModify;
	JButton buttonDelete;
	static public JButton buttonAddProfessor;
	static public JButton buttonAddStudent;
	static public JTextField textSearch;
	static public JButton buttonSearch;
	static public JButton buttonDeleteProfessor;

	public Toolbar() {
		
		// u konstruktor natklase, JToolbar prosledjujemo orijentaciju toolbar-a
		super(SwingConstants.HORIZONTAL);
		lightBlue= new Color(160,215,255);
		
		setButtonAdd();
		setButtonModify();
		setButtonDelete();
		setButtonAddStudent();
		setButtonAddProfessor();
		setButtonDeleteProfessor();
		
		//Dodaje horizontalni razmak izmedju dugmica sa lijeve i desne strane
		add(Box.createHorizontalGlue());
		
		setTextSearch();
		setButtonSearch();
	}
	private void setButtonAdd() {
		AbstractActionDodavanje dodaj = new AbstractActionDodavanje();
		buttonAdd = new JButton(dodaj);
		buttonAdd.setIcon(new ImageIcon("logo_images/plus.jpg"));
		buttonAdd.setBackground(lightBlue);
		add(buttonAdd);
	}
	private void setButtonModify() {
		AbstractActionIzmjena izmjena = new AbstractActionIzmjena();
		buttonModify = new JButton(izmjena);
		buttonModify.setToolTipText("Izmijeni");
		buttonModify.setIcon(new ImageIcon("logo_images/pencil.jpg"));
		buttonModify.setBackground(lightBlue);
		add(buttonModify);
	}
	private void setButtonDelete() {
		AbstractActionBrisanje brisanje = new AbstractActionBrisanje();
		buttonDelete = new JButton(brisanje);
		buttonDelete.setIcon(new ImageIcon("logo_images/delete.jpg"));
		buttonDelete.setBackground(lightBlue);
		add(buttonDelete);
	}
	private void setButtonAddStudent() {
		AbstractActionDodNaPredmet dodavanjeStudenta = new AbstractActionDodNaPredmet();
		buttonAddStudent = new JButton(dodavanjeStudenta);
		buttonAddStudent.setToolTipText("Dodaj studenta");
		buttonAddStudent.setIcon(new ImageIcon("logo_images/add_student.jpg"));
		buttonAddStudent.setBackground(lightBlue);
		add(buttonAddStudent);
	}
	private void setButtonAddProfessor() {
		AbstractActionDodavanjeProfesora dodavanjeProfesora = new AbstractActionDodavanjeProfesora();
		buttonAddProfessor = new JButton(dodavanjeProfesora);
		buttonAddProfessor.setIcon(new ImageIcon("logo_images/add_professor.jpg"));
		buttonAddProfessor.setBackground(lightBlue);
		add(buttonAddProfessor);
	}
	private void setTextSearch() {
		textSearch=new JTextField(15);
		textSearch.setMaximumSize(textSearch.getPreferredSize());
		textSearch.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		textSearch.setMaximumSize(new Dimension(8160,80));
		add(textSearch);
	}
	private void setButtonSearch() {
		AbstractActionPretrazi pretrazi = new AbstractActionPretrazi();
		buttonSearch = new JButton(pretrazi);
		buttonSearch.setToolTipText("Pretraži");
		buttonSearch.setIcon(new ImageIcon("logo_images/search.jpg"));
		buttonSearch.setBackground(lightBlue);
		add(buttonSearch);
		buttonSearch.setVisible(true);
	}
	private void setButtonDeleteProfessor() {
		AbstractActionBrisanjeProfesora brisanjeProfesora = new AbstractActionBrisanjeProfesora();
		buttonDeleteProfessor = new JButton(brisanjeProfesora);
		buttonDeleteProfessor.setIcon(new ImageIcon("logo_images/delete_professor.jpg"));
		buttonDeleteProfessor.setBackground(lightBlue);
		add(buttonDeleteProfessor);
	}
}
