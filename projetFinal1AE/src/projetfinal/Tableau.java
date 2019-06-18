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
	
	private JFrame fenetre;
	public JTable tableau;
	private final int LARGEUR = 800;
	private final int HAUTEUR = 600;
	public static DefaultTableModel model = new DefaultTableModel();//modèle de tableau par défaut
	
	//Constructeur tableau produit de type B
	Tableau(String titreTableau, ArrayList<ProduitB> liste, String[] colonnes, ProduitB blank) {
		
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		fenetre.setResizable(false);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fenêtre GUI
		fenetre.setLocationRelativeTo(null);
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
		
		//Création du bouton Ajouter
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
	
	//Constructeur tableau produit de type A
	Tableau(String titreTableau, ArrayList<ProduitA> liste, String[] colonnes, ProduitA blank) {
		
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		fenetre.setResizable(false);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fenêtre GUI
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
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
					new Formulaire(colonnes, fenetre);
				}
			}
		);
		
		JScrollPane sp = new JScrollPane(tableau);
		fenetre.add(sp);
		fenetre.setVisible(true);
	}

	public static void ajouterLigne(ProduitB produit) {
		model.addRow(new Object[] {produit.nom, produit.ville, String.format("%.2f",produit.prix)+"€", produit.quantité, produit.réduction+"%"});
	}
	
	public static void ajouterLigne(ProduitA produit) {
		model.addRow(new Object[] {produit.nom, produit.ville, String.format("%.2f",produit.prix)+"€", produit.quantité, produit.getQualité()});
	}
	
}