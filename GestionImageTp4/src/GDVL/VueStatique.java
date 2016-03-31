package GDVL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class VueStatique extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7010702140699097203L;
	public static final Dimension DIMENSION = new Dimension(250,250);
	VueStatique(){
		this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}
}
