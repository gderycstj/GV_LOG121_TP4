/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: Commande.java
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
 * Interface abstraite qui dit la structure d'une commande
 *
 */
public interface Commande {

	/**
	 * M�thode qui ex�cute la commande
	 */
	public void execute();
	
	/**
	 * M�thode qui va d�faire la commande
	 */
	public void undo();
}
