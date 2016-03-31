package GDVL;

import java.util.ArrayList;

public class GestionnaireCommande {
	
	  private ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	  private int pos;
	  

	  private GestionnaireCommande(){
		  int pos = 0;
	  }
	  
	  private static GestionnaireCommande INSTANCE = new GestionnaireCommande();
	
	  public static GestionnaireCommande getInstance(){
		  return INSTANCE;
	  }
	  
	  
	  public void AjouterCommande(Commande commande)
	  {
		  listeCommande.add(commande);
		  pos++;
	  }
	  
	  public void defaireCommande()
	  {
		  if(pos>0)
		  {
			  pos--;
			  listeCommande.get(pos).undo();
		  }
		  
	  }
	  
	  
}
