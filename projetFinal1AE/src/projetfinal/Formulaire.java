package projetfinal;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	public static JTextField champQuantité;
	public static JTextField champRéduction;
	public static JComboBox choixQualité;
	
	//Création d'un formulaire contenant des champs relatif aux attributs
	public Formulaire(String[] labels, JFrame parent, Tableau tableau){
		
		this.tableau=tableau;
		fenetre.setSize(350,175);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(parent);
		
		//Création du panel et disposition
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(labels.length+1,2));
		
		MoteurFormulaire moteur = new MoteurFormulaire();
		MoteurChampNumérique moteurChampNum = new MoteurChampNumérique();
		
		//Création des composants JTextField, JLabel, JComboBox
		panel.add(new JLabel(labels[0]));
		champNom = new JTextField();
		panel.add(champNom);
		
		panel.add(new JLabel(labels[1]));
		champVille = new JTextField();
		panel.add(champVille);
		
		panel.add(new JLabel(labels[2]));
		champPrix = new JTextField();
		champPrix.addKeyListener(moteurChampNum);
		panel.add(champPrix);
		
		panel.add(new JLabel(labels[3]));
		champQuantité = new JTextField();
		champQuantité.addKeyListener(moteurChampNum);
		panel.add(champQuantité);
		
		panel.add(new JLabel(labels[4]));
		if(tableau.typeProduit==TypeProduit.TYPEB) {
			champRéduction = new JTextField();
			champRéduction.addKeyListener(moteurChampNum);
			panel.add(champRéduction);
		}else {
			String[] options = new String[2];
			options[0]=Qualité.getQualité(Qualité.bas_de_gamme);
			options[1]=Qualité.getQualité(Qualité.haut_de_gamme);
			choixQualité = new JComboBox(options) ;
			panel.add(choixQualité);
		}
		
		JButton boutonAjouter=new JButton("Ajouter"); //Création du bouton ajouter
 		boutonAjouter.addActionListener(moteur);
		panel.add(boutonAjouter);
		
		JButton boutonAnnuler=new JButton("Annuler"); //Création du bouton supprimer
		boutonAnnuler.addActionListener(moteur);
		panel.add(boutonAnnuler);
		
		fenetre.setContentPane(panel);
		fenetre.setVisible(true);
	}
	
	//Annuler l'ajout et fermer le formulaire
	public static void annulerAjout() {
		Formulaire.fenetre.setVisible(false);
		Formulaire.fenetre.dispose(); // fermeture du JFrame
	}
	
	//Récupérer le contenu des champs de texte
	public static void récupérerDonnées() {
		if(vérifierLesChamps()){// Vérification des champs afin d'éviter les erreurs
			if(Formulaire.tableau.typeProduit==TypeProduit.TYPEB ) {
				ProduitB produit = new ProduitB();
				produit.nom=Formulaire.champNom.getText();
				produit.ville=Formulaire.champVille.getText();
				produit.prix=Float.parseFloat(Formulaire.champPrix.getText());
				produit.quantité=(int)Float.parseFloat(Formulaire.champQuantité.getText());
				produit.réduction=(int)Float.parseFloat(Formulaire.champRéduction.getText());
				Formulaire.tableau.ajouterLigne(produit);
			}else {
				ProduitA produit = new ProduitA();
				produit.nom=Formulaire.champNom.getText();
				produit.ville=Formulaire.champVille.getText();
				produit.prix=Float.parseFloat(Formulaire.champPrix.getText());
				produit.quantité=(int)Float.parseFloat(Formulaire.champQuantité.getText());
				produit.qualité=(String)Formulaire.choixQualité.getSelectedItem();
				Formulaire.tableau.ajouterLigne(produit);
			}
			Formulaire.fenetre.setVisible(false);
			Formulaire.fenetre.dispose(); // fermeture du JFrame
		}
	}
	
	//Vérifier les champs de texte
	public static boolean vérifierLesChamps() {
		Component[] champs = Formulaire.fenetre.getContentPane().getComponents(); //Récupération des composants du panel
		for(Component champ:champs) { //Foreach parcourant les composants
			if(champ.toString().contains("javax.swing.JTextField")) { //Si le composant est un JTextField
				JTextField champAVérifier = (JTextField) champ;
				if(champAVérifier.getText().equals(null) || champAVérifier.getText().length()==0) { // Vérification
					JOptionPane.showMessageDialog(Formulaire.fenetre,"Veuillez remplir tous les champs !",
																					"Erreur lors de l'ajout",JOptionPane.ERROR_MESSAGE); //Message d'erreur
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
		JButton boutonCliqué = (JButton)event.getSource();
		if(boutonCliqué.getText().equals("Ajouter")) { //Appuie du bouton ajouter
			Formulaire.récupérerDonnées();
		}else { //Appuie du bouton annuler
			Formulaire.annulerAjout();
		}
	}
}

//Restreint un champ de texte à recevoir uniquement des nombres
class MoteurChampNumérique implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		JTextField source = (JTextField)arg0.getSource();
		char caractèreTapé = arg0.getKeyChar();
		//Si la touche appuyé est numérique ou un point
		if(!(Character.isDigit(caractèreTapé) || (caractèreTapé == KeyEvent.VK_DELETE) || (caractèreTapé=='.'))) {
			arg0.consume(); //Ignore la caractère tapé
		}
	}
	
}