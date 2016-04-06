/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: VueStatique.java
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

public class VueStatique extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7010702140699097203L;
	public static final Dimension DIMENSION = new Dimension(250,250);
	private String Path = "";
	VueStatique(){
		this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	public void setPath(String images)
	{
		Path = images;
		repaint();
	}

	@Override 
	public Dimension getPreferredSize(){
		return DIMENSION;
	}
	
	public void paintComponent(Graphics g){
		if (Path != "")
		{
			try {
				BufferedImage  image = ImageIO.read(new File(Path));
				g.drawImage(image, 170, 0, 270,250,null);
			 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }  
		}
	}

}
