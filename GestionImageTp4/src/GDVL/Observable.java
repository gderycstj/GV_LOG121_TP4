/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: Observable.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

public interface Observable {
	  public void ajouterObserveur(Observeur obs);
	  public void supprimerObserveur();
	  public void notifyObserveur(String str);
	}
