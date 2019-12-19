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
import controller.StudentController;
import model.Predmet;
import model.Student;
import model.Student.statusStudenta;


/**
 * @author Sladjana Savkovic
 *
 */
public class DodavanjePredmeta extends JDialog{

	private static final long serialVersionUID = -4761031862006107617L;
	private JLabel sifraPredmeta,nazivPredmeta,semestar,godinaStudija,predmetniProfesor;
	private JTextField txtSifraPredmeta,txtNazivPredmeta,txtPredmetniProfesor;
	private JComboBox CBgodina,CBsemestar;
	//private Color darkerBlue= new Color(0,200,200);
	
	public DodavanjePredmeta(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initPredmeti();
	}
	public void initPredmeti() {
		
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			JPanel panelCenter = new JPanel();
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			
			Dimension dim = new Dimension(160, 25);
			
			//polje za unos sifre predmeta
			JPanel pnlSifraPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			sifraPredmeta = new JLabel("Sifra predmeta*");
			sifraPredmeta.setPreferredSize(dim);
			txtSifraPredmeta = new JTextField();
			txtSifraPredmeta.setPreferredSize(dim);
			txtSifraPredmeta.setName("txtSifraPredmeta");
			
			pnlSifraPredmeta.add(sifraPredmeta);
			pnlSifraPredmeta.add(txtSifraPredmeta);
					
			//polje za unos naziva predmeta
			JPanel pnlNazivPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			nazivPredmeta = new JLabel("Naziv predmeta*");
			nazivPredmeta.setPreferredSize(dim);
			txtNazivPredmeta = new JTextField();
			txtNazivPredmeta.setPreferredSize(dim);
			txtNazivPredmeta.setName("txtNazivPredmeta");
			
			pnlNazivPredmeta.add(nazivPredmeta);
			pnlNazivPredmeta.add(txtNazivPredmeta);
			
			//polje za predmetnog profesora
			JPanel pnlPredmetniProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			predmetniProfesor = new JLabel("Predmetni profesor*");
			predmetniProfesor.setPreferredSize(dim);
			txtPredmetniProfesor = new JTextField();
			txtPredmetniProfesor.setPreferredSize(dim);
			txtPredmetniProfesor.setName("txtPredmetniProfesor");
			
			pnlPredmetniProfesor.add(predmetniProfesor);
			pnlPredmetniProfesor.add(txtPredmetniProfesor);
			
			//polje za odabir godine na kojoj se predmet slusa
			JPanel pnlGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
			ComboBoxModel cmbGodinaStudija = new DefaultComboBoxModel(new String[] {"I(prva)", "II(druga)", "III(treca)", "IV(cetvrta)"}); 
			godinaStudija = new JLabel();
			godinaStudija.setText("Godina na kojoj se predmet slusa*");
			godinaStudija.setPreferredSize(dim);
			
			CBgodina = new JComboBox();
			pnlGodinaStudija.add(godinaStudija);
			pnlGodinaStudija.add(CBgodina);
			CBgodina.setModel(cmbGodinaStudija);
			
			//polje za odabir semestra u kojem se predmet slusa
			JPanel pnlSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
			ComboBoxModel cmbSemestar = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5","6","7","8"}); 
			semestar = new JLabel();
			semestar.setText("Semestar u kojem se predmet slusa*");
			semestar.setPreferredSize(dim);
			
			CBsemestar = new JComboBox();
			pnlSemestar.add(semestar);
			pnlSemestar.add(CBsemestar);
			CBsemestar.setModel(cmbSemestar);
			
			panelCenter.add(pnlSifraPredmeta);
			panelCenter.add(pnlNazivPredmeta);
			panelCenter.add(pnlPredmetniProfesor);
			panelCenter.add(pnlGodinaStudija);
			panelCenter.add(pnlSemestar);
			
			panelCenter.add(Box.createVerticalStrut(50));
			panelCenter.add(Box.createGlue());
			add(panelCenter, BorderLayout.CENTER);
			
			//potvrda unijetog sadrzaja ili odustanak
			JPanel panelBottom = new JPanel();
			BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
			panelBottom.setLayout(box);
					
			JButton potvrdi = new JButton("Potvrda");
			potvrdi.setPreferredSize(new Dimension(100, 30));
			potvrdi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String sifra = txtSifraPredmeta.getText();
					if(sifra.equals("")) {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Morate unijeti ime studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
						txtSifraPredmeta.requestFocus();
						return;
					}
					
					String naziv = txtNazivPredmeta.getText();
					if(naziv.equals("")) {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Morate unijeti prezime studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
						txtNazivPredmeta.requestFocus();
						return;
					}
					
					String profesor = txtPredmetniProfesor.getText();
					if(profesor.equals("")) {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Morate unijeti datum rođenja studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
						txtPredmetniProfesor.requestFocus();
						return;
					}
					String god = (String)CBgodina.getSelectedItem();
					int godina=Integer.parseInt(god);
					
					String sem = (String)CBsemestar	.getSelectedItem();
					int semestar=Integer.parseInt(sem);
					
					ArrayList<String> studenti = new ArrayList<String>();
					Predmet p = new Predmet(sifra,naziv,profesor,semestar,godina,studenti);
							
					boolean unesen = PredmetController.getInstance().dodajPredmet(p);
					if(unesen) {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Uspje\u0161no ste unijeli studenta!");
						txtSifraPredmeta.setText("");
						txtNazivPredmeta.setText("");
						txtPredmetniProfesor.setText("");
					}else {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Neuspje\u0161no dodavanje studenta!");
					}
						}
					});
					
			JButton odustani = new JButton("Odustanak");
			odustani.setPreferredSize(new Dimension(80, 30));
			odustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Da","Ne"};
					int res = JOptionPane.showOptionDialog(DodavanjePredmeta.this, "Da li ste sigurni da želite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

