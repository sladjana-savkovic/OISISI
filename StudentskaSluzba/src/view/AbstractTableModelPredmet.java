package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

/**
 * @author Sladjana Savkovic
 *
 */

public class AbstractTableModelPredmet extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames = { "Šifra", "Naziv", "Godina",
			"Semestar", "Profesor", "Broj studenata", "Studenti" };
	
	public AbstractTableModelPredmet() {}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex < 6)
				return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
			else if (columnIndex == 6) {
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
			return columnIndex == 6;
		}
}
