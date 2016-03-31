package GDVL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class VuePerspective extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1279976614214775078L;
	public static final Dimension DIMENSION = new Dimension(250,250);
	VuePerspective(){
		this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}
}
