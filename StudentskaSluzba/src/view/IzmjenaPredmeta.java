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
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import model.Predmet;

/**
 * @author Sladjana Savkovic
 *
 */
public class IzmjenaPredmeta extends JDialog{
	
	private static final long serialVersionUID = 7231433491060595223L;
	private Dimension dim;
	private BoxLayout boxCenter;
	private JPanel panelCenter,pnlSifraPredmeta,pnlNazivPredmeta,pnlPredmetniProfesor,pnlGodinaStudija,pnlSemestar,panelBottom;
	private JLabel sifraPredmeta,nazivPredmeta,semestar,godinaStudija,predmetniProfesor;
	private JTextField txtSifraPredmeta,txtNazivPredmeta,txtPredmetniProfesor;
	private JComboBox<String> CBgodina,CBsemestar;
	private Predmet t;
	private JButton potvrdi,odustani;
	
	public IzmjenaPredmeta(JFrame parent, String title, boolean modal) {
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
			
			//Kreiranje centralnog panela sa poljima i labelama
			createPanelCenter();
			
			//Podesi tekstualna polja na vrijednosti polja selektovanog predmeta
			setSelectedItem();
			
			//kreiranje donjeg panel na kojem se naleze dva dugmeta: Potvrda, Odustanak
			createPanelBottom();
			
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void createPanelCenter() {
		panelCenter = new JPanel();
		boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxCenter);
		
		dim = new Dimension(160, 25);
		
		//polje za unos sifre predmeta
		setSifraPredmeta();
				
		//polje za unos naziva predmeta
		setNazivPredmeta();
				
		//polje za predmetnog profesora
		setPredmetniProfesor();
				
		//polje za odabir godine na kojoj se predmet slusa
		setGodinaStudija();
				
		//polje za odabir semestra u kojem se predmet slusa
		setSemestar();	
		
		//dodavanje na centralni panel
		panelCenter.add(pnlSifraPredmeta);
		panelCenter.add(pnlNazivPredmeta);
		panelCenter.add(pnlPredmetniProfesor);
		panelCenter.add(pnlGodinaStudija);
		panelCenter.add(pnlSemestar);
		
		panelCenter.add(Box.createVerticalStrut(50));
		panelCenter.add(Box.createGlue());
		add(panelCenter, BorderLayout.CENTER);	
	}
	private void setSemestar() {
		pnlSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ComboBoxModel<String> cmbSemestar = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4","5","6","7","8"}); 
		semestar = new JLabel();
		semestar.setText("Semestar*");
		semestar.setPreferredSize(dim);
		
		CBsemestar = new JComboBox<String>();
		pnlSemestar.add(semestar);
		pnlSemestar.add(CBsemestar);
		CBsemestar.setModel(cmbSemestar);
	}
	private void setGodinaStudija() {
		pnlGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ComboBoxModel<String> cmbGodinaStudija = new DefaultComboBoxModel<String>(new String[] 
				{"I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010detvrta)"}); 
		godinaStudija = new JLabel();
		godinaStudija.setText("Godina*");
		godinaStudija.setPreferredSize(dim);
		
		CBgodina = new JComboBox<String>();
		pnlGodinaStudija.add(godinaStudija);
		pnlGodinaStudija.add(CBgodina);
		CBgodina.setModel(cmbGodinaStudija);
	}
	private void setPredmetniProfesor() {
		pnlPredmetniProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		predmetniProfesor = new JLabel("Predmetni profesor*");
		predmetniProfesor.setPreferredSize(dim);
		txtPredmetniProfesor = new JTextField();
		txtPredmetniProfesor.setPreferredSize(dim);
		txtPredmetniProfesor.setName("txtPredmetniProfesor");
		
		pnlPredmetniProfesor.add(predmetniProfesor);
		pnlPredmetniProfesor.add(txtPredmetniProfesor);
	}
	private void setNazivPredmeta() {
		pnlNazivPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		nazivPredmeta = new JLabel("Naziv predmeta*");
		nazivPredmeta.setPreferredSize(dim);
		txtNazivPredmeta = new JTextField();
		txtNazivPredmeta.setPreferredSize(dim);
		txtNazivPredmeta.setName("txtNazivPredmeta");
		
		pnlNazivPredmeta.add(nazivPredmeta);
		pnlNazivPredmeta.add(txtNazivPredmeta);
	}
	private void setSifraPredmeta() {
		pnlSifraPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		sifraPredmeta = new JLabel("\u0160ifra predmeta*");
		sifraPredmeta.setPreferredSize(dim);
		txtSifraPredmeta = new JTextField();
		txtSifraPredmeta.setPreferredSize(dim);
		txtSifraPredmeta.setName("txtSifraPredmeta");
		
		pnlSifraPredmeta.add(sifraPredmeta);
		pnlSifraPredmeta.add(txtSifraPredmeta);
	}
	private void setSelectedItem() {
		t = PredmetController.getInstance().vratiSelektovanPredmet(ButtonColumnPredmet.selectedRow);
		txtSifraPredmeta.setText(t.getSifra());
		txtNazivPredmeta.setText(t.getNaziv());
		txtPredmetniProfesor.setText(t.getPredmetniProfesor());
		
		if(t.getGodinaStudija() == 1){
			CBgodina.setSelectedItem("I (prva)");
		}else if(t.getGodinaStudija() == 2){
			CBgodina.setSelectedItem("II (druga)");
		}else if(t.getGodinaStudija() == 3) {
			CBgodina.setSelectedItem("III (tre\\u0107a)");
		}else {
			CBgodina.setSelectedItem("IV (\\u010detvrta)");
		}
		
		if(t.getSemestar() == 1){
			CBsemestar.setSelectedItem("1");
		}else if(t.getSemestar() == 2){
			CBsemestar.setSelectedItem("2");
		}else if(t.getSemestar() == 3) {
			CBsemestar.setSelectedItem("3");
		}else if((t.getSemestar() == 4)) {
			CBsemestar.setSelectedItem("4");
		}else if(t.getSemestar() == 5) {
			CBsemestar.setSelectedItem("5");
		}else if(t.getSemestar() == 6) {
			CBsemestar.setSelectedItem("6");
		}else if(t.getSemestar() == 7) {
			CBsemestar.setSelectedItem("7");
		}else {
			CBsemestar.setSelectedItem("8");
		}
	}
	
