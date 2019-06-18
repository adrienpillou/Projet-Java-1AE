package projetfinal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire {
	
	public static JFrame fenetre = new JFrame("Ajout d'un produit");
	public static JTextField[] champs = new JTextField[5];
	
	//Cr�ation d'un formulaire contenant des champs relatif aux attributs
	public Formulaire(String[] labels, JFrame parent){
		
		fenetre.setSize(400,200);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(parent);
		
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(labels.length+1,2));
		
		MoteurFormulaire moteur = new MoteurFormulaire();
		
		for(int i=0;i<labels.length;i++) {
			JLabel labelMarge= new JLabel(labels[i]);
			panel.add(labelMarge);
			JTextField champTexte = new JTextField(); 
			labelMarge.setLabelFor(champTexte);
			champs[i]=champTexte;
			panel.add(champTexte);
		}
		
		JButton boutonAjouter=new JButton("Ajouter");
		boutonAjouter.addActionListener(moteur);
		panel.add(boutonAjouter);
		
		JButton boutonAnnuler=new JButton("Annuler");
		boutonAnnuler.addActionListener(moteur);
		panel.add(boutonAnnuler);
		
		fenetre.setContentPane(panel);
		fenetre.setVisible(true);
	}
	
	//Ajouter un Produit de type B
	public static void ajouterProduit(ProduitB produit) {
		Manager.listeB.add(produit);
		Tableau.ajouterLigne(produit);
		Formulaire.fenetre.setVisible(false);
		Formulaire.fenetre.dispose();
	}
	
	//Fermer le formulaire
	public static void annulerAjout() {
		Formulaire.fenetre.setVisible(false);
		Formulaire.fenetre.dispose();
	}
	
	//R�cup�rer le contenu des champs de texte
	public static ProduitB r�cup�rerDonn�es() {
		if(v�rifierLesChamps()) {
			ProduitB nouveauProduit=new ProduitB();
			nouveauProduit.nom=champs[0].getText();
			nouveauProduit.ville=champs[1].getText();
			nouveauProduit.prix=Float.parseFloat(champs[2].getText());
			nouveauProduit.quantit�=Integer.parseInt(champs[3].getText());
			nouveauProduit.r�duction=Integer.parseInt(champs[4].getText());
			return nouveauProduit;
		}else {
			return new ProduitB();
		}
	}
	
	//V�rifier les champs de texte
	public static boolean v�rifierLesChamps() {
		for(JTextField champ:champs) {
			if(champ.getText().length()==0) {
				return false;
			}
		}
		return true;
	}
}

//Moteur du widget Formulaire
class MoteurFormulaire implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		JButton boutonCliqu� = (JButton)event.getSource();
		if(boutonCliqu�.getText().equals("Ajouter")) {
			Formulaire.ajouterProduit(Formulaire.r�cup�rerDonn�es());
		}else {
			Formulaire.annulerAjout();
		}
	}
}
