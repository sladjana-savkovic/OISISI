/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.PredmetController;
import controller.StudentController;
import model.BazaStudenata;
import model.Predmet;
import model.Student.statusStudenta;

/**
 * @author Dragana Carapic
 *
 */
public class DodavanjeStudentaNaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6032232686414917989L;
	
	private JLabel indeks;
	private JComboBox<String> indeksCM;
	
	
	public DodavanjeStudentaNaPredmet(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initStudPred();
	}
	
	public void initStudPred() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(200,200);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			JPanel panelCenter = new JPanel();
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			
			Dimension dim = new Dimension(160, 25);
			JPanel panelInd = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			indeks = new JLabel("Indeks studenta*");
			indeks.setPreferredSize(dim);
			
			//inizijalizujem na maksimalan broj
			String[] a = new String[BazaStudenata.getInstance().getStudenti().size()];
			
			int j=0;
			Predmet p = PredmetController.getInstance().vratiSelektovanPredmet(ButtonColumnPredmet.selectedRow);
			for(int i=0; i<StudentController.getInstance().sviStudenti().size(); i++) {
				if(p.getGodinaStudija()==StudentController.getInstance().sviStudenti().get(i).getTrenutnaGodinaStudija()) {
					if(!(PredmetController.getInstance().studentiNaPredmetu(ButtonColumnPredmet.selectedRow).contains(StudentController.getInstance().sviStudenti().get(i).getBrojIndeka()))) {
					a[j]=StudentController.getInstance().sviStudenti().get(i).getBrojIndeka();
					j++;
					}
				}
			}
			
			//izbacivanje praznih stringova iz niza
			String[] b = new String[j];
			for(int y=0; y<j; y++) {
				b[y]=a[y];
			}
			
			indeksCM = new JComboBox<String>(b);
			
			panelInd.add(indeks);
			panelInd.add(indeksCM);
			
			panelCenter.add(panelInd);
			
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			add(panelCenter, BorderLayout.CENTER);
			
			JPanel panelBottom = new JPanel();
			BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
			panelBottom.setLayout(box);
			
			JButton potvrdi = new JButton("Potvrditi");
			potvrdi.setPreferredSize(new Dimension(100, 30));
			potvrdi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Predmet p = PredmetController.getInstance().vratiSelektovanPredmet(ButtonColumnPredmet.selectedRow);
					String indStr = (String)indeksCM.getSelectedItem();
					if(b.length!=0) {
					//moje staro rjesenje
					//PredmetController.getInstance().studentiNaPredmetu(ButtonColumnPredmet.selectedRow).add(indStr);
					//otkomentarisi posle dodavanje metode u predmet kontroler
					//PredmetController.getInstance().dodajStudentaPredmetu(indStr,ButtonColumnPredmet.selectedRow);
					StudentController.getInstance().dodajPredmetStudentu(indStr, p.getSifra());
		
					JOptionPane.showMessageDialog(DodavanjeStudentaNaPredmet.this, "Uspje\u0161no ste dodali studenta na predmet!");
					dispose();
					}else {
						JOptionPane.showMessageDialog(DodavanjeStudentaNaPredmet.this, "Nije moguce dodati studenta na predmet!");
					}
				}
			});
			
			JButton odustani = new JButton("Odustati");
			odustani.setPreferredSize(new Dimension(100, 30));
			odustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Da","Ne"};
					int res = JOptionPane.showOptionDialog(DodavanjeStudentaNaPredmet.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(res == JOptionPane.YES_OPTION) {
						dispose();
					}
				}
			});
			
			panelBottom.add(Box.createGlue());
			panelBottom.add(odustani);
			panelBottom.add(Box.createHorizontalStrut(10));
			panelBottom.add(potvrdi);
			panelBottom.add(Box.createHorizontalStrut(10));
			
			add(panelBottom, BorderLayout.SOUTH);
			pack();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
