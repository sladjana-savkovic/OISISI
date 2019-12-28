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

/**
 * @author Dragana Carapic
 *
 */
public class HelpDialog extends JDialog{
	private JLabel text;
	private JLabel text1;
	
	public HelpDialog(JFrame parent, String title, boolean modal) {
		super(parent,title,modal);
		init();
		
	}
	
	public void init() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			//setSize(600,600);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			JPanel panelCenter = new JPanel(new BorderLayout());
			//panelCenter.setMaximumSize(new Dimension(200,200));
			this.add(panelCenter);
			
			Dimension dim = new Dimension(100, 100);
			
			//JPanel panel = new JPanel(new BorderLayout());
			
			text = new JLabel("O aplikaciji");
			text.setPreferredSize(dim);
			text.setToolTipText("dodatno objasnjenje labele");
			panelCenter.add(text, BorderLayout.NORTH);
			
			text1 = new JLabel("Rukovanje aplikacijom");
			text1.setSize(300,300);
			panelCenter.add(text1, BorderLayout.CENTER);
			
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
