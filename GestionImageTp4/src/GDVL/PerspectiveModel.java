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


import java.io.Serializable;
import java.util.Observable;


/**
 * Modèle qui contient les données des images
 *
 */
public class PerspectiveModel extends Observable implements Serializable{
	
	private float niveauZoom;
	private int degreTranslation; 
	private int translationX;
	private int translationY;
	private static int MIN_SIZE = -230;
	private static int MAX_SIZE = 230;
	String name;
	String Path;
	

	PerspectiveModel(String name)
	{
		this.Path = "";
		this.niveauZoom = 1;
		this.degreTranslation = 0;
		this.translationX = 0;
		this.translationY = 0;
		this.name = name;
	}
	
	  
	/**
	 * initialise le path et met toutes les données de l'image à 0
	 * @param pathImage
	 */
	public void setPath(String pathImage,boolean reset)
	{
		this.Path = pathImage;
		if(reset == true)
		{
			this.niveauZoom = 1;
			degreTranslation = 0;
			this.translationX = 0;
			this.translationY = 0;
		}
		setChanged();
		notifyObservers();
	}
	
	public String getPath(){
		return this.Path;
	}
	

	public int getTranslation(){
		return degreTranslation;
	}

	public int getTranslationX()
	{
		return translationX;
	}
	public int getTranslationY()
	{
		return translationY;
	}
	public float getNiveauZoom(){
		return niveauZoom;
	}
	
	
	/**
	 * Va aggrandir le zoom et mettre à jour la vue
	 */
	public void effectuerZoom()
	{
		niveauZoom+=0.3;
		setChanged();
		notifyObservers();
		System.out.println("je suis dans " + name);
	}
	
	/**
	 * va dézoomer et mettre à jour la vue
	 */
	public void effectuerZoomContraire()
	{
		niveauZoom-=0.3;
		setChanged();
		notifyObservers();
		System.out.println("je suis dans " + name);
	}
	
	/**
	 * Va effectuer la translation
	 * @param posX translation en x
	 * @param posY translation en y
	 */
	public void effectuerTranslation(int posX,int posY)
	{
		this.translationX+=posX;
		this.translationY+=posY;
		
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * Va annuler la translation
	 * @param posX translation en x
	 * @param posY translation en y
	 */
	public void effectuerTranslationContraire(int posX,int posY)
	{
		this.translationX = translationX - posX;
		this.translationY = translationY - posY;
		setChanged();
		notifyObservers();
	}
}

