package projetfinal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Tableau extends JFrame implements WindowListener{
	
	private final int LARGEUR = 800; //Largeur du JFrame 
	private final int HAUTEUR = 600; //Hauteur du JFrame
	private JFrame fenetre;
	public JTable tableau;
	public TypeProduit typeProduit; //Enum�ration sp�cifiant le type de produit contenu dans le tableau
	public Tableau instance; // instance n�cessaire au formulaire
	public static Formulaire formulaire;
	
	//Constructeur du tableau
	public Tableau(String titreTableau,String[] colonnes, String [][] donn�es, TypeProduit typeProduit) {
		
		this.typeProduit = typeProduit;
		fenetre = new JFrame(); //Cr�ation de la fenetre
		fenetre.addWindowListener(this);
		fenetre.setTitle(titreTableau);
		fenetre.setResizable(false);
		fenetre.setSize(LARGEUR, HAUTEUR); //Dimensions de la fen�tre GUI
		fenetre.setLocationRelativeTo(null); //Faire appara�tre le JFrame au milieu de l'�cran
		/*Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		if(typeProduit==TypeProduit.TYPEA) fenetre.setLocation(tailleEcran.width/4-LARGEUR/2, tailleEcran.height/2-HAUTEUR/2);
		else fenetre.setLocation(3*(tailleEcran.width/4)-LARGEUR/2, tailleEcran.height/2-HAUTEUR/2);*/
		tableau = new JTable(new DefaultTableModel(donn�es,colonnes));
		tableau.setEnabled(false);
		instance=this;
		
		//Cr�ation des boutons et disposition de ceux-ci
		JPanel boutons =new JPanel();
		JButton boutonAjout = new JButton("Ajouter");
		JButton boutonSup = new JButton("Supprimer");
		boutons.add(boutonAjout);
		boutons.add(boutonSup);
		fenetre.getContentPane().add(boutons, BorderLayout.SOUTH);
		
		boutonAjout.addActionListener(new ActionListener() {//Gestion du bouton ajouter
				public void actionPerformed(ActionEvent evenement) {
					formulaire = new Formulaire(colonnes, fenetre, instance);
				}
			}
		);
		
		boutonSup.addActionListener(new ActionListener() {//Gestion du bouton supprimer
				public void actionPerformed(ActionEvent evenement) {
					supprimerLigne();
				}
			}
		);
		
		JScrollPane sp = new JScrollPane(tableau); //Cr�ation d'une barre de scroll lat�rale
		fenetre.add(sp);
		fenetre.setVisible(true);
		
	}
	
	//Ajoute un produit B au tableau
	public void ajouterLigne(ProduitB produit) {
		Manager.listeB.add(produit);
		Manager.afficherListeB();
		((DefaultTableModel)tableau.getModel()).addRow(new Object[] {produit.nom, produit.ville, String.format("%.2f", produit.prix), produit.quantit�, produit.r�duction});
	}
	
	//Ajoute un produit A au tableau
	public void ajouterLigne(ProduitA produit) {
		Manager.listeA.add(produit);
		((DefaultTableModel)tableau.getModel()).addRow(new Object[] {produit.nom, produit.ville, String.format("%.2f", produit.prix), produit.quantit�, produit.qualit�});
	}
	
	//Supprime la derni�re ligne du tableau
	public void supprimerLigne() {
		if(tableau.getRowCount()>0) { //V�rifie s'il existe au moins une ligne dans le tableau
			if(typeProduit == TypeProduit.TYPEB)Manager.listeB.remove(tableau.getRowCount()-1);
			else Manager.listeA.remove(tableau.getRowCount()-1);
			((DefaultTableModel)tableau.getModel()).removeRow(tableau.getRowCount()-1);
		}
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		if(Tableau.formulaire!=null) {//Si une instance de formulaire est attach�e au tableau...
			Tableau.formulaire.fenetre.setVisible(false);
			Tableau.formulaire.fenetre.dispose(); //Fermetrure de ce formulaire
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

enum TypeProduit{
	TYPEB, TYPEA;
}
