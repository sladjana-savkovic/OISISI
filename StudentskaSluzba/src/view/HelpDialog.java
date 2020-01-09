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
		init();
		
	}
	
	public void init() {
		try {
			Toolkit kit=Toolkit.getDefaultToolkit();
			setSize(400,400);
			Image img=kit.getImage("logo_images/ftn.png");
			setIconImage(img);
			setLocationRelativeTo(null);
			
			JPanel panelCenter = new JPanel(new BorderLayout());
			BoxLayout boxCenter = new BoxLayout(panelCenter, BoxLayout.Y_AXIS);
			panelCenter.setLayout(boxCenter);
			panelCenter.add(Box.createVerticalStrut(30));
			panelCenter.add(Box.createGlue());
			
			Dimension dim = new Dimension(180, 20);
			Dimension dim1 = new Dimension(350, 140);
			
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			text = new JLabel("O aplikaciji");
			text.setPreferredSize(dim);
			panel1.add(text);
			
			//JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			a1= new JTextArea(
					"Sla\u0111ana Savkovi\u0107 hhdh gggghdhdkkkkk je ro\u0111ena"+"\n"+
					"20.01.1997. u Banja Luci, BiH, hhhhhhhhhhhhhhhhhh d dhh."+"\n"+
					"Osnovnu \u0161kolu je zavrjjjjjjjjjjjjj  dffd f df dff dff."+"\n"+
					"u Prnjavoru, nakon \u010dega je upisalajjjjjjjjjjjjjjjjjjjj"+"\n"+
					"Gimanziju, ra\u010dunarski smjer istokkkkkkkkkkkkkkd djjjjj"+"\n"+
					"u Prnjavoru.Po zavr\u0161etku gimnazijejjjjjjjjjjj djjjjjjj"+"\n"+
					"Fakultet tehni\u010dkih nauka u Novomjjjjjjjjjdg dgjjjjjjjj"+"\n"+
					"Sadu je upisala 2017.jjjjjjjjjjjjjjjjjjjjjjjjj  fd fd dfjjjj"
					);
			a1.setPreferredSize(dim1);
			a1.setBackground(getBackground());
			a1.setEditable(false);
			
			JScrollPane scroll = new JScrollPane(a1);
	        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			text1 = new JLabel("Rukovanje aplikacijom");
			text1.setPreferredSize(dim);
			
			panel2.add(text1);
			
			//JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			a2= new JTextArea(
					"Sla\u0111ana Savkovi\u0107 hhdh dhdhdhdhjjj je ro\u0111ena"+"\n"+
					"20.01.1997. u Banja Luci,jjjjjjjjjjjjjjjjjj BiH, RS."+"\n"+
					"Osnovnu \u0161kolu je zavr\u0161ila jjjjjjjjjjjjff 2011."+"\n"+
					"u Prnjavoru, nakon \u010dega je upisala"+"\n"+
					"Gimanziju, ra\u010dunarski smjer isto"+"\n"+
					"u Prnjavoru.Po zavr\u0161etku gimnazije"+"\n"+
					"Fakultet tehni\u010dkih nauka u Novom"+"\n"+
					"Sadu je upisala 2017. "
					);
			a2.setPreferredSize(dim1);
			a2.setBackground(getBackground());
			a2.setEditable(false);
			
			JScrollPane scroll1 = new JScrollPane(a2);
	        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
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
