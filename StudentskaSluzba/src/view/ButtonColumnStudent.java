/**
 * 
 */
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * @author Dragana Carapic
 *
 */
public class ButtonColumnStudent extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7064218263103992080L;
	public static int selectedRow=-1;
	
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditoractive=false;
	
	public ButtonColumnStudent(JTable table, int column) {
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikaži");
		this.editorButton = new JButton("Prikaži");
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				new SpisakStudenata(null, "Spisak predmeta studenta",true, selectedRow).setVisible(true);
				
			}
		});
		
		this.isEditoractive = false;
	}

	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditoractive = true;
		}

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (isEditoractive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditoractive = false;
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return new SPPTablePanel(this.editorButton, 50, 50);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		return new SPPTablePanel(this.renderButton, 50, 50);
	}

}
