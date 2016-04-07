/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: Commande.java
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
 * Interface abstraite qui dit la structure d'une commande
 *
 */
public interface Commande {

	/**
	 * Méthode qui exécute la commande
	 */
	public void execute();
	
	/**
	 * Méthode qui va défaire la commande
	 */
	public void undo();
}
