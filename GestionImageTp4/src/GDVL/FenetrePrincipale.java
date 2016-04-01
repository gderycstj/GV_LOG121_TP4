/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: FenetrePrincipale.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
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
		MenuFenetrePrincipale menu = new MenuFenetrePrincipale();
		VueStatique vueStatique = new VueStatique();		
		//Instanciation du modèle
	    PerspectiveModel Pers = new PerspectiveModel();
	    //Création du contrôleur
	    ControleurPerspective controleur = new ControleurPerspective(Pers);
	    //Création des fenêtres avec le contrôleur en paramètre
	    VuePerspective vueGauche = new VuePerspective(controleur);
	    VuePerspective vueDroite = new VuePerspective(controleur);
	    //Ajout des fenêtres comme observeur de notre modèle
	    Pers.ajouterObserveur(vueGauche);
	    Pers.ajouterObserveur(vueDroite);
		
		//Élément visuel
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
