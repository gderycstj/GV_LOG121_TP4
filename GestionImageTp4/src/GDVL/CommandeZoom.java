/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: CommandeZoom.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

public class CommandeZoom implements Commande {
	
	PerspectiveModel model;
	
	public CommandeZoom(PerspectiveModel model)
	{
		this.model = model;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		model.effectuerZoom();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		model.effectuerZoomContraire();
	}
}
