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
import java.util.Observable;


public class PerspectiveModel extends Observable {
	
	private int niveauZoom;
	private int degreTranslation; 
	
	String Path;
	
	PerspectiveModel()
	{
		this.Path = "";
		this.niveauZoom = 1;
		this.degreTranslation = 0;
	}
	
	  
	public void setPath(String pathImage)
	{
		this.Path = pathImage;
		niveauZoom = 1;
		degreTranslation = 0;
		setChanged();
		notifyObservers();
	}
	
	public String getPath()
	{
		return this.Path;
	}
	
	public void effectuerZoom()
	{
		niveauZoom+=1;
		System.out.println("Niveau Zoom: " + niveauZoom);
		setChanged();
		notifyObservers();
	}
	
	public void effectuerZoomContraire()
	{
		niveauZoom-=20;
		System.out.println("Niveau Zoom: " + niveauZoom);
		setChanged();
		notifyObservers();
	}
	
	public void effectuerTranslation()
	{
		degreTranslation+=20;
		System.out.println("Niveau Translation: " + degreTranslation);
		setChanged();
		notifyObservers();
		
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


	public int getNiveauZoom()
	{
		return niveauZoom;
		
	}
}

