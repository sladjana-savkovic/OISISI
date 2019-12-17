/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.BazaProfesora;



/**
 * @author Sladjana Savkovic
 *
 */
public class SpisakPredmeta extends JDialog{
	
	private static final long serialVersionUID = -3193560552005285638L;
	
	private JList<String> list = null;
	private JButton bObrisi = new JButton("Obriši");
	private JButton bNazad = new JButton("Nazad");
	private JLabel lbNaslov = new JLabel();
	private JPanel pnlList = new JPanel();
	private JPanel pnlObrisiNazad = new JPanel();
	private Color lightBlue= new Color(180,231,255);
	private Color darkerBlue= new Color(0,200,200);
	
	public SpisakPredmeta(int row) {
		
		
		setSize(450, 350);
		setUndecorated(true);
		//getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));
		
		addComponentJDialog(row);
		
	}
	public void addComponentJDialog(int row) {
		
		lbNaslov.setText("Spisak studenata");
		lbNaslov.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbNaslov.setOpaque(true);
		lbNaslov.setBackground(lightBlue);
		lbNaslov.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
		getContentPane().add(lbNaslov,BorderLayout.NORTH);
		
				
		FlowLayout pnlObrisiNazadLayout = new FlowLayout(FlowLayout.RIGHT);
		getContentPane().add(pnlObrisiNazad,BorderLayout.SOUTH);
		pnlObrisiNazad.setLayout(pnlObrisiNazadLayout);
		pnlObrisiNazad.setBackground(lightBlue);
		pnlObrisiNazad.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
		
		pnlObrisiNazad.add(bObrisi);
		
		bNazad.setBackground(darkerBlue);
		this.bNazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
			});

		pnlObrisiNazad.add(bNazad);
				
		list = new JList<String>(new MyListBoxModel(row));
		list.setCellRenderer(new MyListRenderer());
		
		JScrollPane scp = new JScrollPane(list);
		
		list.setPreferredSize(new Dimension(300, 200));
		
		pnlList.add(scp);
		pnlList.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); 
		getContentPane().add(pnlList,BorderLayout.CENTER);
	}
	
	private class MyListBoxModel extends AbstractListModel {
	
		private static final long serialVersionUID = 1L;
		private ArrayList<String> predmeti;
	
		MyListBoxModel(int row) {
			predmeti = new ArrayList<String>();
			ucitajPredmete(row);
		}
		private void ucitajPredmete(int row) {
			for(int i=0;i<BazaProfesora.getInstance().getProfesorIndex(row).getBrojPredmeta();i++) {
				predmeti.add(new String(BazaProfesora.getInstance().getProfesorIndex(row).getSpisakPredmeta().get(i)));
			}
		}
		@Override
		public Object getElementAt(int index) {
			return predmeti.get(index);
		}
	
		@Override
		public int getSize() {
			return predmeti.size();
		}
	}
	private class MyListRenderer extends JLabel implements ListCellRenderer {

	
		private static final long serialVersionUID = 1L;
	
		public MyListRenderer() {
			setOpaque(true);
			setVerticalAlignment(CENTER);
		}
	
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	
			String string = (String) value;
			if ( string == null )
				string = (String) list.getModel().getElementAt(0);
			
			setText(string);
	
			if ( isSelected ) {
				setBackground(darkerBlue);
				setForeground(list.getSelectionForeground());
			}
			else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
	
			return this;
		}
	}
}
