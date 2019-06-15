package projetfinal;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//https://www.geeksforgeeks.org/java-swing-jtable/
//http://www.java2s.com/Code/Java/Swing-JFC/AppendingaRowtoaJTableComponent.htm
public class Tableau{
	
	JFrame fenetre;
	public JTable tableau;
	final int LARGEUR = 800;
	final int HAUTEUR = 600;
	
	Tableau(String titreTableau, String[][] données, String[] colonnes) {
		fenetre = new JFrame();
		fenetre.setTitle(titreTableau);
		
		tableau = new JTable(données, colonnes);
		tableau.setBounds(30, 40, 200, 300);
		
		JScrollPane sp = new JScrollPane(tableau);
		fenetre.add(sp);
		fenetre.setSize(LARGEUR, HAUTEUR);
		fenetre.setVisible(true);
	}
		
}