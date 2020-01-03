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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Dragana Carapic
 *
 */
public class AboutDialog extends JDialog{
	
	private static final long serialVersionUID = 2566945927276159128L;

	private JLabel l1,l2;
	private JTextField t1,t2;
	
	public AboutDialog(JFrame parent, String title, boolean modal) {
		super(parent,title,modal);
		init();
	}
	
	public void init() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			JPanel panelCenter = new JPanel();
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			
			Dimension dim = new Dimension(200, 125);
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			l1 = new JLabel();
			Icon icon1 = new ImageIcon("logo_images/sladjana.jpg");
			l1.setIcon(icon1);
			t1 = new JTextField();
			t1.setPreferredSize(dim);
			t1.setText("Sladjana Savkovic");
			t1.setEditable(false);
			
			panel1.add(l1);
			panel1.add(t1);
			
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			l2 = new JLabel();
			Icon icon2 = new ImageIcon("logo_images/dragana.jpg");	
			l2.setIcon(icon2);
			t2 = new JTextField();
			t2.setPreferredSize(dim);
			t2.setText("Dragana Carapic");
			t2.setEditable(false);
			
			panel2.add(l2);
			panel2.add(t2);
			
			
			panelCenter.add(panel1);
			panelCenter.add(panel2);
			
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
	
			panelBottom.add(ok, "");
			
			
			this.add(panelBottom, BorderLayout.SOUTH);
			pack();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
