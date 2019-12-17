/**
 * 
 */
package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 * @author Sladjana Savkovic
 *
 */
public class TabbedPane extends JTabbedPane{
	
	private static final long serialVersionUID = 8320287704098046391L;

	public TabbedPane() {
		setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 20 ) );
		Color darkerBlue= new Color(0,200,200);
		setBackground(darkerBlue);
		
		MyTab firstTab=new MyTab("Studenti");
		this.addTab("Studenti", firstTab);
		this.setMnemonicAt(0, KeyEvent.VK_S);
		
		MyTab secondTab=new MyTab("Profesori");
		secondTab.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorRemoved(AncestorEvent arg0) {
				Toolbar.buttonAddProfessor.setVisible(false);
				Toolbar.buttonAddProfessor.setVisible(false);
			}
			@Override
			public void ancestorMoved(AncestorEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void ancestorAdded(AncestorEvent arg0) {
			}
		});
		this.addTab("Profesori", secondTab);
		this.setMnemonicAt(1, KeyEvent.VK_P);
		
		MyTab thirdTab=new MyTab("Predmeti");
		thirdTab.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				Toolbar.buttonAddProfessor.setVisible(false);
				Toolbar.buttonAddStudent.setVisible(false);
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {}
		
			@Override
			public void ancestorAdded(AncestorEvent event) {
				Toolbar.buttonAddProfessor.setVisible(true);
				Toolbar.buttonAddStudent.setVisible(true);
				
			}
		});
		this.addTab("Predmeti", thirdTab);
		this.setMnemonicAt(2, KeyEvent.VK_R);
		
	}
}
