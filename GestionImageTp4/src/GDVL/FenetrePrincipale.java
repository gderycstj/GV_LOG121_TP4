package GDVL;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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
		
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH); 
		this.add(vueStatique, BorderLayout.SOUTH);
		this.add(vueGauche,BorderLayout.WEST);
		this.add(vueDroite,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
