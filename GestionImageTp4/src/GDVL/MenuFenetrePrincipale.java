/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: MenuFenetrePrincipale.java
Date créé: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-02-18 Version initiale
*******************************************************/  
package GDVL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import java.io.File;   

public class MenuFenetrePrincipale extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2389774281279071077L;
	private JMenuBar menuBar = new JMenuBar();
	private JFileChooser fileChooser = new JFileChooser();
	private String PathImage = "";
	MenuFenetrePrincipale()
	{
		JMenu menu = new JMenu("Image");
		menu.setMnemonic(KeyEvent.VK_I);
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Charger Image",KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Image chargée");
		menuItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(jpg,png,jpeg)", "jpg", "png", "jpeg");
				  fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				  fileChooser.addChoosableFileFilter(filter);
				  fileChooser.setAcceptAllFileFilterUsed(false);
				  //Resultat : Contient si il a choisi une image ou pas
				  int resultat = fileChooser.showOpenDialog(menuBar);
				  if (resultat == JFileChooser.APPROVE_OPTION) {
					  File selectedFile = fileChooser.getSelectedFile();
					  PathImage = selectedFile.getAbsolutePath().toString();
				  }
			  }
		});
		menu.add(menuItem);	
		add(menuBar);	
	}
	
	public String getPathImage()
	{
		return PathImage;
	}
}
