/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Sladjana Savkovic
 *
 */
public class SPPTablePanel extends JPanel{
	
	private static final long serialVersionUID = -1573673965793467387L;
	private JPanel leftPanel = new JPanel();
	//private Component c;
	private JPanel rightPanel = new JPanel();
	
	
	public SPPTablePanel() {
		Color lightBlue= new Color(160,215,255);
		setLayout(new BorderLayout());
		add(leftPanel, BorderLayout.WEST);
		leftPanel.setBackground(lightBlue);
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setBackground(lightBlue);
	}
	
	public SPPTablePanel(Component c, int leftGap, int rightGap) {
		this();
		leftPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		rightPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		
		add(c, BorderLayout.CENTER);
		
		
	}

	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		super.setBackground(bg);
		if (leftPanel == null || rightPanel == null) 
			return;
		leftPanel.setBackground(bg);
		rightPanel.setBackground(bg);
	}
}
