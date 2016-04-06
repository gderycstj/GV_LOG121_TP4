/******************************************************
Cours:  LOG121
Projet: GestionImageTp4
Nom du fichier: MenuFenetrePrincipale.java
Date cr��: 2016-03-31
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
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

public class MenuFenetre extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2389774281279071077L;
	private JMenuBar menuBar = new JMenuBar();
	private JFileChooser fileChooser;
	private String PathImage = "";
	
	MenuFenetre(VueStatique vs,VuePerspective v1p,VuePerspective v2p)
	{
		JMenu menu = new JMenu("Fichier");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Charger Image");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Image charg�e");
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
					  String PathSauvegarde = "";
					  int resultat = -1;
					  fileChooser = new JFileChooser();
					  FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier csv/txt","csv","txt");
					  fileChooser.addChoosableFileFilter(filter);
					  fileChooser.setAcceptAllFileFilterUsed(false);
					  fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					  fileChooser.setDialogTitle("Destination");
					  fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					  resultat = fileChooser.showOpenDialog(menuBar);
					  while(resultat == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile().getAbsolutePath().contains(".csv")== false)
					  {
						  //path ou on va enregistrer le fichier
						  if(fileChooser.getSelectedFile().getAbsolutePath().contains(".csv") == false || fileChooser.getSelectedFile().getAbsolutePath().contains(".txt") == false )
						  {
							  JOptionPane.showMessageDialog(null,"Le fichier que vous souhaitez cr�er doit �tre de type .csv ou .txt");
							  resultat = fileChooser.showOpenDialog(menuBar);
						  }
					  }
					  if(resultat == JFileChooser.APPROVE_OPTION && (fileChooser.getSelectedFile().getAbsolutePath().contains(".csv")== true || fileChooser.getSelectedFile().getAbsolutePath().contains(".txt")== true))
					  {
						  PathSauvegarde = fileChooser.getSelectedFile().getAbsolutePath();
						  //On peut lancer l'objet de sauvegarde
						  try {

								String images = "";
								SauvegardeImage save = new SauvegardeImage(v1p.getPath(),v1p.getZoom(),v1p.getTranslation());
								images = save.toString()+"\n";
								save.setPathImage(v2p.getPath());
								save.setZoom(v2p.getZoom());
								save.setTranslation(v2p.getTranslation());
								images += save.toString()+"\n";

								File file = new File(PathSauvegarde);

								// if file doesnt exists, then create it
								if (!file.exists()) {
									file.createNewFile();
								}

								FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.append(images);
								bw.close();
								JOptionPane.showMessageDialog(null,"Sauvegarde termin�e");

							} catch (IOException e) {
								e.printStackTrace();
							}
					  }
				  }
				  else{
					  JOptionPane.showMessageDialog(null, "Il n'y a aucune information � sauvegarder. Veuillez charger une image pour pouvoir sauvegarder.");
				  }
			  }
		});
		menu.add(menuItemSauvegarde);
		
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
