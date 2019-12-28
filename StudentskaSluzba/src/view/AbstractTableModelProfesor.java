/**
 * 
 */
package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import model.BazaProfesora;

/**
 * @author Sladjana Savkovic
 *
 */
public class AbstractTableModelProfesor extends AbstractTableModel{
	
	private static final long serialVersionUID = 5892700218335673357L;
	
	private String[] columnNames = {"Ime","Prezime","Datum ro\u0111enja","Adresa stanovanja","Kontakt telefon","E-mail adresa",
			"Adresa kancelarije","Broj li\u010dne karte","Titula","Zvanje","Broj predmeta","Predmeti"};
	
	public AbstractTableModelProfesor() {}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 11)
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 11) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		}
		return null;
	}
	// da bismo mogli prikazati dugme
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
			return JButton.class;
		default:
			return null;
		}
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 11;
	}

}
