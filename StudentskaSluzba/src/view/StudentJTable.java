/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 * @author Dragana Carapic
 *
 */
public class StudentJTable extends JTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -729251922543511523L;
	public static TableRowSorter<AbstractTableModelStudent> sorter;
	
	public StudentJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		AbstractTableModelStudent model = new AbstractTableModelStudent();
		this.setModel(new AbstractTableModelStudent());
		new ButtonColumnStudent(this, 12);

		//this.setAutoCreateRowSorter(true);
		sorter = new TableRowSorter<AbstractTableModelStudent>(model);
		this.setRowSorter(sorter);
		
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Color lightBlue= new Color(160,215,255);
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(lightBlue);
			ButtonColumnStudent.selectedRow=sorter.convertRowIndexToModel(getSelectedRow());
		} else {
			c.setBackground(Color.WHITE);
			ButtonColumnStudent.selectedRow = -1;
		}
		return c;
	}
}
