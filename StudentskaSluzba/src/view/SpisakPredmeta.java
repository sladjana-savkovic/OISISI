/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import controller.PredmetController;
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
	boolean flag;
	
	public SpisakPredmeta(Frame parent,String title,boolean modal,int row) {
		
		super(parent,title,modal);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setSize(400, 300);
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);		
		setLocationRelativeTo(parent);
		
		flag=false;
		addComponentJDialog(row);
		
	}
	public void addComponentJDialog(int row) {
		
		FlowLayout pnlObrisiNazadLayout = new FlowLayout(FlowLayout.RIGHT);
		getContentPane().add(pnlObrisiNazad,BorderLayout.SOUTH);
		pnlObrisiNazad.setLayout(pnlObrisiNazadLayout);
		
		pnlObrisiNazad.add(bObrisi);
		pnlObrisiNazad.add(bNazad);
				
		list = new JList<String>(listModel);
		//Poziva se metoda za dodavanje predmeta na spisak(listu) predmeta nekog profesora
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
				
				if(flag) {
					ButtonColumnStudent.selectedRow = -1;
					ButtonColumnProfesor.selectedRow = -1;
					ButtonColumnPredmet.selectedRow = -1;
					
					flag=false;
				}
			}
		});
		this.bObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izaberite neki red u listi!","Gre\u0161ka",JOptionPane.ERROR_MESSAGE);
				}else {
					obrisiPredmet();
					
					if(ProfesorController.getInstance().predmetiProfesora(row).isEmpty()) {
						ButtonColumnStudent.selectedRow = -1;
						ButtonColumnProfesor.selectedRow = -1;
						ButtonColumnPredmet.selectedRow = -1;
						dispose();
					}
				}
			}
		});
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//Ukloni postojeci WindowListeners
		for ( WindowListener wl : this.getWindowListeners())
		        this.removeWindowListener(wl);
		this.addWindowListener(new WindowAdapter() {
		      @Override
		      public void windowClosing(WindowEvent e) {
		    	  dispose();	
					
				if(flag) {
					ButtonColumnStudent.selectedRow = -1;
					ButtonColumnProfesor.selectedRow = -1;
					ButtonColumnPredmet.selectedRow = -1;
						
					flag=false;
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
		flag=true;
		
		int selectedIndex = list.getSelectedIndex();
		String selectedItem = list.getSelectedValue();
		
		//Predmet se brise sa liste predmeta nekog profesora
		ProfesorController.getInstance().obrisiPredmetProfesora(ButtonColumnProfesor.selectedRow, selectedIndex);
		//Obrisan predmet ostaje bez profesora dok korisnik ne dodijeli nekog novog profesora
		PredmetController.getInstance().uklanjanjeProfesoraSaPredmeta(selectedItem);
		
		listModel.remove(selectedIndex);	
	}
}
