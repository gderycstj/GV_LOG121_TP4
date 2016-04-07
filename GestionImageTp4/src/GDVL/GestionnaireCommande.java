/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: GestionnaireCommande.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

import java.util.ArrayList;

/**
 * Classe qui va contenir la liste des commandes éffectués et va gérer le undo
 *
 */
public class GestionnaireCommande {
	
	  private ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	  private int pos;
	  

	  private GestionnaireCommande(){
		  pos = 0;
	  }
	  
	  private static GestionnaireCommande INSTANCE = new GestionnaireCommande();
	
	  /**
	 * @return une instance du gestionnaire de commande c'est un singleton
	 */
	public static GestionnaireCommande getInstance(){
		  return INSTANCE;
	  }
	  
	  
	  /**
	   * Va ajouter une commande à la liste
	 * @param commande commande à ajouter
	 */
	public void AjouterCommande(Commande commande)
	  {
		  listeCommande.add(commande);
		  pos = listeCommande.size();
	  }
	  
	  /**
	 * va défaire et supprimer la précédente commande dans la liste
	 */
	public void defaireCommande()
	  {
		  if(pos>0)
		  {
			  pos--;
			  listeCommande.get(pos).undo();
			  listeCommande.remove(pos);
		  }
	  }
	  
	  
}
