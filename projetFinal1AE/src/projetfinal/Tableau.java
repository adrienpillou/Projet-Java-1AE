package projetfinal;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tableau {
	
	private final int LARGEUR = 800;
	private final int HAUTEUR = 600;
	private JFrame fenetre;
	public JTable tableau;
	public DefaultTableModel model = new DefaultTableModel();//mod�le de tableau par d�faut
	
	//Constructeur du tableau
	Tableau(String titreTableau,String[] colonnes, String [][] donn�es) {
		
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		fenetre.setResizable(false);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fen�tre GUI
		fenetre.setLocationRelativeTo(null);
		tableau = new JTable(model);
		Container container = fenetre.getContentPane();
		
		//Cr�ation du tableau
		//Cr�ation des colonnes 
		for(String colonne:colonnes) {
			model.addColumn(colonne);
		}
		//Cr�ation des lignes
		for(String[] ligne:donn�es) {
			ajouterLigne(ligne);
		}
		
		//Cr�ation du bouton Ajouter
		JButton boutonAjout = new JButton();
		boutonAjout.setText("Ajouter un nouveau produit");//Texte inscrit sur le bouton
		container.add(boutonAjout, BorderLayout.PAGE_END);//Mise en page
		
		boutonAjout.addActionListener(new ActionListener() {//Gestion du click et fonction anonyme
				public void actionPerformed(ActionEvent evenement) {
					new Formulaire(colonnes, fenetre);
				}
			}
		);

		JScrollPane sp = new JScrollPane(tableau);
		fenetre.add(sp);
		fenetre.setVisible(true);
	}
	
	public void ajouterLigne(String[] ligne) {
		this.model.addRow(new Object[] {ligne[0], ligne[1], ligne[2], ligne[3], ligne[4]});
	}
}