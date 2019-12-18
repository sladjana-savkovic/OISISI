/**
 * 
 */
package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

/**
 * @author Dragana Carapic
 *
 */
public class AbstractTableModelStudent extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -538526045258933971L;
	private String[] naziviKolona= {"Ime", "Prezime","Datum rođenja", "Adresa stanovanja","Broj Telefona","Email adresa","Broj indeksa","Datum upisa","Godina studija", "Prosjek","Status","Broj predmeta","Predmeti"};

	public AbstractTableModelStudent() {}
	
	@Override
	public int getColumnCount() {
		return naziviKolona.length;
	}

	@Override
	public int getRowCount() {
		return BazaStudenata.getInstance().getStudenti().size();
	}

	@Override
	public Object getValueAt(int redInd, int kolonaInd) {
		if (kolonaInd < 12)
			return BazaStudenata.getInstance().getValueAt(redInd, kolonaInd);
		else if (kolonaInd == 12) {
			JButton btn = new JButton("" + redInd);
			return btn;
		}
		return null;
	}
	
	@Override
	public Class<?> getColumnClass(int kolonaInd) {
		switch (kolonaInd) {
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
		case 12:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int kol) {
		return naziviKolona[kol];
	}
	
	@Override
	public boolean isCellEditable(int redInd, int kolonaInd) {
		return kolonaInd == 11;
	}

}
