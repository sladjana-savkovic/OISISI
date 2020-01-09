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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.StudentController;
import model.Student;
import model.Student.statusStudenta;

/**
 * @author Dragana Carapic
 *
 */
public class IzmjenaStudenata extends JDialog{
	
	private static final long serialVersionUID = -5071861027363667005L;
	
	private Dimension dim;
	private BoxLayout boxCenter, box;
	private JPanel panelCenter, panelIme,panelPrezime, panelDatum, panelAdresa, panelTelefon,panelIndeks,panelEmail,panelProsjek,panelGodina,panelUpis,panelFin,panelBottom;
	private JLabel ime, prezime, datum, adresa, telefon, indeks, email, prosjek, godina, datumUpisa;
	private JComboBox<String> godinaCM;
	private JRadioButton budzet, samofin;
	private JTextField txtIme,txtPrezime,txtDatum,txtAdresa,txtTelefon,txtIndeks,txtEmail,txtProsjek,txtUpis;
	private JButton potvrdi,odustani;
	
	public IzmjenaStudenata(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initStud();
	}
	
	public void initStud() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			//Dimension screenSize = kit.getScreenSize();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			createPanelCenter();
			
			createPanelBottom();
			
			pack();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createPanelCenter() {
		panelCenter = new JPanel();
		boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxCenter);
		
		dim = new Dimension(160, 25);
		
		setIme();
		setPrezime();
		setDatum();
		setAdresa();
		setTelefon();
		setIndeks();
		setEmail();
		setProsjek();
		setUpis();
		setGodina();
		setFin();
		
		panelCenter.add(panelIme);
		panelCenter.add(panelPrezime);
		panelCenter.add(panelDatum);
		panelCenter.add(panelAdresa);
		panelCenter.add(panelTelefon);
		panelCenter.add(panelIndeks);
		panelCenter.add(panelEmail);
		panelCenter.add(panelProsjek);
		panelCenter.add(panelUpis);
		panelCenter.add(panelGodina);
		panelCenter.add(panelFin);
		
