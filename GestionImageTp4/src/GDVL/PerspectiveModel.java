/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: PerspectiveModel.java
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

public class PerspectiveModel implements Observable{
	
	private int niveauZoom;
	private int degreTranslation;
	private ArrayList<Observeur> listeObserveur = new ArrayList<Observeur>();   
	
	String Path;
	
	PerspectiveModel()
	{
		Path = "";
	}
	
	private ArrayList<Observeur> listObserver = new ArrayList<Observeur>();   

	  //Implémentation du pattern observer
	  public void ajouterObserveur(Observeur obs) {
	    this.listObserver.add(obs);
	  }

	  public void notifyObserveur(String str) {
	    if(str.matches("^0[0-9]+"))
	      str = str.substring(1, str.length());

	    for(Observeur obs : listeObserveur)
	      obs.update(str);
	  }

	  public void supprimerObserveur() {
	    listObserver = new ArrayList<Observeur>();
	  }  
	  
	public void setPath(String pathImage)
	{
		Path = pathImage;
	}
	
	public void effectuerZoom()
	{
		niveauZoom+=20;
		System.out.println("Niveau Zoom: " + niveauZoom);
		//notifyObserveur();
	}
	
	public void effectuerZoomContraire()
	{
		niveauZoom-=20;
		System.out.println("Niveau Zoom: " + niveauZoom);
		//notifyObserveur();
	}
	
	public void effectuerTranslation()
	{
		degreTranslation+=20;
		System.out.println("Niveau Translation: " + degreTranslation);
		//notifyObserveur();
		
	}
	
	public void effectuerTranslationContraire()
	{
		degreTranslation-=20;
		System.out.println("Niveau Translation: " + degreTranslation);
		//notifyObserveur();
	}
	
	public int getTranslation()
	{
		return degreTranslation;
	}

}

