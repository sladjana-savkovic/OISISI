/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import controller.PredmetController;
import controller.StudentController;

/**
 * @author Sladjana Savkovic
 *
 */
public class SpisakStudenata extends JDialog{

	private static final long serialVersionUID = 5273652697018074107L;
	
	private JList<String> list = null;
	private JButton bObrisi;
	private JButton bNazad;
	private JPanel pnlList;
	private JPanel pnlObrisiNazad;
	DefaultListModel<String> listModel;
	boolean flag;
	
	public SpisakStudenata(Frame parent,String title,boolean modal,int row) {
		
		super(parent,title,modal);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setSize(400, 300);
		Image img=kit.getImage("logo_images/ftn.png");
		setIconImage(img);		
		setLocationRelativeTo(parent);
		
		bObrisi = new JButton("Obri\u0161i");
		bNazad = new JButton("Nazad");
		pnlList = new JPanel();
		pnlObrisiNazad = new JPanel();
		listModel = new DefaultListModel<String>();
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
					obrisiStudenta();
					
					if(PredmetController.getInstance().studentiNaPredmetu(row).isEmpty()) {
						ButtonColumnStudent.selectedRow = -1;
						ButtonColumnProfesor.selectedRow = -1;
						ButtonColumnPredmet.selectedRow = -1;
						
						dispose();
					}
				}
			}
			
		});
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//Ukloni postojeci WindowListeners da bi se ponasao kao dugme nazad
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
	public void dodajStudenteNaListu(int row) {
		ArrayList<String> studenti = PredmetController.getInstance().studentiNaPredmetu(row);
		for(int i=0;i<studenti.size();i++)
			listModel.add(i, studenti.get(i));
	}
	public void obrisiStudenta() {
		flag=true;
		
		int selectedIndex = list.getSelectedIndex();
		String selectedItem = list.getSelectedValue();
		
		//Student se brise sa liste studenata nekog predmeta
		PredmetController.getInstance().obrisiStudentaSaPredmeta(ButtonColumnPredmet.selectedRow,selectedIndex);
		//Obrisan student ne slusa vise predmet sa kojeg je uklonjen
		StudentController.getInstance().uklanjanjePredmetaIzListe(ButtonColumnPredmet.selectedRow,selectedItem);
		
		listModel.remove(selectedIndex);
	}
}
