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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VuePerspective extends JComponent implements Observeur{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1279976614214775078L;
	private static final Dimension DIMENSION = new Dimension(300,300);
	private String Path = "";
	private ControleurPerspective controleur;
	VuePerspective(ControleurPerspective cont){
		controleur = cont;
		InitUI();
	}
	
	private void InitUI()
	{
		setLayout(null);
		MenuFenetreVues menu = new MenuFenetreVues();
		menu.setBounds(0, 0, 450, 32);
		add(menu);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBounds(383, 266, 57, 23);
		add(btnUndo);
		this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}

	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		
	} 
	
	public void setPath(String image)
	{
		Path = image;
		repaint();
	}
	
	public void paintComponent(Graphics g){
		 if(Path != "")
		 {
			  try {
			   BufferedImage  image = ImageIO.read(new File(Path));
			   g.drawImage(image, 0, 30, 300,270,null);
			   
			   
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }  
		}
	}
}
