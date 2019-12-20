/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Dragana Carapic
 *
 */
public class IzmjenaStudenata extends JDialog{
	
	private static final long serialVersionUID = -5071861027363667005L;
	
	private JLabel ime;
	private JLabel prezime;
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
			
			JPanel panelBottom = new JPanel();
			BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
			panelBottom.setLayout(box);
			
			JButton potvrdi = new JButton("Potvrditi");
			potvrdi.setPreferredSize(new Dimension(100, 30));
			
			JButton odustani = new JButton("Odustati");
			odustani.setPreferredSize(new Dimension(100, 30));
			
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
