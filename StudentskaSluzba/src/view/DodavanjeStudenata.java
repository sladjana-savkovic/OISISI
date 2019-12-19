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
	private JLabel datum;
	private JLabel adresa;
	private JLabel telefon;
	private JLabel indeks;
	private JLabel godina;
	private JComboBox godinaCM;
	private JRadioButton budzet;
	private JRadioButton samofin;
	private JTextField txtIme,txtPrezime,txtDatum,txtAdresa,txtTelefon,txtIndeks;
	
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
			panelCenter.add(Box.createGlue());
			add(panelCenter, BorderLayout.CENTER);
			
			//potvrda uniejtog sadrzaja ili odustanak
			JPanel panelBottom = new JPanel();
			BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
			panelBottom.setLayout(box);
			
			JButton potvrdi = new JButton("Potvrda");
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
						JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Morate unijeti datum rođenja studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
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
					statusStudenta statusStr;
					String godStr = (String)godinaCM.getSelectedItem();
					
					if(budzet.isSelected()) {
						statusStr=statusStudenta.B;	
					}else {
						statusStr = statusStudenta.S;
					}
					
					ArrayList<String> predmeti = new ArrayList<String>();
			Student t = new Student(imeStr,przStr,datStr,adrStr,telStr,"",indStr,"",godStr,0.0,statusStr,predmeti);
					
			boolean unijet = StudentController.getInstance().dodajStudenta(t);
			if(unijet) {
				JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Uspješno ste unijeli studenta!");
				txtIme.setText("");
				txtPrezime.setText("");
				txtDatum.setText("");
				txtAdresa.setText("");
				txtTelefon.setText("");
				txtIndeks.setText("");
			}else {
				JOptionPane.showMessageDialog(DodavanjeStudenata.this, "Neuspješno dodavanje studenta!");
			}
				}
			});
			
			JButton odustani = new JButton("Odustanak");
			odustani.setPreferredSize(new Dimension(100, 30));
			odustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Da","Ne"};
					int res = JOptionPane.showOptionDialog(DodavanjeStudenata.this, "Da li ste sigurni da želite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
