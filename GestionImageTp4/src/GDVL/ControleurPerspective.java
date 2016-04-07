/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: ControleurPerspective.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

/**
 * Classe qui fait le lien entre le modèle et la vue.
 * @author pc
 *
 */
public class ControleurPerspective {
	PerspectiveModel model;
	
	/**
	 * @param m modèle que va utiliser le controlleur
	 */
	ControleurPerspective(PerspectiveModel m)
	{
		model = m;
	}
	
	/**
	 * Va activer la commande reçu par la vue
	 * @param commande commande à éffectuer
	 */
	public void executerCommande(Commande commande)
	{
		commande.execute();
		GestionnaireCommande.getInstance().AjouterCommande(commande);	
	}
	
	/**
	 * Défait la commande lorsqu'on utilise le undo
	 */
	public void defaireCommande()
	{
		GestionnaireCommande.getInstance().defaireCommande();
	}
	
	
	/**
	 * Va initialiser le path du modèle
	 * @param path emplacement du modèle sur le disque
	 */
	public void initialiserPath(String path)
	{
		model.setPath(path);
	}
	
	
	
	
}
