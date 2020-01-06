/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.PredmetController;
import controller.ProfesorController;

/**
 * @author Sladjana Savkovic
 *
 */
public class DodavanjeProfesoraNaPredmet extends JDialog{

	private static final long serialVersionUID = 729002353215829058L;
	
	private JLabel licnaKarta;
	private JComboBox<String> licnaCM;
	
	public DodavanjeProfesoraNaPredmet(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initProfPred();
	}
	public void initProfPred() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(200,200);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			JPanel panelCenter = new JPanel();
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			
			Dimension dim = new Dimension(160, 25);
			JPanel panelInd = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			licnaKarta = new JLabel("Broj li\u010dne karte profesora*");
			licnaKarta.setPreferredSize(dim);
			
			String[] a=ProfesorController.getInstance().getLicneKarte(ButtonColumnPredmet.selectedRow);
			licnaCM = new JComboBox<String>(a);
			
			panelInd.add(licnaKarta);
			panelInd.add(licnaCM);
			
			panelCenter.add(panelInd);
			
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			add(panelCenter, BorderLayout.CENTER);
			
			JPanel panelBottom = new JPanel();
			BoxLayout box = new BoxLayout(panelBottom, BoxLayout.X_AXIS);
			panelBottom.setLayout(box);
			
			JButton potvrdi = new JButton("Potvrditi");
			potvrdi.setPreferredSize(new Dimension(100, 30));
			potvrdi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String izabranaLicna = (String) licnaCM.getSelectedItem();
					PredmetController.getInstance().dodajProfesoraNaPredmet(izabranaLicna, ButtonColumnPredmet.selectedRow);
					
					ButtonColumnStudent.selectedRow = -1;
					ButtonColumnProfesor.selectedRow = -1;
					ButtonColumnPredmet.selectedRow = -1;
					
					dispose();
				}
			});
			JButton odustani = new JButton("Odustati");
			odustani.setPreferredSize(new Dimension(100, 30));
			odustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Da","Ne"};
					int res = JOptionPane.showOptionDialog(DodavanjeProfesoraNaPredmet.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
