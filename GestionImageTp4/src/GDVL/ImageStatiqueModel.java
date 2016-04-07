/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: ImageStatiqueModel.java
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

/**
 * Classe qui contient l'image statique
 *
 */
public class ImageStatiqueModel extends Observable {
	
	String Path;
	
	ImageStatiqueModel()
	{
		Path = "";
	}
	/**
	 * initialise le path de l'image statique
	 * @param pathImage string contenant le chemin de l'image
	 */
	public void setPath(String pathImage)
	{
		Path = pathImage;
		
	}
}