	private void createPanelBottom() {
		panelBottom = new JPanel();
		BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
		panelBottom.setLayout(box);
		
		//dodavanje dugmeta za potvdu i reagovanje da dogadjaj klika
		addButtomPotvrdi();	
				
		//dodavanje dugmeta za odustanak i reagovanje da dogadjaj klika
		addButtonOdustani();
		
		//dodavanje kreiranih dugmica na panel
		panelBottom.add(Box.createGlue());
		panelBottom.add(odustani);
		panelBottom.add(Box.createHorizontalStrut(10));
		panelBottom.add(potvrdi);
		panelBottom.add(Box.createHorizontalStrut(10));
				
		add(panelBottom, BorderLayout.SOUTH);
	}
	private void addButtomPotvrdi() {
		potvrdi = new JButton("Potvrda");
		potvrdi.setPreferredSize(new Dimension(100, 30));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sifra = txtSifraPredmeta.getText();
				if(sifra.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaPredmeta.this, "Morate unijeti \u0161ifru predmeta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtSifraPredmeta.requestFocus();
					return;
				}
				
				String naziv = txtNazivPredmeta.getText();
				if(naziv.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaPredmeta.this, "Morate unijeti naziv predmeta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtNazivPredmeta.requestFocus();
					return;
				}
				
				String profesor = txtPredmetniProfesor.getText();
				
				//Samo unos unicode karaktera, razmaka i brojeva je dozvoljen za naziv predmeta
				Pattern pattern1 = Pattern.compile("[a-zA-Z0-9 \\u0160\\u0161\\u0106\\u0107\\u017d\\u017e\\u010c\\u010d\\u0110\\u0111\\u0020]+");
				if(!(pattern1.matcher(naziv)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaPredmeta.this, "Dozvoljen je unos samo slova i brojeva za naziv predmeta!",
							"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtNazivPredmeta.requestFocus();
					return;
				}
				//Samo unos unicode karaktera i razmaka za ime profesora je dozvoljen, ako je  profesor unesen
				if(!profesor.equals("")) {
					Pattern pattern2 = Pattern.compile("[a-zA-Z \\u0160\\u0161\\u0106\\u0107\\u017d\\u017e\\u010c\\u010d\\u0110\\u0111\\u0020]+",
							Pattern.UNICODE_CHARACTER_CLASS);
					if(!(pattern2.matcher(profesor)).matches()) {
						JOptionPane.showMessageDialog(IzmjenaPredmeta.this, "Dozvoljen je unos samo slova za profesora!",
								"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
						txtPredmetniProfesor.requestFocus();
						return;
					}
				}
				
				String god = (String)CBgodina.getSelectedItem();
				int godina;
				if(god.contains("prva"))
					godina=1;
				else if(god.contains("druga"))
					godina=2;
				else if(god.contains("tre\u0107a"))
					godina=3;
				else
					godina=4;
				
				String sem = (String)CBsemestar	.getSelectedItem();
				int semestar=Integer.parseInt(sem);
				
				ArrayList<String> studenti = new ArrayList<String>();
				Predmet p = new Predmet(sifra,naziv,profesor,semestar,godina,studenti);
						
				boolean izmjenjen = PredmetController.getInstance().izmjeniPredmet(ButtonColumnPredmet.selectedRow, t, p);
				if(izmjenjen){
					JOptionPane.showMessageDialog(IzmjenaPredmeta.this, "Uspje\u0161no ste izmijenili predmet!");
					
					//Nakon uspjesne izmjene polja vise nisu selektovana
					ButtonColumnStudent.selectedRow = -1;
					ButtonColumnProfesor.selectedRow = -1;
					ButtonColumnPredmet.selectedRow = -1;
					
					dispose();
				}else{
					JOptionPane.showMessageDialog(IzmjenaPredmeta.this, "Neuspje\u0161na izmjena! Takva \\u0161ifra ve\u0107 predmeta postoji!");
					txtSifraPredmeta.setText("");
					txtSifraPredmeta.requestFocus();
				}
			}
		});
	}
	private void addButtonOdustani() {
		odustani = new JButton("Odustani");
		odustani.setPreferredSize(new Dimension(100, 30));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Da","Ne"};
				int res = JOptionPane.showOptionDialog(IzmjenaPredmeta.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(res == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}
}
