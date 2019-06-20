package projetfinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tableau {
	
	private final int LARGEUR = 800;
	private final int HAUTEUR = 600;
	private JFrame fenetre;
	public JTable tableau;
	public TypeProduit typeProduit;
	public Tableau instance;
	
	//Constructeur du tableau
	Tableau(String titreTableau,String[] colonnes, String [][] données, TypeProduit typeProduit) {
		
		this.typeProduit = typeProduit;
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		fenetre.setResizable(false);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fenêtre GUI
		fenetre.setLocationRelativeTo(null);
		tableau = new JTable(new DefaultTableModel(données,colonnes));
		tableau.setEnabled(false);
		instance=this;
		
		//Création des boutons
		JPanel boutons =new JPanel();
		JButton boutonAjout = new JButton("Ajouter");
		JButton boutonSup = new JButton("Supprimer");
		boutons.add(boutonAjout);
		boutons.add(boutonSup);
		fenetre.getContentPane().add(boutons, BorderLayout.SOUTH);
		
		boutonAjout.addActionListener(new ActionListener() {//Gestion du click et fonction anonyme
				public void actionPerformed(ActionEvent evenement) {
					/*if(typeProduit == TypeProduit.TYPEB)ajouterLigne(new ProduitB());
					else ajouterLigne(new ProduitA());*/
					new Formulaire(colonnes, fenetre, instance);
				}
			}
		);
		
		boutonSup.addActionListener(new ActionListener() {//Gestion du boutton  et fonction anonyme
				public void actionPerformed(ActionEvent evenement) {
					supprimerLigne();
				}
			}
		);
		
		JScrollPane sp = new JScrollPane(tableau);
		fenetre.add(sp);
		fenetre.setVisible(true);
	}
	
	public void ajouterLigne(ProduitB produit) {
		Manager.listeB.add(produit);
		Manager.afficherListeB();
		String[] ligne = Manager.formaterProduit(produit);
		((DefaultTableModel)tableau.getModel()).addRow(new Object[] {ligne[0], ligne[1], ligne[2], ligne[3], ligne[4]});
	}
	
	public void ajouterLigne(ProduitA produit) {
		Manager.listeA.add(produit);
		String[] ligne = Manager.formaterProduit(produit);
		((DefaultTableModel)tableau.getModel()).addRow(new Object[] {ligne[0], ligne[1], ligne[2], ligne[3], ligne[4]});
	}
	
	public void supprimerLigne() {
		if(tableau.getRowCount()>0) {
			if(typeProduit == TypeProduit.TYPEB)Manager.listeB.remove(tableau.getRowCount()-1);
			else Manager.listeA.remove(tableau.getRowCount()-1);
			((DefaultTableModel)tableau.getModel()).removeRow(tableau.getRowCount()-1);
		}
	}
}


enum TypeProduit{
	TYPEB, TYPEA;
}
