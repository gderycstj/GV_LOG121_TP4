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
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;   

/**
 * Classe contenant le menu de la fenêtre principale et leur action.
 *	Fichier -> Charger image,Sauvegarder image, Charger sauvegarde.
 *	Commande -> Annuler commande.
 */
public class MenuFenetre extends JMenuBar{
	private static final long serialVersionUID = 2389774281279071077L;
	private JMenuBar menuBar = new JMenuBar();
	private JFileChooser fileChooser;
	private String PathImage = "";
	
	/**
	 * @param vs Contient la vue statique présente dans fenêtre principale.
	 * @param v1p Contient la vue perspective de gauche présente dans fenêtre principale.
	 * @param v2p Contient la vue perspective de droite présente dans fenêtre principale.
	 */
	MenuFenetre(VueStatique vs,VuePerspective v1p,VuePerspective v2p)
	{
		JMenu menu = new JMenu("Fichier");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Charger Image");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Image chargée");
		menuItem.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  fileChooser = new JFileChooser();
				  FileNameExtensionFilter filter = new FileNameExtensionFilter("Images(jpg,png,jpeg)", "jpg", "png", "jpeg");
				  fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				  fileChooser.addChoosableFileFilter(filter);
				  fileChooser.setAcceptAllFileFilterUsed(false);
				  //Resultat : Contient si il a choisi une image ou pas
				  int resultat = fileChooser.showOpenDialog(menuBar);
				  if (resultat == JFileChooser.APPROVE_OPTION) {
					  File selectedFile = fileChooser.getSelectedFile();
					  PathImage = selectedFile.getAbsolutePath().toString();
					  
					  vs.setPath(PathImage);
					  v1p.setPath(PathImage);
					  v2p.setPath(PathImage);
				  }
			  }
		});
		menu.add(menuItem);	
		JMenuItem menuItemSauvegarde = new JMenuItem("Sauvegarder Modification");
		menuItemSauvegarde.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItemSauvegarde.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  if(PathImage != "")
				  {
					  SauvegardeImage save = new SauvegardeImage("Image1.ser",v1p);
					  save = new SauvegardeImage("Image2.ser",v2p);
					  JOptionPane.showMessageDialog(null,"Sauvegarde terminée.");
				  }
				  else{
					  JOptionPane.showMessageDialog(null, "Il n'y a aucune information à sauvegarder. Veuillez charger une image pour pouvoir sauvegarder.");
				  }
			  }
		});
		menu.add(menuItemSauvegarde);
		
		JMenuItem menuItemCharger = new JMenuItem("Charger Sauvegarde");
		menuItemCharger.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		menuItemCharger.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  fileChooser = new JFileChooser();
				  FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier de sauvegarde(.ser)", "ser");
				  fileChooser.addChoosableFileFilter(filter);
				  fileChooser.setAcceptAllFileFilterUsed(false);
				  int resultat = fileChooser.showOpenDialog(menuBar);
				  if (resultat == JFileChooser.APPROVE_OPTION) {
					  String nomFichier = fileChooser.getSelectedFile().getAbsolutePath();
					  Object[] options = {"Image Gauche","Image Droite"};
					  int choixVue= JOptionPane.showOptionDialog(null,"Choissisez dans quel espace sera afficher l'image.","Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
					  if(choixVue == 0)
					  {
						  ChargerSauvegarde load = new ChargerSauvegarde(nomFichier,v1p);
						  vs.setPath(v1p.getPath());
						  v2p.setPath(v1p.getPath());
					  }
					  else
					  {
						  ChargerSauvegarde load = new ChargerSauvegarde(nomFichier,v2p);
						  vs.setPath(v2p.getPath());
						  v1p.setPath(v2p.getPath());
					  }
					  JOptionPane.showMessageDialog(null, "Chargement terminé.");
				  }
			  }
		});
		menu.add(menuItemCharger);
		
		JMenu menuCommande = new JMenu("Commande");
		menuBar.add(menuCommande);
		JMenuItem menuItemCommande = new JMenuItem("Annuler commande");
		menuItemCommande.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		menuItemCommande.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  GestionnaireCommande.getInstance().defaireCommande();
			  }
		});
		menuCommande.add(menuItemCommande);
		add(menuBar);	
	}
	
	public String getPathImage()
	{
		return PathImage;
	}
}
