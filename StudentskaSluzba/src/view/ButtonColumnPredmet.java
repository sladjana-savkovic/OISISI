/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import controller.PredmetController;

/**
 * @author Sladjana Savkovic
 *
 */
public class ButtonColumnPredmet extends AbstractCellEditor
	implements TableCellRenderer, TableCellEditor, MouseListener{
	
	private static final long serialVersionUID = -32506745170624766L;

	public static int selectedRow=-1;
	
	// dugme koje se iscrtava
	private JButton renderButton;
	// dugme koje obradjuje akciju
	private JButton editorButton;
	// referenca na tabelu
	private JTable table;
	// da li je aktivno editovanje celije tabele
	// (da li se obradjuju dogadjaji pritiska misa)
	private boolean isEditorActive = false;
	
	public ButtonColumnPredmet(JTable table, int column) {
		// povezivanje sa tabelom
		this.table = table;
		// nacin iscrtavanje celije
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		// nacin editovanja celije
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		// dugme koje ce biti iscrtavanp
		this.renderButton = new JButton("Prikaži");
		this.editorButton = new JButton("Prikaži");

		this.editorButton.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			fireEditingStopped();
			if(PredmetController.getInstance().studentiNaPredmetu(selectedRow).size() == 0)
				JOptionPane.showMessageDialog(null, "Lista studenata je prazna!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
			else
				new SpisakStudenata(null,"Spisak studenata",true,selectedRow).setVisible(true);
		}
		});

		this.isEditorActive = false;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// Drugom dugmetu se prosledjuje klik misa
		return new SPPTablePanel(this.editorButton, 0, 0);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return new SPPTablePanel(this.renderButton, 0, 0);
	}
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// ekplicitno navodimo da je editovanje celije je zavrseno
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
		
}
