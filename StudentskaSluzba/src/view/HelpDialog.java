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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Dragana Carapic
 *
 */
public class HelpDialog extends JDialog{
	
	private static final long serialVersionUID = -3632735653801850558L;
	
	private JLabel text, text1;
	private JTextArea a1,a2;
	
	public HelpDialog(JFrame parent, String title, boolean modal) {
		super(parent,title,modal);
		init(parent);
		
	}
	
	public void init(JFrame parent) {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(450,500);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(parent);
	
			
			JPanel panelCenter = new JPanel(new BorderLayout());
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			//panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			
			Dimension dim = new Dimension(180, 20);
			Dimension dim1 = new Dimension(410, 160);
			
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			text = new JLabel("O aplikaciji");
			text.setPreferredSize(dim);
			panel1.add(text);
			
			//JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			a1= new JTextArea(
					" Aplikacija prikazuje informacioni sistem studenstke slu\u017ebe i sadr\u017ei\n"
					+ " opcije za rukovanje podacima tog sistema. Osnovne funkcionalnosti\n"
					+ " aplikacije su dodavanje, izmjena i brisanje entiteta sistema.\n"+ 
					" Postoje\u0107i entiteti se mogu sortirati  i pretra\u017eiti po odre\u0111enom\n"+
					" kriterijumu. Entitete sistema \u010dine student, profesor i predmet.\n"+
					" Svaki entitet sadr\u017ei svoju tabelu sa podacima nad kojima korisnik\n" +
					" primjenjuje gore navedene funkcionalnosti.\n"+
					" Glavni prozor aplikacije sadr\u017ei prikaz trenurnog vremena i datuma,\n"
					+ " a tako\u0111e omogu\u0107ava korisniku izlaz iz aplikacije, minimizaciju i \n"
					+ " maksimizaciju prozora.\n"+
					" Biografije autora se nalaze u stavci menija pod nazivom \"O nama\".");
			a1.setMaximumSize(dim1);
			//a1.getPreferredScrollableViewportSize();
			//a1.setMaximumSize(getPreferredSize());
			a1.setBackground(getBackground());
			a1.setEditable(false);
			
			JScrollPane scroll = new JScrollPane(a1);
			scroll.setPreferredSize(dim1);
			//scroll.setMaximumSize(dim1);
	        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        //scroll.setMaximumSize(dim1);
			
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			text1 = new JLabel("Rukovanje aplikacijom");
			text1.setPreferredSize(dim);
			
			panel2.add(text1);
			
			//JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			a2= new JTextArea(
					" Glavni prozor aplikacije sadr\u017ei meni bar, toolbar, tabove sa\n"
					+ " tabelama entiteta i status bar. Osnovnim funkcionalnostima\n "
					+ " sistema korisnik moze da pristupi koriste\u0107i meni bar ili toolbar.\n" + 
					" U zavisnosti koja tabela entiteta je trenutno vidljiva, osnovne\n "
					+ " funkcionalnosti se pozivaju nad tom tabelom.\n"
					+ " Pre\u010dice za prikaz dijaloga za dodavanje Studenta/Profesora/Predmeta\n"
					+ " su ALT+D i CTRL+D, za izmjenu ALT+I i CTRL+I, za brisanje ALT+B i \n"
					+ " CTRL+B. Pre\u010dice za odabir tabele koja ce biti vidljiva su: ALT+S za \n"
					+ " studente, ALT+P za profesore i ALT+R za predmete.\n"
					+ " Pre\u010dica za pretragu podataka nad tabelom je ALT+T.\n" + 
					" Dijaloge \"Pomo\u0107\" i \"O nama\" je mogu\u0107e prikazati pomo\u0107u CTRL+P,\n "
					+ " CTRL+O respektivno. Pre\u010dica za zatvaranje aplikacije je CTRL+Z.\n" + 
					" Dodavanje entiteta u sistem \u0107e biti uspje\u0161no ako je korisnik validno\n"
					+ " unio sva polja. Da bi izmijenili podatke nekog od entiteta, ili ga\n"
					+ " obrisali neophodno je selektovati odgovaraju\u0107i red u tabeli. Nakon \n"
					+ " uspje\u0161ne izmjene, novi podaci \u0107e biti prikazani u tabeli, kao i na\n"
					+ " svim ostalim mjestima gdje se taj podatak prikazuje. Npr. ako \n"
					+ " korisnik promjeni indeks studenta, ta promjena ce biti vidljiva i u\n "
					+ " tabeli predmet na spisku studenata na kome se nalazi izmijenjeni \n"
					+ " student. Po sli\u010dnom principu se obavlja i brisanje. \n" + 
					" Pretraga podataka iz tabele se obavlja unosom naziva kolone po kojoj\n"
					+ " pretra\u017eujemo i podatka u toj koloni. Mogu\u0107a je i vi\u0161estruka pretraga\n"
					+ " po vi\u0161e od jedne kolone. Pretraga ce biti validna i ako korisnik ne\n"
					+ " unese pun naziv podatka iz kolone. Npr. pretragu predmeta je mogu\u0107e \n"
					+ " obaviti unosom \u0160ifra:OP301;Naziv:Osnovne. Obavezan je unos\n "
					+ " delimitera \":\" izme\u0111u naziva kolone i podatka i delimitera \";\" \n"
					+ " ako je pretraga vi\u0161estruka. (Napomena: unos Profesor:, je validan i \n"
					+ " prikazuje spisak svih predmeta koji imaju profesora).Sortiranje \n"
					+ " podataka u tabeli se vr\u0161i klikom na naziv kolone koju \u017eelimo sortirati.\n" + 
					" Odabirom tabele Predmeti u toolbar-u  se prikazuju nova tri dugmeta za\n"
					+ " funkcionalnosti: dodavanje studenta na predmet, dodavanje profesora\n"
					+ " na predmet i brisanje profesora sa predmeta. Za sve tri opcije\n "
					+ " neophodno je selektovati odgovaraju\u0107i red u tabeli. Uslovi za \n"
					+ " dodavanje studenta na predmet su da je student odgovaraju\u0107a\n" + 
					" godina studija i da ve\u0107 ne slu\u0161a taj predmet. Uslov za dodavanje\n"
					+ " profesora na predmet je da profesor ne predaje taj predmet. Uslov za\n"
					+ " brisanje profesora sa predmeta je da postoji profesor na tom \n"
					+ " predmetu. Ove tri funkcionalnosti uti\u010du na izmjenu podataka u\n"
					+ " preostale dvije tabele."
					);
			a2.setMaximumSize(dim1);
			//a2.setMaximumSize(getPreferredSize());
			a2.getPreferredScrollableViewportSize();
			a2.setBackground(getBackground());
			a2.setEditable(false);
			
			JScrollPane scroll1 = new JScrollPane(a2);
			scroll1.setPreferredSize(dim1);
			//scroll1.getVerticalScrollBar().setUnitIncrement(10);
			//scroll1.setMaximumSize(dim1);
	        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        //scroll1.setMaximumSize(dim1);
		
			panelCenter.add(panel1);
			panelCenter.add(scroll);
			panelCenter.add(panel2);
			panelCenter.add(scroll1);
			
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			add(panelCenter, BorderLayout.CENTER);
			
			JPanel panelBottom = new JPanel(new FlowLayout());
			
			JButton ok = new JButton("U redu");
		//	ok.setPreferredSize(new Dimension(80,20));
			ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			//panelBottom.add(Box.createGlue());
			panelBottom.add(ok, "");
			//panelBottom.add(Box.createHorizontalStrut(10));
	
			this.add(panelBottom, BorderLayout.SOUTH);
			pack();
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
