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
	private JPanel pnlList = new JPanel();
	private JPanel pnlObrisiNazad = new JPanel();
	private Color darkerBlue= new Color(0,200,200);
	
	public SpisakPredmeta(Frame parent,String title,boolean modal,int row) {
		
		super(parent,title,modal);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setSize(400, 300);
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);		
		setLocationRelativeTo(parent);
		
		addComponentJDialog(row);
		
	}
	public void addComponentJDialog(int row) {
		
		FlowLayout pnlObrisiNazadLayout = new FlowLayout(FlowLayout.RIGHT);
		getContentPane().add(pnlObrisiNazad,BorderLayout.SOUTH);
		pnlObrisiNazad.setLayout(pnlObrisiNazadLayout);
		
		pnlObrisiNazad.add(bObrisi);
		pnlObrisiNazad.add(bNazad);
				
		list = new JList<String>(new MyListBoxModel(row));
		list.setCellRenderer(new MyListRenderer());
		
		JScrollPane scp = new JScrollPane(list);
		
		list.setPreferredSize(new Dimension(200, 150));
		
		pnlList.add(scp);
		pnlList.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0)); 
		getContentPane().add(pnlList,BorderLayout.CENTER);
		
		this.bNazad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
			});
		this.bObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Treba da brise element liste
			}
		});
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
