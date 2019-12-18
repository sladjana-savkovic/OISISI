/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

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
public class UnosStudenta extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2430739024892834600L;
	private JLabel ime;
	private JLabel prezime;
	private JLabel datum;
	private JLabel adresa;
	private JLabel telefon;
	private JLabel indeks;
	private JLabel godina;
	private JComboBox godinaCM;
	private JRadioButton budzet;
	private JRadioButton samofin;
	private JTextField txtIme,txtPrezime,txtDatum,txtAdresa,txtTelefon,txtIndeks;
	private Color darkerBlue= new Color(0,200,200);
	
	public UnosStudenta(JFrame parent, String title, boolean modal) {
		super(parent,title,modal);
		
		//setTitle("Dodavanje studenta");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width * 1 / 4, screenSize.height * 1 / 4);
		Image img=kit.getImage("logo_images/ftn.png");
		
		JPanel panelCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxCenter);
		
		Dimension dim = new Dimension(160, 25);
		
		//polje za unos imena
		JPanel panelIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		ime = new JLabel();
		panelIme.add(ime);
		ime.setText("Ime*");
		ime.setPreferredSize(dim);
		
		txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		panelIme.add(ime);
		panelIme.add(txtIme);
	
		//polje za unos prezimena
		JPanel panelPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		prezime = new JLabel();
		panelPrezime.add(prezime);
		prezime.setText("Prezime*");
		prezime.setPreferredSize(dim);
		
		txtPrezime = new JTextField();
		txtPrezime.setPreferredSize(dim);
		panelPrezime.add(prezime);
		panelPrezime.add(txtPrezime);
		
		//polje za unos datuma rodjenja
		JPanel panelDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		datum = new JLabel();
		panelDatum.add(datum);
		datum.setText("Datum rodjenja*");
		datum.setPreferredSize(dim);
		
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		panelDatum.add(datum);
		panelDatum.add(txtDatum);
		
		//polje za unos adrese
		JPanel panelAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
				
		adresa = new JLabel();
	    panelAdresa.add(adresa);
		adresa.setText("Adresa stanovanja*");
		adresa.setPreferredSize(dim);
				
		txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dim);
		panelAdresa.add(adresa);
		panelAdresa.add(txtAdresa);
		
		//polje za unos telefona
		JPanel panelTelefon = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		telefon = new JLabel();
	    panelTelefon.add(telefon);
		telefon.setText("Broj telefona*");
		telefon.setPreferredSize(dim);
				
		txtTelefon = new JTextField();
		txtTelefon.setPreferredSize(dim);
		panelTelefon.add(telefon);
		panelTelefon.add(txtTelefon);
		
		//polje za unos broja indeksa
		JPanel panelIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		indeks = new JLabel();
	    panelIndeks.add(indeks);
		indeks.setText("Broj indeksa*");
		indeks.setPreferredSize(dim);
				
		txtIndeks = new JTextField();
		txtIndeks.setPreferredSize(dim);
		panelIndeks.add(indeks);
		panelIndeks.add(txtIndeks);
		
		//polje za odabir godine studija
		JPanel panelGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ComboBoxModel godinaStudija = new DefaultComboBoxModel(new String[] {"I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)"}); 
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
		panelCenter.add(panelGodina);
		panelCenter.add(panelFin);
		
		panelCenter.add(Box.createVerticalStrut(50));
		add(panelCenter, BorderLayout.CENTER);
		
		//potvrda uniejtog sadrzaja ili odustanak
		JPanel panelBottom = new JPanel();
		BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
		panelBottom.setLayout(box);
		
		JButton potvrdi = new JButton("Potvrda");
		potvrdi.setPreferredSize(new Dimension(100, 30));
		potvrdi.setBackground(darkerBlue);
		
		JButton odustani = new JButton("Odustanak");
		odustani.setPreferredSize(new Dimension(100, 30));
		odustani.setBackground(darkerBlue);
		
		panelBottom.add(Box.createGlue());
		panelBottom.add(odustani);
		panelBottom.add(Box.createHorizontalStrut(10));
		panelBottom.add(potvrdi);
		panelBottom.add(Box.createHorizontalStrut(10));
		
		add(panelBottom, BorderLayout.SOUTH);
		pack();
		
	}
	
}
