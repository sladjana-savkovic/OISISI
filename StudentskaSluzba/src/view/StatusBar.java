/**
 * 
 */
package view;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Dragana Carapic
 *
 */
public class StatusBar extends JPanel{
	private static final long serialVersionUID = 1L;
    
    public StatusBar() {
    	super();
    	JLabel naslov = new JLabel("Studentska sluzba", JLabel.LEFT);
    	JLabel datum =  new JLabel();
    	
    	this.add(naslov, BorderLayout.WEST);
        this.add(datum, BorderLayout.EAST);
    	
        
        Timer t = new javax.swing.Timer(1000, new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
                java.util.Date now = new java.util.Date();
                String ss = DateFormat.getDateTimeInstance().format(now);
                datum.setText(ss);
                datum.setToolTipText(ss);
 
            }
        });
        t.start();
    }

	
}
