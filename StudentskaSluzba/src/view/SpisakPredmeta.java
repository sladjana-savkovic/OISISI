/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import controller.ProfesorController;

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
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
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
				
		list = new JList<String>(listModel);
		dodajPredmeteNaListu(row);
		
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
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Izaberite neki red u listi!","Greška",JOptionPane.ERROR_MESSAGE);
				}else {
					obrisiPredmet();
				}
			}
		});
	}
	private void dodajPredmeteNaListu(int row) {
		ArrayList<String> predmeti = ProfesorController.getInstance().predmetiProfesora(row);
		for(int i=0;i<predmeti.size();i++)
			listModel.add(i, predmeti.get(i));
		
	}
	public void obrisiPredmet() {
		int selectedIndex = list.getSelectedIndex();
		
		ProfesorController.getInstance().obrisiPredmetProfesora(ButtonColumnProfesor.selectedRow, selectedIndex);
		if(selectedIndex != -1) {
			listModel.remove(selectedIndex);
		}
	}
	
}
