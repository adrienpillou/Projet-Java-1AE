package projetfinal;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire {
	
	public static JFrame fenetre = new JFrame("Ajout d'un produit");
	public static Tableau tableau;
	
	public static JTextField champNom;
	public static JTextField champVille;
	public static JTextField champPrix;
	public static JTextField champQuantit�;
	public static JTextField champR�duction;
	public static JComboBox choixQualit�;
	
	//Cr�ation d'un formulaire contenant des champs relatif aux attributs
	public Formulaire(String[] labels, JFrame parent, Tableau tableau){
		
		this.tableau=tableau;
		fenetre.setSize(350,175);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(parent);
		
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(labels.length+1,2));
		
		MoteurFormulaire moteur = new MoteurFormulaire();
		
		panel.add(new JLabel(labels[0]));
		champNom = new JTextField();
		panel.add(champNom);
		
		panel.add(new JLabel(labels[1]));
		champVille = new JTextField();
		panel.add(champVille);
		
		panel.add(new JLabel(labels[2]));
		champPrix = new JTextField();
		panel.add(champPrix);
		
		panel.add(new JLabel(labels[3]));
		champQuantit� = new JTextField();
		panel.add(champQuantit�);
		
		panel.add(new JLabel(labels[4]));
		if(tableau.typeProduit==TypeProduit.TYPEB) {
			champR�duction = new JTextField();
			panel.add(champR�duction);
		}else {
			String[] options = new String[2];
			options[0]=Qualit�.getQualit�(Qualit�.bas_de_gamme);
			options[1]=Qualit�.getQualit�(Qualit�.haut_de_gamme);
			choixQualit� = new JComboBox(options) ;
			panel.add(choixQualit�);
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
	
	//Fermer le formulaire
	public static void annulerAjout() {
		Formulaire.fenetre.setVisible(false);
		Formulaire.fenetre.dispose();
	}
	
	//R�cup�rer le contenu des champs de texte
	public static void r�cup�rerDonn�es() {
		if(v�rifierLesChamps()){
			if(Formulaire.tableau.typeProduit==TypeProduit.TYPEB ) {
				ProduitB produit = new ProduitB();
				produit.nom=Formulaire.champNom.getText();
				produit.ville=Formulaire.champVille.getText();
				produit.prix=Float.parseFloat(Formulaire.champPrix.getText());
				produit.quantit�=Integer.parseInt(Formulaire.champQuantit�.getText());
				produit.r�duction=Integer.parseInt(Formulaire.champR�duction.getText());
				Formulaire.tableau.ajouterLigne(produit);
			}else {
				ProduitA produit = new ProduitA();
				produit.nom=Formulaire.champNom.getText();
				produit.ville=Formulaire.champVille.getText();
				produit.prix=Float.parseFloat(Formulaire.champPrix.getText());
				produit.quantit�=Integer.parseInt(Formulaire.champQuantit�.getText());
				produit.qualit�=(String)Formulaire.choixQualit�.getSelectedItem();
				Formulaire.tableau.ajouterLigne(produit);
			}
			Formulaire.fenetre.setVisible(false);
			Formulaire.fenetre.dispose();
		}
	}
	
	//V�rifier les champs de texte
	public static boolean v�rifierLesChamps() {
		Component[] champs = Formulaire.fenetre.getContentPane().getComponents();
		for(Component champ:champs) {
			if(champ.toString().contains("javax.swing.JTextField")) {
				JTextField champAV�rifier = (JTextField) champ;
				if(champAV�rifier.getText().equals(null) || champAV�rifier.getText().length()==0) {
					JOptionPane.showMessageDialog(Formulaire.fenetre,"Veuillez remplir tous les champs !",
																					"Erreur lors de l'ajout",JOptionPane.ERROR_MESSAGE);
					return false;
				}
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
			Formulaire.r�cup�rerDonn�es();
		}else {
			Formulaire.annulerAjout();
		}
	}
}