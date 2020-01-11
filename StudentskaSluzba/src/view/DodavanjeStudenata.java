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

import controller.StudentController;
import model.Student;
import model.Student.statusStudenta;

/**
 * @author Dragana Carapic
 *
 */
public class DodavanjeStudenata extends JDialog{
	
	private static final long serialVersionUID = -3387410154192921629L;
	
	private Dimension dim;
	private BoxLayout boxCenter, box;
	private JPanel panelCenter, panelIme,panelPrezime, panelDatum, panelAdresa, panelTelefon,panelIndeks,panelEmail,panelProsjek,panelGodina,panelUpis,panelFin,panelBottom;
	private JLabel ime, prezime, datum, adresa, telefon, indeks, email, prosjek, godina, datumUpisa;
	private JComboBox<String> godinaCM;
	private JRadioButton budzet, samofin;
	private JTextField txtIme,txtPrezime,txtDatum,txtAdresa,txtTelefon,txtIndeks,txtEmail,txtProsjek,txtUpis;
	private JButton potvrdi,odustani;
	
	public DodavanjeStudenata(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initStud(parent);
	}
	
	public void initStud(JFrame parent) {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(parent);
			
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
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.", Locale.US);
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
	
	private void addButtonPotvrdi(){
		potvrdi = new JButton("Potvrditi");
		potvrdi.setPreferredSize(new Dimension(100, 30));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String imeStr = txtIme.getText();
				if(imeStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti ime studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtIme.requestFocus();
					return;
				}
				
				String przStr = txtPrezime.getText();
				if(przStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti prezime studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				String datStr = txtDatum.getText();
				if(datStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti datum ro\u0111enja studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				String adrStr = txtAdresa.getText();
				if(adrStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti adresu studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtAdresa.requestFocus();
					return;
				}
				
				String telStr = txtTelefon.getText();
				if(telStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti broj telefona studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtTelefon.requestFocus();
					return;
				}
				
				String indStr = txtIndeks.getText();
				if(indStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti broj indeksa studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtIndeks.requestFocus();
					return;
				}
				String emStr = txtEmail.getText();
				if(emStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti e-mail studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtEmail.requestFocus();
					return;
				}
				
				String proStr = txtProsjek.getText();
				if(proStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti prosje\\u010dnu ocjenu studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtProsjek.requestFocus();
					return;
				}
				
				String upisStr = txtUpis.getText();
				if(upisStr.equals("")) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti datum upisa studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtUpis.requestFocus();
					return;
				}
				//samo unos slova dozvonjen
				Pattern pattern1 = Pattern.compile("[a-zA-Z \\u0160\\u0161\\u0106\\u0107\\u017d\\u017e\\u010c\\u010d\\u0110\\u0111\\u0020]*", Pattern.UNICODE_CHARACTER_CLASS);
				if(!(pattern1.matcher(imeStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je unos samo slova za ime!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtIme.requestFocus();
					return;
				}
				
				if(!(pattern1.matcher(przStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je unos samo slova za prezime!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				Pattern pattern5 = Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}\\.");
				if(!(pattern5.matcher(datStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je unos samo datuma ro\u0111enja u fromatu dd.MM.yyyy.!");	
					txtDatum.requestFocus();
					return;
				}
				
				//samo brojevi za telefon, /, -
				Pattern pattern2 = Pattern.compile("[0-9]{3}\\/[0-9]{3,4}\\-[0-9]{3}");
				if(!(pattern2.matcher(telStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je samo unos telefona u formatu XXX/xxx-xxx!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtTelefon.requestFocus();
					return;
				}
				
				//slova i brojevi za indeks
				Pattern pattern3 = Pattern.compile("[a-zA-Z0-9]+/[0-9]+");
				if(!(pattern3.matcher(indStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je unos samo brojeva i slova za indeks u formaru YYxx/zzzz!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtIndeks.requestFocus();
					return;
				}
			
				Pattern pattern6 = Pattern.compile("[a-zA-Z._]+@[a-zA-Z]+.[a-zA-Z]+");
				if(!(pattern6.matcher(emStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je samo unos email-a u formatu xxxx_yyy@email.com!");	
					txtEmail.requestFocus();
					return;
				}
				
				Pattern pattern4 = Pattern.compile("[0-9]+.[0-9]+");
				if(!(pattern4.matcher(proStr)).matches()) {
				JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je unos samo brojeva za prosjek studenta u fromatu 0.0!");
				txtProsjek.setText("");
				txtProsjek.requestFocus();
				return;
				}
				
				if(!(pattern5.matcher(upisStr)).matches()) {
					JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Dozvoljen je unos samo datuma upisa u fromatu dd.MM.yyyy.!");	
					txtUpis.requestFocus();
					return;
				}

	
				
				String godStr = (String)godinaCM.getSelectedItem();
				int god;
				if(godStr.contains("prva")) {
					god=1;
				}else if(godStr.contains("druga")) {
					god=2;
				}else if(godStr.contains("tre\\u0107a")) {
					god=3;
				}else {
					god=4;
				}
				
				statusStudenta statusStr;
				if(budzet.isSelected()) {
					statusStr=statusStudenta.B;	
				}else {
					statusStr = statusStudenta.S;
				}
				
				double pros=Double.parseDouble(txtProsjek.getText());
	
				ArrayList<String> predmeti = new ArrayList<String>();
		Student t = new Student(imeStr,przStr,datStr,adrStr,telStr,emStr,indStr,upisStr,god,pros,statusStr,predmeti);
				
		boolean unijet1 = StudentController.getInstance().dodajStudenta(t);
		if(unijet1==true) {
			JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Uspje\u0161no ste dodali studenta!");
			txtIme.setText("");
			txtPrezime.setText("");
			txtDatum.setText("");
			txtAdresa.setText("");
			txtTelefon.setText("");
			txtIndeks.setText("");
			txtEmail.setText("");
			txtProsjek.setText("");
			dispose();
		}else{
			JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Neuspje\u0161no dodavanje studenta, provjerite da li postoji student sa tim brojem indeksa!");
		}
			}
		});
	}
	
	private void addButtonOdustani() {
		odustani = new JButton("Odustati");
		odustani.setPreferredSize(new Dimension(100, 30));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Da","Ne"};
				int res = JOptionPane.showOptionDialog(DodavanjeStudenata.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(res == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}
}
