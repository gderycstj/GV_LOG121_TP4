package GDVL;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class FenetrePrincipale extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2568028318000988008L;

	FenetrePrincipale(){
		MenuFenetre menu = new MenuFenetre();
		VueStatique vueStatique = new VueStatique();
		VuePerspective vueGauche = new VuePerspective();
		VuePerspective vueDroite = new VuePerspective();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(menu, BorderLayout.NORTH); 
		getContentPane().add(vueStatique, BorderLayout.SOUTH);
		getContentPane().add(vueGauche,BorderLayout.WEST);
		getContentPane().add(vueDroite,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
