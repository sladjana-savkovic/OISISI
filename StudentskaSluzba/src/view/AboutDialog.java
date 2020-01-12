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
import javax.swing.JTextArea;

/**
 * @author Dragana Carapic
 *
 */
public class AboutDialog extends JDialog{
	
	private static final long serialVersionUID = 2566945927276159128L;

	private JLabel l1,l2;
	private JTextArea a1, a2;
	
	public AboutDialog(JFrame parent, String title, boolean modal) {
		super(parent,title,modal);
		init(parent);
	}
	
	public void init(JFrame parent) {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(parent);
			
			JPanel panelCenter = new JPanel();
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			
			Dimension dim = new Dimension(210, 130);
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			l1 = new JLabel();
			Icon icon1 = new ImageIcon("logo_images/sladjana.jpg");
			l1.setIcon(icon1);
			
			a1= new JTextArea(
					"Sla\u0111ana Savkovi\u0107 je ro\u0111ena"+"\n"+
					"20.01.1997. u Banja Luci, BiH, RS."+"\n"+
					"Osnovnu \u0161kolu je zavr\u0161ila 2011."+"\n"+
					"u Prnjavoru, nakon \u010dega je upisala"+"\n"+
					"Gimanziju, ra\u010dunarski smjer isto"+"\n"+
					"u Prnjavoru.Po zavr\u0161etku gimnazije"+"\n"+
					"Fakultet tehni\u010dkih nauka u Novom"+"\n"+
					"Sadu je upisala 2017. "
					);
			a1.setPreferredSize(dim);
			a1.setBackground(getBackground());
			a1.setEditable(false);
			
			panel1.add(l1);
			panel1.add(a1);
			
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			l2 = new JLabel();
			Icon icon2 = new ImageIcon("logo_images/dragana.jpg");	
			l2.setIcon(icon2);

			a2= new JTextArea(
					"Dragana \u010carapi\u0107 je ro\u0111ena"+"\n"+
					"13.08.1998. u U\u017eicu, RS."+"\n"+
					"Osnovnu \u0161kolu je zavr\u0160ila 2012."+"\n"+
					"u Vi\u0161egradu, nakon \u010dega je upisala"+"\n"+
					"Gimanziju, op\u0161ti smjer tako\u0111e"+"\n"+
					"u Vi\u0161egradu.Po zavr\u0161etku gimnazije"+"\n"+
					"Fakultet tehni\u010dkih nauka u Novom"+"\n"+
					"Sadu je upisala 2017. "
					);
			a2.setPreferredSize(dim);
			a2.setBackground(getBackground());
			a2.setEditable(false);
	
			panel2.add(l2);
			panel2.add(a2);
			
			panelCenter.add(panel1);
			panelCenter.add(panel2);
			
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			add(panelCenter, BorderLayout.CENTER);
			
			JPanel panelBottom = new JPanel(new FlowLayout());
			
			JButton ok = new JButton("U redu");
			//ok.setPreferredSize(new Dimension(80,20));
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
