/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import controller.PredmetController;

/**
 * @author Sladjana Savkovic
 *
 */
public class SpisakStudenata extends JDialog{

	private static final long serialVersionUID = 5273652697018074107L;
	
	private JList<String> list = null;
	private JButton bObrisi = new JButton("Obriši");
	private JButton bNazad = new JButton("Nazad");
	private JPanel pnlList = new JPanel();
	private JPanel pnlObrisiNazad = new JPanel();
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	public SpisakStudenata(Frame parent,String title,boolean modal,int row) {
		
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
		//Poziva se metoda za dodavanje studenata na spisak(listu) studenata koji slusaju neki predmet
		dodajStudenteNaListu(row);
		
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
					obrisiStudenta();
				}
			}
			
		});
	}
	public void dodajStudenteNaListu(int row) {
		ArrayList<String> studenti = PredmetController.getInstance().studentiNaPredmetu(row);
		for(int i=0;i<studenti.size();i++)
			listModel.add(i, studenti.get(i));
	}
	public void obrisiStudenta() {
		int selectedIndex = list.getSelectedIndex();
		
		//Student se brise sa liste studenata nekog predmeta
		PredmetController.getInstance().obrisiStudentaSaPredmeta(ButtonColumnPredmet.selectedRow,selectedIndex);
		//Obrisan student ne slusa vise predmet sa kojeg je uklonjen
		//implementacija
		
		listModel.remove(selectedIndex);
		
	}
}
