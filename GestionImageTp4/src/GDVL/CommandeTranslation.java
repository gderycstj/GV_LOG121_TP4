/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: CommandeTranslation.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

/**
 *Commande pour éffectuer une translation
 *
 */
public class CommandeTranslation implements Commande {

	PerspectiveModel model;
	int posX;
	int posY;
	
	/**
	 * Constructeur de la translation
	 * @param model model de la vue a translater
	 * @param posX déplacement en x pour la translation
	 * @param posY déplacement en y pour la translation
	 */
	CommandeTranslation(PerspectiveModel model,int posX,int posY)
	{
		this.model = model;
		this.posX = posX;
		this.posY = posY;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		model.effectuerTranslation(posX,posY);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		model.effectuerTranslationContraire(posX,posY);
	}

}
