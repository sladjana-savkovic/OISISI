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

	public PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmet());
		new ButtonColumnPredmet(this, 6);
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Color lightBlue= new Color(160,215,255);
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(lightBlue);
			ButtonColumnPredmet.selectedRow=getSelectedRow();
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
