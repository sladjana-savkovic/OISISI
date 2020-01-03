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
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Dragana Carapic
 *
 */
public class DodavanjeStudentaNaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6032232686414917989L;
	
	private JLabel indeks;
	private JTextField txtIndeks;
	
	
	public DodavanjeStudentaNaPredmet(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		initStudPred();
	}
	
	public void initStudPred() {
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
			Dimension d = new Dimension(210,25);
			JPanel panelInd = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			indeks = new JLabel("Indeks studenta*");
			indeks.setPreferredSize(dim);
			txtIndeks = new JTextField();
			txtIndeks.setPreferredSize(d);
			txtIndeks.setName("txtIndeks");
			
			panelInd.add(indeks);
			panelInd.add(txtIndeks);
			
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
					String indStr = txtIndeks.getText();
					if(indStr.equals("")) {
						JOptionPane.showMessageDialog(DodavanjeStudentaNaPredmet.this, "Morate unijeti broj indeksa studenta!", "Upozorenje!", JOptionPane.INFORMATION_MESSAGE);
						txtIndeks.requestFocus();
						return;
					}
					
					Pattern pattern = Pattern.compile("[a-zA-Z0-9]+/[0-9]+");
					if(!(pattern.matcher(indStr)).matches()) {
						JOptionPane.showMessageDialog(DodavanjeStudentaNaPredmet.this, "Dozvoljen je unos samo brojeva i slova za indeks u formaru YYxx/zzzz!", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
						txtIndeks.requestFocus();
						return;
					}
					
				}
			});
			
			JButton odustani = new JButton("Odustati");
			odustani.setPreferredSize(new Dimension(100, 30));
			odustani.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Da","Ne"};
					int res = JOptionPane.showOptionDialog(DodavanjeStudentaNaPredmet.this, "Da li ste sigurni da \u017eelite da odustanete?", "Upozorenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
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
	
	//metoda koja vraca godinu upisa studenta
	public String godinaStudija() {
		String god = txtIndeks.getText();
		String a[]=new String[5];
		a=god.split("/");
		
		return a[1];
	}

}
