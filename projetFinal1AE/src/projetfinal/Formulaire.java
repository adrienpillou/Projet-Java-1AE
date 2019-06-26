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
	public static JTextField champQuantit�;
	public static JTextField champR�duction;
	public static JComboBox choixQualit�;
	
	//Cr�ation d'un formulaire contenant des champs relatif aux attributs
	public Formulaire(String[] labels, JFrame parent, Tableau tableau){
		
		this.tableau=tableau;
		fenetre.setSize(350,175);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(parent);
		
		//Cr�ation du panel et disposition
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(labels.length+1,2));
		
		MoteurFormulaire moteur = new MoteurFormulaire();
		MoteurChampNum�rique moteurChampNum = new MoteurChampNum�rique();
		
		//Cr�ation des composants JTextField, JLabel, JComboBox
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
		champQuantit� = new JTextField();
		champQuantit�.addKeyListener(moteurChampNum);
		panel.add(champQuantit�);
		
		panel.add(new JLabel(labels[4]));
		if(tableau.typeProduit==TypeProduit.TYPEB) {
			champR�duction = new JTextField();
			champR�duction.addKeyListener(moteurChampNum);
			panel.add(champR�duction);
		}else {
			String[] options = new String[2];
			options[0]=Qualit�.getQualit�(Qualit�.bas_de_gamme);
			options[1]=Qualit�.getQualit�(Qualit�.haut_de_gamme);
			choixQualit� = new JComboBox(options) ;
			panel.add(choixQualit�);
		}
		
		JButton boutonAjouter=new JButton("Ajouter"); //Cr�ation du bouton ajouter
 		boutonAjouter.addActionListener(moteur);
		panel.add(boutonAjouter);
		
		JButton boutonAnnuler=new JButton("Annuler"); //Cr�ation du bouton supprimer
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
	
	//R�cup�rer le contenu des champs de texte
	public static void r�cup�rerDonn�es() {
		if(v�rifierLesChamps()){// V�rification des champs afin d'�viter les erreurs
			if(Formulaire.tableau.typeProduit==TypeProduit.TYPEB ) {
				ProduitB produit = new ProduitB();
				produit.nom=Formulaire.champNom.getText();
				produit.ville=Formulaire.champVille.getText();
				produit.prix=Float.parseFloat(Formulaire.champPrix.getText());
				produit.quantit�=(int)Float.parseFloat(Formulaire.champQuantit�.getText());
				produit.r�duction=(int)Float.parseFloat(Formulaire.champR�duction.getText());
				Formulaire.tableau.ajouterLigne(produit);
			}else {
				ProduitA produit = new ProduitA();
				produit.nom=Formulaire.champNom.getText();
				produit.ville=Formulaire.champVille.getText();
				produit.prix=Float.parseFloat(Formulaire.champPrix.getText());
				produit.quantit�=(int)Float.parseFloat(Formulaire.champQuantit�.getText());
				produit.qualit�=(String)Formulaire.choixQualit�.getSelectedItem();
				Formulaire.tableau.ajouterLigne(produit);
			}
			Formulaire.fenetre.setVisible(false);
			Formulaire.fenetre.dispose(); // fermeture du JFrame
		}
	}
	
	//V�rifier les champs de texte
	public static boolean v�rifierLesChamps() {
		Component[] champs = Formulaire.fenetre.getContentPane().getComponents(); //R�cup�ration des composants du panel
		for(Component champ:champs) { //Foreach parcourant les composants
			if(champ.toString().contains("javax.swing.JTextField")) { //Si le composant est un JTextField
				JTextField champAV�rifier = (JTextField) champ;
				if(champAV�rifier.getText().equals(null) || champAV�rifier.getText().length()==0) { // V�rification
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
		JButton boutonCliqu� = (JButton)event.getSource();
		if(boutonCliqu�.getText().equals("Ajouter")) { //Appuie du bouton ajouter
			Formulaire.r�cup�rerDonn�es();
		}else { //Appuie du bouton annuler
			Formulaire.annulerAjout();
		}
	}
}

//Restreint un champ de texte � recevoir uniquement des nombres
class MoteurChampNum�rique implements KeyListener{

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
		char caract�reTap� = arg0.getKeyChar();
		//Si la touche appuy� est num�rique ou un point
		if(!(Character.isDigit(caract�reTap�) || (caract�reTap� == KeyEvent.VK_DELETE) || (caract�reTap�=='.'))) {
			arg0.consume(); //Ignore la caract�re tap�
		}
	}
	
}