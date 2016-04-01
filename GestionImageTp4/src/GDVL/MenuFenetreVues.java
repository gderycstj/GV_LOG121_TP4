/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: MenuFenetreVues.java
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

public class MenuFenetreVues extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2389774281279071077L;
	private JMenuBar menuBar = new JMenuBar();
	MenuFenetreVues()
	{
		JMenu menu = new JMenu("Fichier");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Sauvegarder Image");
		menuItem.getAccessibleContext().setAccessibleDescription("Sauvegarder l'image sur le disque");
		menuItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  //Sauvegarde
			  }
		});
		menu.add(menuItem);		
		add(menuBar);	
	}
}
