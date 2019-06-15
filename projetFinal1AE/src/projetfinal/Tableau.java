package projetfinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//https://www.geeksforgeeks.org/java-swing-jtable/
//http://www.java2s.com/Code/Java/Swing-JFC/AppendingaRowtoaJTableComponent.htm
public class Tableau{
	
	public JFrame fenetre;
	public JTable tableau;
	final int LARGEUR = 800;
	final int HAUTEUR = 600;
	public DefaultTableModel model = new DefaultTableModel();//modèle de tableau par défaut
	
	//Constructeur tableau produit de type B
	Tableau(String titreTableau, ArrayList<ProduitB> liste, String[] colonnes, ProduitB blank) {
		
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		
		tableau = new JTable(model);
		
		Container container = fenetre.getContentPane();
		
		//Création des colonnes 
		for(String colonne:colonnes) {
			model.addColumn(colonne);
		}
		//Création des lignes
		for(ProduitB produit:liste) {
			ajouterLigne(produit);
		}
		
		//Création du bouton
		JButton boutonAjout = new JButton();
		boutonAjout.setText("Ajouter un nouveau produit");//Texte inscrit sur le bouton
		container.add(boutonAjout, BorderLayout.PAGE_END);//Mise en page
		
		boutonAjout.addActionListener(new ActionListener() {//Gestion du click et fonction anonyme
				public void actionPerformed(ActionEvent evenement) {
					ajouterLigne("PRODUIT_B");
				}
			}
		);
		
		JScrollPane sp = new JScrollPane(tableau);
		fenetre.add(sp);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fenêtre GUI
		fenetre.setVisible(true);
	}
	
	//Constructeur tableau produit de type A
	Tableau(String titreTableau, ArrayList<ProduitA> liste, String[] colonnes, ProduitA blank) {
		
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		
		tableau = new JTable(model);
		
		Container container = fenetre.getContentPane();
		
		//Création des colonnes 
		for(String colonne:colonnes) {
			model.addColumn(colonne);
		}
		//Création des lignes
		for(ProduitA produit:liste) {
			ajouterLigne(produit);
		}
		
		//Création du bouton
		JButton boutonAjout = new JButton();
		boutonAjout.setText("Ajouter un nouveau produit");//Texte inscrit sur le bouton
		container.add(boutonAjout, BorderLayout.PAGE_END);//Mise en page
		
		boutonAjout.addActionListener(new ActionListener() {//Gestion du click et fonction anonyme
				public void actionPerformed(ActionEvent evenement) {
					ajouterLigne("PRODUIT_A");
				}
			}
		);
		
		JScrollPane sp = new JScrollPane(tableau);
		fenetre.add(sp);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fenêtre GUI
		fenetre.setVisible(true);
	}

	public void ajouterLigne(ProduitB produit) {
		model.addRow(new Object[] {produit.nom, produit.ville, produit.prix+"€", produit.quantité, produit.réduction+"%"});
	}
	
	public void ajouterLigne(ProduitA produit) {
		model.addRow(new Object[] {produit.nom, produit.ville, produit.prix+"€", produit.quantité, produit.getQualité()});
	}
	
	
	public void ajouterLigne(String type) {
		if(type.equals("PRODUIT_B")) {
			ProduitB produit= new ProduitB();
			produit.nom= JOptionPane.showInputDialog(fenetre,"Entrez le nom du produit");
			produit.ville= JOptionPane.showInputDialog(fenetre,"Entrez la ville de provenance du produit ");
			produit.prix= Float.parseFloat(JOptionPane.showInputDialog(fenetre,"Entrez le prix unitaire du produit"));
			produit.quantité= Integer.parseInt(JOptionPane.showInputDialog(fenetre,"Entrez le nombre d'unités"));
			produit.réduction= Integer.parseInt(JOptionPane.showInputDialog(fenetre,"Entrez la réduction appliquable au produit"));
			ajouterLigne(produit);
			Manager.mettreAJourListe(produit);
		}
		else if(type.equals("PRODUIT_A")){
			ProduitA produit= new ProduitA();
			produit.nom= JOptionPane.showInputDialog(fenetre,"Entrez le nom du produit");
			produit.ville= JOptionPane.showInputDialog(fenetre,"Entrez la ville de provenance du produit ");
			produit.prix= Float.parseFloat(JOptionPane.showInputDialog(fenetre,"Entrez le prix unitaire du produit"));
			produit.quantité= Integer.parseInt(JOptionPane.showInputDialog(fenetre,"Entrez le nombre d'unités"));
			String[] choix = new String[] {"Haut de gamme", "Bas de gamme"};
			String qualitéNouveauProduit =(String) JOptionPane.showInputDialog(fenetre, "Entrez la qualité du produit","",
																																			JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
			if(qualitéNouveauProduit.equals("Haut de gamme")) {
				produit.qualité= Qualité.haut_de_gamme;
			}else {
				produit.qualité= Qualité.bas_de_gamme;
			}
			ajouterLigne(produit);
			Manager.mettreAJourListe(produit);
		}
	}
}