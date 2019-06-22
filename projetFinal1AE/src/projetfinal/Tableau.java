package projetfinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

public class Tableau extends JFrame implements WindowListener{
	
	private final int LARGEUR = 800;
	private final int HAUTEUR = 600;
	private JFrame fenetre;
	public JTable tableau;
	public TypeProduit typeProduit;
	public Tableau instance;
	public static Formulaire formulaire;
	
	//Constructeur du tableau
	Tableau(String titreTableau,String[] colonnes, String [][] données, TypeProduit typeProduit) {
		
		this.typeProduit = typeProduit;
		fenetre = new JFrame();
		fenetre.addWindowListener(this);
		fenetre.setTitle(titreTableau);
		fenetre.setResizable(false);
		fenetre.setSize(LARGEUR, HAUTEUR);//Dimensions de la fenêtre GUI
		fenetre.setLocationRelativeTo(null);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		/*if(typeProduit==TypeProduit.TYPEA) fenetre.setLocation(tailleEcran.width/4-LARGEUR/2, tailleEcran.height/2-HAUTEUR/2);
		else fenetre.setLocation(3*(tailleEcran.width/4)-LARGEUR/2, tailleEcran.height/2-HAUTEUR/2);*/
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
					formulaire = new Formulaire(colonnes, fenetre, instance);
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
		if(Tableau.formulaire!=null) {
			Tableau.formulaire.fenetre.dispose();
			Tableau.formulaire.fenetre.setVisible(false);
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
