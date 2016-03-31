package GDVL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;

public class VueStatique extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7010702140699097203L;
	public static final Dimension DIMENSION = new Dimension(250,250);
	VueStatique(){
	}
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}
}
