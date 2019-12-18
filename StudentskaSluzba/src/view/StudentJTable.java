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
 * @author Dragana Carapic
 *
 */
public class StudentJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -729251922543511523L;
	
	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Color lightBlue= new Color(160,215,255);
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(lightBlue);
			ButtonColumnProfesor.selectedRow=getSelectedRow();
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
