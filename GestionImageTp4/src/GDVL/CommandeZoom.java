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
	Boolean typeZoom;
	
	public CommandeZoom(PerspectiveModel model,Boolean typeZoom)
	{
		this.typeZoom = typeZoom;
		this.model = model;
	}
	@Override
	public void execute() {
		
		// TODO Auto-generated method stub
		if(typeZoom == true)
		{
			model.effectuerZoom();
		}
		else
		{
			model.effectuerZoomContraire();
		}
	}

	@Override
	public void undo() {
		
		if(typeZoom == true)
		{
			model.effectuerZoomContraire();
		}
		else
		{
			model.effectuerZoom();
		}
	
	}
}
