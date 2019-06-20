package projetfinal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire {
	
	public static JFrame fenetre = new JFrame("Ajout d'un produit");
	public static JTextField[] champs = new JTextField[5];
	public Tableau tableau;
	
	//Création d'un formulaire contenant des champs relatif aux attributs
	public Formulaire(String[] labels, JFrame parent, Tableau tableau){
		
		this.tableau=tableau;
		fenetre.setSize(350,175);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(parent);
		
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(labels.length+1,2));
		
		MoteurFormulaire moteur = new MoteurFormulaire();
		
		panel.add(new JLabel(labels[0]));
		JTextField champNom = new JTextField();
		panel.add(champNom);
		
		panel.add(new JLabel(labels[1]));
		JTextField champVille = new JTextField();
		panel.add(champVille);
		
		panel.add(new JLabel(labels[2]));
		JTextField champPrix = new JTextField();
		panel.add(champPrix);
		
		panel.add(new JLabel(labels[3]));
		JTextField champQuantité = new JTextField();
		panel.add(champQuantité);
		
		panel.add(new JLabel(labels[4]));
		if(tableau.typeProduit==TypeProduit.TYPEB) {
			JTextField champRéduction = new JTextField();
			panel.add(champRéduction);
		}else {
			String[] options = {"Haut de gamme","Bas de gamme"};
			JComboBox choixQualité = new JComboBox(options) ;
			panel.add(choixQualité);
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
		Formulaire.fenetre.setVisible(false);
		Formulaire.fenetre.dispose();
	}
	
	//Fermer le formulaire
	public static void annulerAjout() {
		Formulaire.fenetre.setVisible(false);
		Formulaire.fenetre.dispose();
	}
	
	//Récupérer le contenu des champs de texte
	public static ProduitB récupérerDonnées() {
		if(vérifierLesChamps()) {
			ProduitB nouveauProduit=new ProduitB();
			nouveauProduit.nom=champs[0].getText();
			nouveauProduit.ville=champs[1].getText();
			nouveauProduit.prix=Float.parseFloat(champs[2].getText());
			nouveauProduit.quantité=Integer.parseInt(champs[3].getText());
			nouveauProduit.réduction=Integer.parseInt(champs[4].getText());
			return nouveauProduit;
		}else {
			return new ProduitB();
		}
	}
	
	//Vérifier les champs de texte
	public static boolean vérifierLesChamps() {
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
		JButton boutonCliqué = (JButton)event.getSource();
		if(boutonCliqué.getText().equals("Ajouter")) {
			//Formulaire.ajouterProduit(Formulaire.récupérerDonnées());
		}else {
			Formulaire.annulerAjout();
		}
	}
}