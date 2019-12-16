/**
 * 
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

/**
 * @author Dragana Carapic
 *
 */
public class StatusBar extends JLabel{
	private static final long serialVersionUID = 1L;
    
    public StatusBar() {
    	super();
    	String vrijeme = new SimpleDateFormat("dd MMM yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
    	setText("Studentska sluzba"+"      "+vrijeme);
    }

	
}
