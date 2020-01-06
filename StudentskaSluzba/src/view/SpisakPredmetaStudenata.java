/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.PredmetController;
import controller.StudentController;


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
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	
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
	
	public void dodajPredmeteNaListu(int row) {
		ArrayList<String> predmeti = StudentController.getInstance().predmetiStudenata(row);
		for(int i=0; i<predmeti.size(); i++) {
			listModel.add(i, predmeti.get(i));
		}
	}
	
	public void obrisiPredmet() {
		int selectedIndex = list.getSelectedIndex();
		String selectedItem = list.getSelectedValue();
		
		StudentController.getInstance().obrisiPredmetStudenta(ButtonColumnStudent.selectedRow, selectedIndex);
		PredmetController.getInstance().uklanjanjeStudentaIzListe(ButtonColumnStudent.selectedRow, selectedItem);
		
		listModel.remove(selectedIndex);

	}
}