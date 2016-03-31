package GDVL;

public class CommandeTranslation implements Commande {

	PerspectiveModel model;
	CommandeTranslation(PerspectiveModel model)
	{
		this.model = model;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		model.effectuerTranslation();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		model.effectuerTranslationContraire();
	}

}
