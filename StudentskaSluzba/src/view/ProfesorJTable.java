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
 * @author Sladjana Savkovic
 *
 */
public class ProfesorJTable extends JTable{
	
	private static final long serialVersionUID = -557460832554227306L;
	public static TableRowSorter<AbstractTableModelProfesor> sorter;
	//private static ProfesorJTable instance = null;
	
	/*public static ProfesorJTable getInstance() {
		if (instance == null) {
			instance = new ProfesorJTable();
		}
		return instance;
	}*/
	
	public ProfesorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AbstractTableModelProfesor model = new AbstractTableModelProfesor();
		this.setModel(new AbstractTableModelProfesor());
		new ButtonColumnProfesor(this, 11);
		//sort
		sorter = new TableRowSorter<AbstractTableModelProfesor>(model);
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
			ButtonColumnProfesor.selectedRow=sorter.convertRowIndexToModel(getSelectedRow());
		} else {
			c.setBackground(Color.WHITE);
			/*ButtonColumnStudent.selectedRow=-1;
			ButtonColumnPredmet.selectedRow=-1;*/
		}
		return c;
	}
}
