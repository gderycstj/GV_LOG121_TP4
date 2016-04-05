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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.border.TitledBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class VuePerspective extends JComponent implements Observer, MouseListener, MouseWheelListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1279976614214775078L;
	private static final Dimension DIMENSION = new Dimension(300,300);
	private ControleurPerspective controleur;
	private PerspectiveModel model;
	
	VuePerspective(ControleurPerspective cont, PerspectiveModel model){
		this.controleur = cont;
		this.model = model;
		InitUI();
	}
	
	private void InitUI()
	{
		setLayout(null);
	    
	  //Ajout des fenêtres comme observeur de notre modèle
	    model.addObserver(this);  
	    this.addMouseListener(this);
	    this.addMouseWheelListener(this);
		this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}

	
	public void setPath(String image)
	{
		model.setPath(image);
	}
	
	public void paintComponent(Graphics g){
		 if(model.getPath() != "")
		 {
			  try {
			   BufferedImage  image = ImageIO.read(new File(model.getPath()));
			   g.drawImage(image, 0 + model.getTranslation(), 0, 300*model.getNiveauZoom(),300*model.getNiveauZoom(),null);
			   
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }  
		}
	}
	
	public String getPath(){
		return model.getPath();
	}
	
	public int getZoom(){
		return model.getNiveauZoom();
	}
	
	public int getTranslation(){
		return model.getTranslation();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		 repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		model.effectuerTranslation();
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		model.effectuerZoom();
	}
}
