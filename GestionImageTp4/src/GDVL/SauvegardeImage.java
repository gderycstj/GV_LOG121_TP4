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

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe permettant de sauvegarder dans un fichier serialiser le modèle contenant les informations sur l'image modifiée.
 */
public class SauvegardeImage implements Serializable{
	private static final long serialVersionUID = 1196443516682880758L;

	/**
	 * @param nomFichier : Nom du fichier de sauvegarde qui sera créer.
	 * @param vue : Vue de laquelle provient les informations de l'image.
	 */
	SauvegardeImage(String nomFichier,VuePerspective vue)
	{
		 PerspectiveModel instance = vue.getModel();
		 try
		 {
	        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(nomFichier)));
	        oos.writeObject(instance);
	        oos.close();
		 }catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
}
