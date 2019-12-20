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
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import model.Predmet;
import model.Student;
import model.Student.statusStudenta;

/**
 * @author Dragana Carapic
 *
 */
public class DodavanjeStudenata extends JDialog{
	private JLabel ime;
	private JLabel prezime;
	//datum rodjenja
	private JLabel datum;
	private JLabel adresa;
	private JLabel telefon;
	private JLabel indeks;
	private JLabel email;
	private JLabel prosjek;
	private JLabel godina;
	private JLabel datumUpisa;
	private JComboBox godinaCM;
	private JRadioButton budzet;
	private JRadioButton samofin;
	private JTextField txtIme,txtPrezime,txtDatum,txtAdresa,txtTelefon,txtIndeks,txtEmail,txtProsjek,txtUpis;
	
	public DodavanjeStudenata(JFrame parent, String title, boolean modal) {
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
			
			JPanel panelCenter = new JPanel();
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			
			Dimension dim = new Dimension(160, 25);
			
			//polje za unos imena
			JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			ime = new JLabel("Ime*");
			ime.setPreferredSize(dim);
			txtIme = new JTextField();
			txtIme.setPreferredSize(dim);
			txtIme.setName("txtIme");
			
			panelIme.add(ime);
			panelIme.add(txtIme);
		
			//polje za unos prezimena
			JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			prezime = new JLabel("Prezime*");
			prezime.setPreferredSize(dim);
			txtPrezime = new JTextField();
			txtPrezime.setPreferredSize(dim);
			txtPrezime.setName("txtPrezime");
			
			panelPrezime.add(prezime);
			panelPrezime.add(txtPrezime);
			
			//polje za unos datuma rodjenja
			JPanel panelDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			datum = new JLabel("Datum rodjenja*");
			datum.setPreferredSize(dim);
			txtDatum = new JTextField();
			txtDatum.setPreferredSize(dim);
			txtDatum.setName("txtPrezime");
			
			panelDatum.add(datum);
			panelDatum.add(txtDatum);
			
			//polje za unos adrese
			JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
					
			adresa = new JLabel("Adresa stanovanja*");
			adresa.setPreferredSize(dim);		
			txtAdresa = new JTextField();
			txtAdresa.setPreferredSize(dim);
			txtAdresa.setName("txtAdresa");
		
			panelAdresa.add(adresa);
			panelAdresa.add(txtAdresa);
			
			//polje za unos telefona
			JPanel panelTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			telefon = new JLabel("Broj telefona*");
			telefon.setPreferredSize(dim);			
			txtTelefon = new JTextField();
			txtTelefon.setPreferredSize(dim);
			txtTelefon.setName("txtTelefon");
			
			panelTelefon.add(telefon);
			panelTelefon.add(txtTelefon);
			
			//polje za unos broja indeksa
			JPanel panelIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			indeks = new JLabel("Broj indeksa*");
			indeks.setPreferredSize(dim);
			txtIndeks = new JTextField();
			txtIndeks.setPreferredSize(dim);
			txtIndeks.setName("txtIndeks");

			panelIndeks.add(indeks);
			panelIndeks.add(txtIndeks);
			
			//polje za unos email-a
			JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			email = new JLabel("Email*");
			email.setPreferredSize(dim);
			txtEmail = new JTextField();
			txtEmail.setPreferredSize(dim);
			txtEmail.setName("txtEmail");
			
			panelEmail.add(email);
			panelEmail.add(txtEmail);
			
			//polje za unos prosjeka
			JPanel panelProsjek = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			prosjek = new JLabel("Prosje\u010dna ocjena*");
			prosjek.setPreferredSize(dim);
			txtProsjek = new JTextField();
			txtProsjek.setPreferredSize(dim);
			txtProsjek.setName("txtProsjek");
			
			panelProsjek.add(prosjek);
			panelProsjek.add(txtProsjek);
			
			//polje za unos datuma upisa na faks
			JPanel panelUpis = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
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
			
			//polje za odabir godine studija
			JPanel panelGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
			ComboBoxModel godinaStudija = new DefaultComboBoxModel(new String[] {"I (prva)", "II (druga)", "III (tre\u0107a)", "IV (cetvrta)"}); 
			godina = new JLabel();
			godina.setText("Trenutna godina studija*");
			godina.setPreferredSize(dim);
			
			godinaCM = new JComboBox();
			panelGodina.add(godina);
			panelGodina.add(godinaCM);
			godinaCM.setModel(godinaStudija);
			
			//dugmici za izbor nacina finansiranja
			JPanel panelFin = new JPanel(new FlowLayout(FlowLayout.LEFT));
			budzet = new JRadioButton("Budzet");
			samofin = new JRadioButton("Samofinansiranje");
			budzet.setSelected(true);
			samofin.setSelected(false);
			
			ButtonGroup btnGroup1 = new ButtonGroup();
			btnGroup1.add(budzet);
			btnGroup1.add(samofin);
			panelFin.add(budzet);
			panelFin.add(samofin);
			
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
			
			//potvrda uniejtog sadrzaja ili odustanak
			JPanel panelBottom = new JPanel();
			BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
			panelBottom.setLayout(box);
			
			JButton potvrdi = new JButton("Potvrditi");
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
					char c = txtProsjek.getText().charAt(0);
					if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
							&& c != '9' && c!='.') {
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
					}else if(godStr.contains("tre\\u0107a")) {
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
					String emStr1 = txtEmail.getText();
					String upisStr = txtUpis.getText();
					
					ArrayList<String> predmeti = new ArrayList<String>();
			Student t = new Student(imeStr,przStr,datStr,adrStr,telStr,emStr1,indStr,upisStr,god,pros,statusStr,predmeti);
					
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
			}else{
				JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Neuspje\u0161no dodavanje studenta, provjerite da li postoji student sa tim brojem indeksa!");
			}
				}
			});
			
			JButton odustani = new JButton("Odustati");
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
