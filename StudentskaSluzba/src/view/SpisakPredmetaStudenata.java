/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import model.BazaStudenata;

/**
 * @author Dragana Carapic
 *
 */
public class SpisakPredmetaStudenata extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4912484099300672725L;
	
	private JList<String> list = null;
	private JButton bObrisi = new JButton("Obri\u0161i");
	private JButton bNazad = new JButton("Nazad");
	private JPanel pnlList = new JPanel();
	private JPanel pnlObrisiNazad = new JPanel();
	private Color darkerBlue= new Color(0,200,200);
	
	public SpisakPredmetaStudenata(Frame parent,String title,boolean modal,int row) {
		
		super(parent,title,modal);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setSize(400, 300);
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);		
		setLocationRelativeTo(parent);
		
		addCompJDialog(row);
		
	}
	
	public void addCompJDialog(int row) {
		FlowLayout pnlObrisiNazadLayout = new FlowLayout(FlowLayout.RIGHT);
		getContentPane().add(pnlObrisiNazad,BorderLayout.SOUTH);
		pnlObrisiNazad.setLayout(pnlObrisiNazadLayout);
		
		pnlObrisiNazad.add(bObrisi);
		pnlObrisiNazad.add(bNazad);
		
		list = new JList<String>(new MyListBM(row));
		list.setCellRenderer(new MyListRenderer());
		
		JScrollPane scp = new JScrollPane(list);
		
		list.setPreferredSize(new Dimension(200, 150));
		
		pnlList.add(scp);
		pnlList.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0)); 
		getContentPane().add(pnlList,BorderLayout.CENTER);
		
		this.bNazad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.bObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private class MyListBM extends AbstractListModel {
		
		private static final long serialVersionUID = 1L;
		private ArrayList<String> studenti;
		
		MyListBM(int row){
			studenti = new ArrayList<String>();
			ucitajStudente(row);
		}
		private void ucitajStudente(int row) {
			for(int i=0; i<BazaStudenata.getInstance().getStudentIndex(row).getBrojPredmeta();i++) {
				studenti.add(new String(BazaStudenata.getInstance().getStudentIndex(row).getSpisakPredmeta().get(i)));
			}
		}

		@Override
		public Object getElementAt(int i) {
			// TODO Auto-generated method stub
			return studenti.get(i);
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return studenti.size();
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
			// TODO Auto-generated method stub
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