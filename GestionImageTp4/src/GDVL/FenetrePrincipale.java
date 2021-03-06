/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: FenetrePrincipale.java
Date cr��: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.border.TitledBorder;

/**
 * fen�tre qui regroupe les vues et le menu
 *
 */
public class FenetrePrincipale extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2568028318000988008L;

		FenetrePrincipale(){
		setResizable(false);
		VueStatique vueStatique = new VueStatique();		
		//Instanciation du mod�le
	    PerspectiveModel Pers = new PerspectiveModel();
	    PerspectiveModel Pers2 = new PerspectiveModel();
	    //Cr�ation du contr�leur
	    ControleurPerspective controleur1 = new ControleurPerspective(Pers);
	    ControleurPerspective controleur2 = new ControleurPerspective(Pers2);
	    //Cr�ation des fen�tres avec le contr�leur en param�tre
	    VuePerspective vueGauche = new VuePerspective(controleur1,Pers);
	    VuePerspective vueDroite = new VuePerspective(controleur2,Pers2);
	    
	    MenuFenetre menu = new MenuFenetre(vueStatique,vueGauche,vueDroite);	
		//�l�ment visuel
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
