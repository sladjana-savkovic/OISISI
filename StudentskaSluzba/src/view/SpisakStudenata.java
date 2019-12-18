/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import model.BazaPredmeta;


/**
 * @author Sladjana Savkovic
 *
 */
public class SpisakStudenata extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private JList<String> list = null;
	private JButton bObrisi = new JButton("Obriši");
	private JButton bNazad = new JButton("Nazad");
	private JPanel pnlList = new JPanel();
	private JPanel pnlObrisiNazad = new JPanel();
	private Color darkerBlue= new Color(0,200,200);
	
	public SpisakStudenata(Frame parent,String title,boolean modal,int row) {
		
		super(parent,title,modal);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setSize(400, 300);
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);		
		setLocationRelativeTo(parent);
		
		addComponentJDialog(row);
		
	}
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("rawtypes")
	private class MyListBoxModel extends AbstractListModel {
		
		private static final long serialVersionUID = 1L;
		private ArrayList<String> studenti;

		MyListBoxModel(int row) {
			studenti = new ArrayList<String>();
			ucitajStudente(row);
		}
		private void ucitajStudente(int row) {
			for(int i=0;i<BazaPredmeta.getInstance().getPredmetIndex(row).getBrojStudenata();i++) {
				studenti.add(new String(BazaPredmeta.getInstance().getPredmetIndex(row).getSpisakStudenata().get(i)));
			}
		}
		@Override
		public Object getElementAt(int index) {
			return studenti.get(index);
		}

		@Override
		public int getSize() {
			return studenti.size();
		}
	}
	@SuppressWarnings("rawtypes")
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
