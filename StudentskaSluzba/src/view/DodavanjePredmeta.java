/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;

import controller.PredmetController;
import controller.ProfesorController;
import model.Predmet;
import model.Profesor;

/**
 * @author Sladjana Savkovic
 *
 */
public class DodavanjePredmeta extends JDialog{

	private static final long serialVersionUID = -4761031862006107617L;
	
	private Dimension dim;
	private BoxLayout boxCenter,box;
	private JPanel panelCenter,pnlSifraPredmeta,pnlNazivPredmeta,pnlProfesorLicna,pnlGodinaStudija,pnlSemestar,panelBottom;
	private JLabel sifraPredmeta,nazivPredmeta,semestar,godinaStudija,profesorLicna;
	private JTextField txtSifraPredmeta,txtNazivPredmeta,txtProfesorLicna;
	private JComboBox<String> CBgodina,CBsemestar;
	private JButton potvrdi,odustani;
	
	public DodavanjePredmeta(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initPredmeti(parent);
	}
	public void initPredmeti(JFrame parent) {
		
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(parent);
			
			//Kreiranje centralnog panela sa poljima i labelama
			createPanelCenter();
			
			//kreiranje donjeg panel na kojem se naleze dva dugmeta: Potvrda, Odustanak
			createPanelBottom();
			
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createPanelCenter() {
		//Kreiranje centralnog panela
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
		panelCenter.add(pnlProfesorLicna);
		panelCenter.add(pnlGodinaStudija);
		panelCenter.add(pnlSemestar);
		
		panelCenter.add(Box.createVerticalStrut(50));
		panelCenter.add(Box.createGlue());
		add(panelCenter, BorderLayout.CENTER);
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
	private void setPredmetniProfesor() {
		pnlProfesorLicna = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		profesorLicna = new JLabel("Predmetni profesor (li\u010dna)");
		profesorLicna.setPreferredSize(dim);
		txtProfesorLicna = new JTextField();
		txtProfesorLicna.setPreferredSize(dim);
		txtProfesorLicna.setName("txtPredmetniProfesor");
		
		pnlProfesorLicna.add(profesorLicna);
		pnlProfesorLicna.add(txtProfesorLicna);
	}
	private void setGodinaStudija() {
		pnlGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		ComboBoxModel<String> cmbGodinaStudija = new DefaultComboBoxModel<String>(new String[] {"I (prva)", "II (druga)", "III (tre\u0107a)", "IV (\u010detvrta)"}); 
		godinaStudija = new JLabel();
		godinaStudija.setText("Godina*");
		godinaStudija.setPreferredSize(dim);
		
		CBgodina = new JComboBox<String>();
		pnlGodinaStudija.add(godinaStudija);
		pnlGodinaStudija.add(CBgodina);
		CBgodina.setModel(cmbGodinaStudija);
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
	
	private void createPanelBottom() {
		//kreiranje panela koji ce sadrzati dva nova dugmeta za potvrdu i odustanak
		panelBottom = new JPanel();
		box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
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
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Morate unijeti \u0161ifru predmeta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtSifraPredmeta.requestFocus();
					return;
				}
				
				String naziv = txtNazivPredmeta.getText();
				if(naziv.equals("")) {
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Morate unijeti naziv predmeta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
					txtNazivPredmeta.requestFocus();
					return;
				}
				
				String licnaProfesora = txtProfesorLicna.getText();
				
				//samo unos slova i brojeva je dozvoljen za sifru predmeta
				Pattern pattern1 = Pattern.compile("[a-zA-Z0-9]+");
				if(!(pattern1.matcher(sifra)).matches()) {
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Dozvoljen je unos slova i brojeva za \u0161ifru predmeta!",
							"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtSifraPredmeta.requestFocus();
					return;
				}
				
				//samo unos unicode karaktera, brojeva i razmaka je dozvoljen za naziv predmeta
				Pattern pattern2 = Pattern.compile("[a-zA-Z0-9 \\u0160\\u0161\\u0106\\u0107\\u017d\\u017e\\u010c\\u010d\\u0110\\u0111\\u0020]+");
				if(!(pattern2.matcher(naziv)).matches()) {
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Dozvoljen je unos slova, brojeva i razmaka za naziv predmeta!",
							"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					txtNazivPredmeta.requestFocus();
					return;
				}
				
				//Samo unos unicode karaktera i razmaka za ime profesora je dozvoljen, ako je  profesor unesen
				if(!licnaProfesora.equals("")) {
					Pattern pattern3 = Pattern.compile("[0-9]{9}", Pattern.UNICODE_CHARACTER_CLASS);
					if(!(pattern3.matcher(licnaProfesora)).matches()) {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Dozvoljen je samo unos li\u010dne karte od devet cifara!",
								"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
						txtProfesorLicna.requestFocus();
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
				
				String sem = (String)CBsemestar.getSelectedItem();
				int semestar=Integer.parseInt(sem);
				
				if (((godina==1)&&(semestar>2)) || ((godina==2)&&(semestar<3 || semestar>4)) || ((godina==3)&&(semestar<5 || semestar>6)) || ((godina==4)&&(semestar<7))) {
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Izabrali ste pogre\u0161an semestar!",
							"Upozorenje", JOptionPane.INFORMATION_MESSAGE);
					CBsemestar.requestFocus();
					return;
				}
				
				ArrayList<String> studenti = new ArrayList<String>();	//Lista studenata ce na pocetku biti prazna
				Profesor profesor = new Profesor();
				
				if(!licnaProfesora.equals("")) {
					if(!PredmetController.getInstance().profesorNaPredmetu(licnaProfesora)) {
						JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Ne postoji profesor sa unesenom li\u010dnom kartom!");
						txtProfesorLicna.requestFocus();
						txtProfesorLicna.setText("");
						return;
					}else {
						profesor = ProfesorController.getInstance().getProfesorPrimaryKey(licnaProfesora);
					}
				}
				else {
					profesor = null;
				}
				
				Predmet p = new Predmet(sifra,naziv,profesor,semestar,godina,studenti);
				
				//Dodavanje novog predmeta i provjera da li je dodavanje uspjesno
				boolean unesen = PredmetController.getInstance().dodajPredmet(p);
				if(unesen) {
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Uspje\u0161no ste dodali predmet!");
					txtSifraPredmeta.setText("");
					txtNazivPredmeta.setText("");
					txtProfesorLicna.setText("");
					 
					//profesoru koji je na predmetu treba dodati taj predmet
					if(!licnaProfesora.equals("")) {
						ProfesorController.getInstance().dodajPredmetNaProfesora(licnaProfesora, sifra);
					}
					
					//Nakon uspjesnog dodavanja, polja vise nisu selektovana
					ButtonColumnStudent.selectedRow = -1;
					ButtonColumnProfesor.selectedRow = -1;
					ButtonColumnPredmet.selectedRow = -1;
					
					dispose();
				}else {
					JOptionPane.showMessageDialog(DodavanjePredmeta.this, "Neuspje\u0161no dodavanje predmeta, provjerite da li postoji predmet sa tom \u0161ifrom!");
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
				int res = JOptionPane.showOptionDialog(DodavanjePredmeta.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(res == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}
}

