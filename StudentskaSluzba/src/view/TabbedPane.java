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
	public static int activeTab=0;
	Color darkerBlue;

	public TabbedPane() {
		setFont( new Font( "Dialog", Font.BOLD|Font.ITALIC, 20 ) );
		darkerBlue= new Color(0,200,200);
		setBackground(darkerBlue);
		
		setFirstTab();
		setSecondTab();
		setThirdTab(); 
		
	}
	private void setFirstTab() {
		MyTab firstTab=new MyTab("Studenti");
		firstTab.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void ancestorAdded(AncestorEvent event) {
				Toolbar.buttonAddProfessor.setVisible(false);
				Toolbar.buttonAddStudent.setVisible(false);
				Toolbar.buttonDeleteProfessor.setVisible(false);
				activeTab=0;
			}
		});
		
		this.addTab("Studenti", firstTab);
		this.setMnemonicAt(0, KeyEvent.VK_S);
	}
	private void setSecondTab() {
		MyTab secondTab=new MyTab("Profesori");
		secondTab.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent arg0) {
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void ancestorMoved(AncestorEvent arg0) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void ancestorAdded(AncestorEvent arg0) {
				Toolbar.buttonAddProfessor.setVisible(false);
				Toolbar.buttonAddStudent.setVisible(false);
				Toolbar.buttonDeleteProfessor.setVisible(false);
				activeTab=1;
			}
		});
		this.addTab("Profesori", secondTab);
		this.setMnemonicAt(1, KeyEvent.VK_P);
	}
	private void setThirdTab() {
		MyTab thirdTab=new MyTab("Predmeti");
		thirdTab.addAncestorListener(new AncestorListener() {
			
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
			}
		
			@Override
			public void ancestorAdded(AncestorEvent event) {
				Toolbar.buttonAddProfessor.setVisible(true);
				Toolbar.buttonAddStudent.setVisible(true);
				Toolbar.buttonDeleteProfessor.setVisible(true);
				activeTab=2;
				
			}
		});
		this.addTab("Predmeti", thirdTab);
		this.setMnemonicAt(2, KeyEvent.VK_R);
	}
}
