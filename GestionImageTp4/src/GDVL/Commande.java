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

public interface Commande {

	public void execute();
	
	public void undo();
}
