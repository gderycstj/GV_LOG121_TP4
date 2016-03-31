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