		panelCenter.add(Box.createVerticalStrut(50));
		panelCenter.add(Box.createGlue());
		add(panelCenter, BorderLayout.CENTER);
	}
	
	private void setIme() {
		panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		ime = new JLabel("Ime*");
		ime.setPreferredSize(dim);
		txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		
		panelIme.add(ime);
		panelIme.add(txtIme);
	}
	
	private void setPrezime() {
		panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		prezime = new JLabel("Prezime*");
		prezime.setPreferredSize(dim);
		txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		
		panelPrezime.add(prezime);
		panelPrezime.add(txtPrezime);
	}
	
	private void setDatum() {
		panelDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		datum = new JLabel("Datum rodjenja*");
		datum.setPreferredSize(dim);
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("txtDatum");
		
		panelDatum.add(datum);
		panelDatum.add(txtDatum);
	}
	
	private void setAdresa() {
		panelAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		adresa = new JLabel("Adresa stanovanja*");
		adresa.setPreferredSize(dim);		
		txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dim);
		txtAdresa.setName("txtAdresa");
	
		panelAdresa.add(adresa);
		panelAdresa.add(txtAdresa);
	}
	
	private void setTelefon() {
		 panelTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			telefon = new JLabel("Broj telefona*");
			telefon.setPreferredSize(dim);			
			txtTelefon = new JTextField();
			txtTelefon.setPreferredSize(dim);
			txtTelefon.setName("txtTelefon");
			
			panelTelefon.add(telefon);
			panelTelefon.add(txtTelefon);
	}
	
	private void setIndeks() {
		panelIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		indeks = new JLabel("Broj indeksa*");
		indeks.setPreferredSize(dim);
		txtIndeks = new JTextField();
		txtIndeks.setPreferredSize(dim);
		txtIndeks.setName("txtIndeks");

		panelIndeks.add(indeks);
		panelIndeks.add(txtIndeks);
	}
	
	private void setEmail() {
		panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		email = new JLabel("Email*");
		email.setPreferredSize(dim);
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		
		panelEmail.add(email);
		panelEmail.add(txtEmail);
	}
	
	private void setProsjek() {
		panelProsjek = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		prosjek = new JLabel("Prosje\u010dna ocjena*");
		prosjek.setPreferredSize(dim);
		txtProsjek = new JTextField();
		txtProsjek.setPreferredSize(dim);
		txtProsjek.setName("txtProsjek");
		
		panelProsjek.add(prosjek);
		panelProsjek.add(txtProsjek);
	}
	
	private void setUpis() {
		panelUpis = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		datumUpisa = new JLabel("Datum upisa*");
		datumUpisa.setPreferredSize(dim);
		txtUpis = new JTextField();
		txtUpis.setPreferredSize(dim);
		txtUpis.setName("txtUpis");
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.US);
		Calendar todaysDate = Calendar.getInstance();
		txtUpis.setText(dateFormat.format(todaysDate.getTime()));
		
		panelUpis.add(datumUpisa);
		panelUpis.add(txtUpis);
	}
	
	private void setGodina() {
		panelGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		String[] a = new String[] {"I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010detvrta)"};
		//ComboBoxModel godinaStudija = new DefaultComboBoxModel(new String[] {"I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010detvrta)"}); 
		godina = new JLabel();
		godina.setText("Trenutna godina studija*");
		godina.setPreferredSize(dim);
		
		godinaCM = new JComboBox<String>(a);
		panelGodina.add(godina);
		panelGodina.add(godinaCM);
	}
	
	private void setFin() {
		panelFin = new JPanel(new FlowLayout(FlowLayout.LEFT));
		budzet = new JRadioButton("Budzet");
		samofin = new JRadioButton("Samofinansiranje");
		budzet.setSelected(true);
		samofin.setSelected(false);
		
		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(budzet);
		btnGroup1.add(samofin);
		panelFin.add(budzet);
		panelFin.add(samofin);
	}
	
	private void createPanelBottom() {
		panelBottom = new JPanel();
		box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
		panelBottom.setLayout(box);
		
		addButtonPotvrdi();
		
		addButtonOdustani();
		
		panelBottom.add(Box.createGlue());
		panelBottom.add(odustani);
		panelBottom.add(Box.createHorizontalStrut(10));
		panelBottom.add(potvrdi);
		panelBottom.add(Box.createHorizontalStrut(10));
		
		add(panelBottom, BorderLayout.SOUTH);
	}
	
	private void addButtonPotvrdi() {
		Student t = StudentController.getInstance().vratiSelektovanogStudenta(ButtonColumnStudent.selectedRow);
		txtIme.setText(t.getIme());
		txtPrezime.setText(t.getPrezime());
		txtDatum.setText(t.getDatumRodjenja());
		txtAdresa.setText(t.getAdresaStanovanja());
		txtTelefon.setText(t.getBrojTelefona());
		txtIndeks.setText(t.getBrojIndeka());
		txtEmail.setText(t.getEmailAdresa());
		txtProsjek.setText(Double.toString(t.getProsjecnaOcjena()));
		txtUpis.setText(t.getDatumUpisa());
		
		if(t.getTrenutnaGodinaStudija()==1) {
		godinaCM.setSelectedItem("I (prva)");
		} else if(t.getTrenutnaGodinaStudija()==2) {
		godinaCM.setSelectedItem("II (druga)");
		}else if(t.getTrenutnaGodinaStudija()==3) {
		godinaCM.setSelectedItem("III (tre\u0107a)");
		}else {
		godinaCM.setSelectedItem("IV (\u010detvrta)");
		}
		
		if(t.getStatus()==statusStudenta.B) {
			budzet.setSelected(true);
			samofin.setSelected(false);
		}else {
			samofin.setSelected(true);
			budzet.setSelected(false);
		}
		
		potvrdi = new JButton("Potvrditi");
		potvrdi.setPreferredSize(new Dimension(100, 30));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String imeStr = txtIme.getText();
				if(imeStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti ime studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtIme.requestFocus();
					return;
				}
				
				String przStr = txtPrezime.getText();
				if(przStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti prezime studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				String datStr = txtDatum.getText();
				if(datStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti datum ro\u0111enja studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				String adrStr = txtAdresa.getText();
				if(adrStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti adresu studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtAdresa.requestFocus();
					return;
				}
				
				String telStr = txtTelefon.getText();
				if(telStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti broj telefona studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtTelefon.requestFocus();
					return;
				}
				
				String indStr = txtIndeks.getText();
				if(indStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti broj indeksa studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtIndeks.requestFocus();
					return;
				}
				String emStr = txtEmail.getText();
				if(emStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti e-mail studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtEmail.requestFocus();
					return;
				}
				
				String proStr = txtProsjek.getText();
				if(proStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Morate unijeti prosje\\u010dnu ocjenu studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtProsjek.requestFocus();
					return;
				}
				//samo unos slova dozvonjen
				Pattern pattern1 = Pattern.compile("[a-zA-Z \\u0160\\u0161\\u0106\\u0107\\u017d\\u017e\\u010c\\u010d\\u0110\\u0111\\u0020]*", Pattern.UNICODE_CHARACTER_CLASS);
				if(!(pattern1.matcher(imeStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Dozvoljen je unos samo slova za ime!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtIme.requestFocus();
					return;
				}
				
				if(!(pattern1.matcher(przStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Dozvoljen je unos samo slova za prezime!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				//samo brojevi za telefon, /, -
				Pattern pattern2 = Pattern.compile("[0-9]{3}\\/[0-9]{3,4}\\-[0-9]{3}");
				if(!(pattern2.matcher(telStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Dozvoljen je samo unos telefona u formatu XXX/xxx-xxx!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtTelefon.requestFocus();
					return;
				}
				
				//slova i brojevi za indeks
				Pattern pattern3 = Pattern.compile("[a-zA-Z0-9]+/[0-9]+");
				if(!(pattern3.matcher(indStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Dozvoljen je unos samo brojeva i slova za indeks u formaru YYxx/zzzz!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtIndeks.requestFocus();
					return;
				}
			
				//prosjek brojevi i tacka
				Pattern pattern4 = Pattern.compile("[0-9]+.[0-9]+");
				if(!(pattern4.matcher(proStr)).matches()) {
				JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva za prosjek studenta u fromatu 0.0!");
				txtProsjek.setText("");
				txtProsjek.requestFocus();
				return;
				}
				
				statusStudenta statusStr;
				String godStr = (String)godinaCM.getSelectedItem();
				int god;
				if(godStr.contains("prva")) {
					god=1;
				}else if(godStr.contains("druga")) {
					god=2;
				}else if(godStr.contains("tre\u0107a")) {
					god=3;
				}else {
					god=4;
				}
				
				if(budzet.isSelected()) {
					statusStr=statusStudenta.B;	
				}else {
					statusStr = statusStudenta.S;
				}
				
				double pros=Double.parseDouble(txtProsjek.getText());
				String upisStr = txtUpis.getText();
				ArrayList<String> predmeti = new ArrayList<String>();
				
				Student r = new Student(imeStr,przStr,datStr,adrStr,telStr,emStr,indStr,upisStr,god,pros,statusStr,predmeti);
				String stariIndeks = t.getBrojIndeka();
				String noviIndeks = r.getBrojIndeka();
				
				boolean izmjenjen = StudentController.getInstance().izmjeniStudenta(ButtonColumnStudent.selectedRow, t, r);
				if(izmjenjen) {
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Uspje\u0161no ste izmijenili studenta!");
					
					PredmetController.getInstance().izmjenaListeStudenata(stariIndeks, noviIndeks);
					
					ButtonColumnStudent.selectedRow = -1;
					ButtonColumnPredmet.selectedRow = -1;
					ButtonColumnProfesor.selectedRow = -1;
					dispose();
				}else{
					JOptionPane.showMessageDialog(IzmjenaStudenata.this, "Neuspje\u0161na izmjena! Takav broj indeksa ve\u0107 postoji!");
				txtIndeks.setText("");
				txtIndeks.requestFocus();
				}
				
			}
		});
	}
	
	private void addButtonOdustani() {
		odustani = new JButton("Odustati");
		odustani.setPreferredSize(new Dimension(100, 30));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Da","Ne"};
				int res = JOptionPane.showOptionDialog(IzmjenaStudenata.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(res == JOptionPane.YES_OPTION) {
					dispose();
				}
				
			}
		});
	}
	
}
