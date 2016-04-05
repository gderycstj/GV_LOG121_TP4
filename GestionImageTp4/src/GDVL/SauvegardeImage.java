/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: SauvegardeImage.java
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

public class SauvegardeImage implements Serializable{
	String PathImage;
	int Zoom;
	int Translation;
	
	SauvegardeImage(String PathImage,int Zoom,int Translation)
	{
		this.PathImage = PathImage;
		this.Zoom = Zoom;
		this.Translation = Translation;
	}
	
	public void setPathImage(String PathImage){
		this.PathImage = PathImage;
	}
	
	public void setZoom(int Zoom){
		this.Zoom = Zoom;
	}
	
	public void setTranslation(int Translation){
		this.Translation = Translation;
	}
	
	@Override
	public String toString() {
	return "Image [PathImage=" + this.PathImage + ", Zoom=" + this.Zoom + " Translation="+this.Translation +"]";
	}
}
