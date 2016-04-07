package GDVL;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Classe permettant de charger des sauvegardes sérialisées grâce à la classe SauvegardeImage.
 */
public class ChargerSauvegarde implements Serializable{
	private static final long serialVersionUID = -4217405109246019682L;

	/**
	 * @param nomFichier : Chemin pour atteindre le fichier .ser que l'on tente de charger.
	 * @param vue : Vue dans laquelle l'image sera chargée.
	 */
	ChargerSauvegarde(String nomFichier,VuePerspective vue)
	{
		try
		{
			FileInputStream fichierCharge = new FileInputStream(nomFichier);
			@SuppressWarnings("resource")
			ObjectInputStream objetCharge = new ObjectInputStream (fichierCharge);
			Object objet = objetCharge.readObject();
			if (objet instanceof PerspectiveModel)
			{
				PerspectiveModel model = (PerspectiveModel) objet;
				vue.setModel(model);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
