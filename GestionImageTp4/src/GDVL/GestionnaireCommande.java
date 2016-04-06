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

public class GestionnaireCommande {
	
	  private ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	  private int pos;
	  

	  private GestionnaireCommande(){
		  int pos = 0;
	  }
	  
	  private static GestionnaireCommande INSTANCE = new GestionnaireCommande();
	
	  public static GestionnaireCommande getInstance(){
		  return INSTANCE;
	  }
	  
	  
	  public void AjouterCommande(Commande commande)
	  {
		  listeCommande.add(commande);
		  pos++;
	  }
	  
	  public void defaireCommande()
	  {
		  if(pos>0)
		  {
			  pos--;
			  listeCommande.get(pos).undo();
		  }
		  else
		  {
			  listeCommande.clear();
		  }
	  }
	  
	  
}
