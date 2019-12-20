/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * @author Sladjana Savkovic
 *
 */
public class ProfesorJTable extends JTable{
	
	private static final long serialVersionUID = -557460832554227306L;
	
	public ProfesorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
		new ButtonColumnProfesor(this, 11);
		//sort
		this.setAutoCreateRowSorter(true);
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Color lightBlue= new Color(160,215,255);
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(lightBlue);
			//Postavljanje indeksa selektovanog reda u tabeli, nezavisno od sortiranja
			ButtonColumnProfesor.selectedRow=this.getRowSorter().convertRowIndexToModel(getSelectedRow());
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
