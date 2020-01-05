/**
 * 
 */
package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


/**
 * @author Sladjana Savkovic
 *
 */
public class PredmetJTable extends JTable{

	private static final long serialVersionUID = -9142591266690440511L;
	public static TableRowSorter<AbstractTableModelPredmet> sorter;
	
	
	
	public PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelPredmet model = new AbstractTableModelPredmet();
		this.setModel(model);
		new ButtonColumnPredmet(this, 6);
		//sort
		sorter = new TableRowSorter<AbstractTableModelPredmet>(model);
		this.setRowSorter(sorter);
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Color lightBlue= new Color(160,215,255);
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(lightBlue);
			//Postavljanje indeksa selektovanog reda u tabeli, nezavisno od sortiranja
			ButtonColumnPredmet.selectedRow=sorter.convertRowIndexToModel(getSelectedRow());
			/*ButtonColumnStudent.selectedRow=-1;
			ButtonColumnProfesor.selectedRow=-1;*/
		} else {
			c.setBackground(Color.WHITE);
			ButtonColumnPredmet.selectedRow = -1;
			/*ButtonColumnStudent.selectedRow=-1;
			ButtonColumnProfesor.selectedRow=-1;*/
		}
		return c;
	}
}
