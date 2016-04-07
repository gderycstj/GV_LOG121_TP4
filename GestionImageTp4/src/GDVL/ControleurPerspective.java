/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: ControleurPerspective.java
Date cr��: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

/**
 * Classe qui fait le lien entre le mod�le et la vue.
 * @author pc
 *
 */
public class ControleurPerspective {
	PerspectiveModel model;
	
	/**
	 * @param m mod�le que va utiliser le controlleur
	 */
	ControleurPerspective(PerspectiveModel m)
	{
		model = m;
	}
	
	/**
	 * Va activer la commande re�u par la vue
	 * @param commande commande � �ffectuer
	 */
	public void executerCommande(Commande commande)
	{
		commande.execute();
		GestionnaireCommande.getInstance().AjouterCommande(commande);	
	}
	
	/**
	 * D�fait la commande lorsqu'on utilise le undo
	 */
	public void defaireCommande()
	{
		GestionnaireCommande.getInstance().defaireCommande();
	}
	
	
	/**
	 * Va initialiser le path du mod�le
	 * @param path emplacement du mod�le sur le disque
	 */
	public void initialiserPath(String path)
	{
		model.setPath(path);
	}
	
	
	
	
}
