/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: VuePerspective.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;


import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;
import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue permettant de Zoom/UnZoom et d'effectuer des translations sur les images présentes dans celle-ci.
 *
 */
public class VuePerspective extends JComponent implements Observer, MouseListener, MouseWheelListener{
	private static final long serialVersionUID = 1279976614214775078L;
	private static final Dimension DIMENSION = new Dimension(300,300);
	private ControleurPerspective controleur;
	private PerspectiveModel model;
	private int positionXDepart;
	private int positionYDepart;
	private boolean estDansMemeVue = false;
	VuePerspective(ControleurPerspective cont, PerspectiveModel model){
		this.controleur = cont;
		this.model = model;
		InitUI();
	}
	
	/**
	 * Initialise les aspects de base de la vue (taille , listener , bordure).
	 */
	private void InitUI()
	{
		setLayout(null);
	    
	  //Ajout des fenêtres comme observeur de notre modèle
	    model.addObserver(this);  
	    this.addMouseListener(this);
	    this.addMouseWheelListener(this);
		this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	/**
	 * Retourne la dimension de la vue
	 */
	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}

	/**
	 * Récupère le chemin vers l'image qui sera affichée dans la vue.
	 * @param image : chemin vers l'image.
	 */
	public void setPath(String image)
	{
		controleur.initialiserPath(image);
	}
	
	/**
	 * Méthode permettant d'effectuer les changements visuels.
	 */
	public void paintComponent(Graphics g){

		 if(model.getPath() != "")
		 {
			  try {
			   BufferedImage  image = ImageIO.read(new File(model.getPath()));
			   float largeurZoom = 300*model.getNiveauZoom();
			   
			  g.drawImage(image, 0 + model.getTranslationX(),0+model.getTranslationY(),Math.round(largeurZoom),Math.round(largeurZoom),null);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }  
		}
	}
	
	/**
	 * @return Le chemin vers l'image.
	 */
	public String getPath(){
		return model.getPath();
	}
	
	/**
	 * @return La valeur du zoom effectué sur l'image.
	 */
	public float getZoom(){
		return model.getNiveauZoom();
	}
	
	/**
	 * @return La valeur de la translation effectuée sur l'image.
	 */
	public int getTranslation(){
		return model.getTranslation();
	}
	
	/**
	 * 
	 * @return Le model lié à la vue contenant toutes les informations (Nécéssaire à la sauvegarde).
	 */
	public PerspectiveModel getModel()
	{
		return model;
	}
	
	/**
	 * Permet d'ajouter un model contenant déj des informations à la vue (Nécessaire au chargement de sauvegarde.
	 * @param m : Model que l'on souhaite ajouter.
	 */
	public void setModel(PerspectiveModel m)
	{
		model = m;
	}

	/**
	 * Évènement effectué a chaque fois qu'il y a une modification dans la vue.
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		 repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		positionXDepart = arg0.getX();
		positionYDepart = arg0.getY();
		System.out.println("je suis dans le mouse press");
		estDansMemeVue = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(estDansMemeVue = true)
		{
			int posX = arg0.getX()- positionXDepart;
			int posY = arg0.getY() - positionYDepart;
			
			Commande c = new CommandeTranslation(model,posX,posY);
			controleur.executerCommande(c);
			estDansMemeVue = false;
		}

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		int notches = arg0.getWheelRotation();
		
		if(notches < 0)
		{
			Commande c = new CommandeZoom(model,true);
			controleur.executerCommande(c);
			
		}
		else
		{
			Commande c = new CommandeZoom(model,false);
			controleur.executerCommande(c);
		}
	}
}
