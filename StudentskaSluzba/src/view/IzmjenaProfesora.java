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
import controller.ProfesorController;
import model.Profesor;

/**
 * @author Dragana Carapic
 *
 */
public class IzmjenaProfesora extends JDialog{

	private static final long serialVersionUID = 6216748520173675738L;
	
	private Dimension dim;
	private BoxLayout boxCenter, box;
	private JPanel panelIme,panelPrezime,panelDatum,panelAdresa,panelTelefon,panelEmail,panelAdrKan,panelBrKar,panelTitula,panelZvanje,panelBottom,panelCenter;
	private JLabel ime,prezime,datum,adresa,telefon,email,adresaKan,brLicKar,titula;
	private JComboBox<String> titulaCM;
	private JRadioButton redovan, vanredan, docent;
	private JTextField txtIme,txtPrezime,txtDatum,txtAdresa,txtTelefon,txtAdrKan,txtEmail,txtBrKar;
	private JButton potvrdi,odustani;
	
	
	public IzmjenaProfesora(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initProf(parent);
	}
	
	public void initProf(JFrame parent) {
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
		setEmail();
		setAdrKan();
		setBrKar();
		setTitula();
		setZvanje();
		
		panelCenter.add(panelIme);
		panelCenter.add(panelPrezime);
		panelCenter.add(panelDatum);
		panelCenter.add(panelAdresa);
		panelCenter.add(panelTelefon);
		panelCenter.add(panelEmail);
		panelCenter.add(panelAdrKan);
		panelCenter.add(panelBrKar);
		panelCenter.add(panelTitula);
		panelCenter.add(panelZvanje);

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
		
		adresa = new JLabel("Adresa stanovanja");
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
	
	private void setAdrKan() {
		panelAdrKan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		adresaKan = new JLabel("Adresa kancelarije*");
		adresaKan.setPreferredSize(dim);
		txtAdrKan = new JTextField();
		txtAdrKan.setPreferredSize(dim);
		txtAdrKan.setName("txtAdrKan");
		
		panelAdrKan.add(adresaKan);
		panelAdrKan.add(txtAdrKan);
	}
	
	private void setBrKar() {
		panelBrKar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		brLicKar = new JLabel("Broj li\u010dne karte*");
		brLicKar.setPreferredSize(dim);
		txtBrKar = new JTextField();
		txtBrKar.setPreferredSize(dim);
		txtBrKar.setName("txtBrKar");
		
		panelBrKar.add(brLicKar);
		panelBrKar.add(txtBrKar);
	}
	
	private void setTitula() {
		panelTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		String[] a = new String[] {"Prof. dr", "Dr"}; 
		titula = new JLabel();
		titula.setText("Titula profesora*");
		titula.setPreferredSize(dim);
		
		titulaCM = new JComboBox<String>(a);
		panelTitula.add(titula);
		panelTitula.add(titulaCM);
	}
	
	private void setZvanje() {
		panelZvanje= new JPanel(new FlowLayout(FlowLayout.LEFT));
		redovan = new JRadioButton("Redovni profesor");
		vanredan = new JRadioButton("Vanredni profesor");
		docent =  new JRadioButton("Docent");
		redovan.setSelected(true);
		vanredan.setSelected(false);
		docent.setSelected(false);
		
		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(redovan);
		btnGroup1.add(vanredan);
		btnGroup1.add(docent);
		panelZvanje.add(redovan);
		panelZvanje.add(vanredan);
		panelZvanje.add(docent);
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
		Profesor p = ProfesorController.getInstance().vratiSelektovanogProfesora(ButtonColumnProfesor.selectedRow);
		txtIme.setText(p.getIme());
		txtPrezime.setText(p.getPrezime());
		txtDatum.setText(p.getDatumRodjenja());
		txtAdresa.setText(p.getAdresaStanovanja());
		txtTelefon.setText(p.getTelefon());
		txtAdrKan.setText(p.getAdresaKancelarije());
		txtEmail.setText(p.getEmail());
		txtBrKar.setText(p.getBrLicneKarte());
		
		if(p.getTitula().equals("doktor")){
		titulaCM.setSelectedItem("doktor");
		}else{
		titulaCM.setSelectedItem("docent");
		}
		
		if(p.getZvanje().equals("redovni prof.")){
		redovan.setSelected(true);
		vanredan.setSelected(false);
		}else{
		redovan.setSelected(false);
		vanredan.setSelected(true);
		}
		
		potvrdi = new JButton("Potvrditi");
		potvrdi.setPreferredSize(new Dimension(100, 30));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String imeStr = txtIme.getText();
				if(imeStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti ime profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtIme.requestFocus();
					return;
				}
				
				String przStr = txtPrezime.getText();
				if(przStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti prezime profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				String datStr = txtDatum.getText();
				if(datStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti datum ro\u0111enja profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtDatum.requestFocus();
					return;
				}
				
				String telStr = txtTelefon.getText();
				if(telStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti broj telefona profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtTelefon.requestFocus();
					return;
				}
				
				String adrStr = txtAdrKan.getText();
				if(adrStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti adresu kancelarije profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtAdrKan.requestFocus();
					return;
				}
				
				String emStr = txtEmail.getText();
				if(emStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti e-mail profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtEmail.requestFocus();
					return;
				}
				String bkStr = txtBrKar.getText();
				if(bkStr.equals("")) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Morate unijeti broj li\u010dne karte profesora!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtBrKar.requestFocus();
					return;
				}
				
				//samo unos slova dozvonjen
				Pattern pattern1 = Pattern.compile("[a-zA-Z \\u0160\\u0161\\u0106\\u0107\\u017d\\u017e\\u010c\\u010d\\u0110\\u0111\\u0020]*", Pattern.UNICODE_CHARACTER_CLASS);
				if(!(pattern1.matcher(imeStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Dozvoljen je unos samo slova za ime!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtIme.requestFocus();
					return;
				}
				
				if(!(pattern1.matcher(przStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Dozvoljen je unos samo slova za prezime!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtPrezime.requestFocus();
					return;
				}
				
				Pattern pattern2 = Pattern.compile("[0-9]{9}");
				if(!(pattern2.matcher(bkStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Dozvoljen je samo unos li\u010dne karte od 9 cifara!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtBrKar.requestFocus();
					return;
				}
				
				Pattern pattern3 = Pattern.compile("[0-9]{3}\\/[0-9]{3,4}\\-[0-9]{3}");
				if(!(pattern3.matcher(telStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Dozvoljen je samo unos telefona u formatu XXX/xxx-xxx!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtTelefon.requestFocus();
					return;
				}
				
				Pattern pattern4 = Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}\\.");
				if(!(pattern4.matcher(datStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Dozvoljen je unos samo datuma rodjenja u fromatu dd.MM.yyyy.!");	
					txtDatum.requestFocus();
					return;
				}
				
				Pattern pattern5 = Pattern.compile("[a-zA-Z._]+@[a-zA-Z]+.[a-zA-Z]+");
				if(!(pattern5.matcher(emStr)).matches()) {
					JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Dozvoljen je samo unos email-a u formatu xxxx_yyy@email.com!");	
					txtEmail.requestFocus();
					return;
				}
				
				String titulaStr = (String)titulaCM.getSelectedItem();
				
				String zvanjeStr="";
				if(redovan.isSelected()) {
					zvanjeStr="redovni prof.";
				}else {
					zvanjeStr="vanredni prof.";
				}
				
				String stanStr=txtAdresa.getText();
				
				ArrayList<String> predmeti = new ArrayList<String>();
				Profesor r = new Profesor(imeStr,przStr,datStr,stanStr,telStr,emStr,adrStr,bkStr,titulaStr,zvanjeStr,predmeti);
			
				
				boolean izmjenjen = ProfesorController.getInstance().izmijeniProfesora(ButtonColumnProfesor.selectedRow, p, r);
				if(izmjenjen){
				JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Uspje\u0161no ste izmijenili profesora!");
				PredmetController.getInstance().izmjenaPredmetnogProfesora(p, r);
				
				ButtonColumnStudent.selectedRow=-1;
				ButtonColumnPredmet.selectedRow=-1;
				ButtonColumnProfesor.selectedRow=-1;
				dispose();
				}else{
				JOptionPane.showMessageDialog(IzmjenaProfesora.this, "Neuspje\u0161na izmjena! Takav broj li\u010dne karte ve\u0107 postoji!");
				txtBrKar.setText("");
				txtBrKar.requestFocus();
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
				int res = JOptionPane.showOptionDialog(IzmjenaProfesora.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(res == JOptionPane.YES_OPTION) {
					dispose();
				}
				
			}
		});
	}
}
