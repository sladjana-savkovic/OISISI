/**
 * 
 */
package view;

import java.awt.*;
import javax.swing.*;


/**
 * @author Sladjana Savkovic
 *
 */
public class DodavanjePredmeta extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel sifraPredmeta,nazivPredmeta,semestar,godinaStudija,predmetniProfesor;
	private JTextField txtSifraPredmeta,txtNazivPredmeta,txtPredmetniProfesor;
	private JComboBox CBgodina,CBsemestar;
	private Color darkerBlue= new Color(0,200,200);
	
	public DodavanjePredmeta() {
		super();
		
		setTitle("Dodavanje studenta");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width * 1 / 4, screenSize.height * 1 / 4);
		setLocationRelativeTo(null);
		
		JPanel panelCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
		panelCenter.setLayout(boxCenter);
		
		Dimension dim = new Dimension(160, 25);
		
		//polje za unos sifre predmeta
		JPanel pnlSifraPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sifraPredmeta = new JLabel();
		pnlSifraPredmeta.add(sifraPredmeta);
		sifraPredmeta.setText("Sifra predmeta*");
		sifraPredmeta.setPreferredSize(dim);
		
		txtSifraPredmeta = new JTextField();
		txtSifraPredmeta.setPreferredSize(dim);
		pnlSifraPredmeta.add(sifraPredmeta);
		pnlSifraPredmeta.add(txtSifraPredmeta);
		
		//polje za unos naziva predmeta
		JPanel pnlNazivPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		nazivPredmeta = new JLabel();
		pnlNazivPredmeta.add(nazivPredmeta);
		nazivPredmeta.setText("Naziv predmeta*");
		nazivPredmeta.setPreferredSize(dim);
		
		txtNazivPredmeta = new JTextField();
		txtNazivPredmeta.setPreferredSize(dim);
		pnlNazivPredmeta.add(nazivPredmeta);
		pnlNazivPredmeta.add(txtNazivPredmeta);
		
		//polje za predmetnog profesora
		JPanel pnlPredmetniProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		predmetniProfesor = new JLabel();
		pnlPredmetniProfesor.add(predmetniProfesor);
		predmetniProfesor.setText("Predmetni profesor*");
		predmetniProfesor.setPreferredSize(dim);
		
		txtPredmetniProfesor = new JTextField();
		txtPredmetniProfesor.setPreferredSize(dim);
		pnlPredmetniProfesor.add(predmetniProfesor);
		pnlPredmetniProfesor.add(txtPredmetniProfesor);
		
		//polje za odabir godine na kojoj se predmet slusa
		JPanel pnlGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ComboBoxModel cmbGodinaStudija = new DefaultComboBoxModel(new String[] {"I(prva)", "II(druga)", "III(treca)", "IV(cetvrta)"}); 
		godinaStudija = new JLabel();
		godinaStudija.setText("Godina na kojoj se predmet slusa*");
		godinaStudija.setPreferredSize(dim);
		
		CBgodina = new JComboBox();
		pnlGodinaStudija.add(godinaStudija);
		pnlGodinaStudija.add(CBgodina);
		CBgodina.setModel(cmbGodinaStudija);
		
		//polje za odabir semestra u kojem se predmet slusa
		JPanel pnlSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ComboBoxModel cmbSemestar = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5","6","7","8"}); 
		semestar = new JLabel();
		semestar.setText("Semestar u kojem se predmet slusa*");
		semestar.setPreferredSize(dim);
		
		CBsemestar = new JComboBox();
		pnlSemestar.add(semestar);
		pnlSemestar.add(CBsemestar);
		CBsemestar.setModel(cmbSemestar);
		
		panelCenter.add(pnlSifraPredmeta);
		panelCenter.add(pnlNazivPredmeta);
		panelCenter.add(pnlPredmetniProfesor);
		panelCenter.add(pnlGodinaStudija);
		panelCenter.add(pnlSemestar);
		
		panelCenter.add(Box.createVerticalStrut(50));
		add(panelCenter, BorderLayout.CENTER);
		
		//potvrda uniejtog sadrzaja ili odustanak
		JPanel panelBottom = new JPanel();
		BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
		panelBottom.setLayout(box);
				
		JButton potvrdi = new JButton("Potvrda");
		potvrdi.setBackground(darkerBlue);
		potvrdi.setPreferredSize(new Dimension(80, 30));
				
		JButton odustani = new JButton("Odustanak");
		odustani.setPreferredSize(new Dimension(80, 30));
				
		panelBottom.add(Box.createGlue());
		panelBottom.add(odustani);
		panelBottom.add(Box.createHorizontalStrut(10));
		panelBottom.add(potvrdi);
		panelBottom.add(Box.createHorizontalStrut(10));
				
		add(panelBottom, BorderLayout.SOUTH);
		pack();
	}
}
