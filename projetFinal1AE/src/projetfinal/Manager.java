package projetfinal;

import java.util.ArrayList;

public class Manager {
	
	//Listes de produits
			static ArrayList<ProduitA> listeA = new ArrayList<ProduitA>();
			static ArrayList<ProduitB> listeB = new ArrayList<ProduitB>();
	
	public static void main(String[] args) {
		
		//Cr�ation d'objets de type ProduitB
		ProduitB ordinateur = new ProduitB("PC", "Cergy", 999.00f, 10, 25);
		ProduitB smartphone = new ProduitB("Iphone", "Londres", 455.00f, 25, 10);
		ProduitB montre = new ProduitB("Montre", "Paris", 1500.00f, 1, 0);
		
		//Cr�ation d'objets de type ProduitA
		ProduitA collier = new ProduitA("Collier en argent", "Eragny", 339.00f, 5, Qualit�.haut_de_gamme);
		ProduitA bracelet = new ProduitA("Bracelet", "Rio De Janeiro", 5.00f, 15, Qualit�.bas_de_gamme);
		ProduitA pot = new ProduitA("Pot de fleur", "Gif sur Yvette", 30.00f, 10, Qualit�.haut_de_gamme);
		
		//Ajouts des produitA dans la listeA
		listeA.add(collier);
		listeA.add(bracelet);
		listeA.add(pot);
		
		//Ajouts des produitB dans la listeB
		listeB.add(ordinateur);
		listeB.add(smartphone);
		listeB.add(montre);
		
		//Instanciation d'un tableau listant les produits de type B
		String[][] donn�esB = new String[listeB.size()][5];
		for(int i =0;i<listeB.size();i++) {
			donn�esB[i] = formaterProduit(listeB.get(i));
		}
		
		String[][] donn�esA = new String[listeA.size()][5];
		for(int i =0;i<listeB.size();i++) {
			donn�esA[i] = formaterProduit(listeA.get(i));
		}
		
		Tableau inventaireB = new Tableau("Inventaire des produits de type B", ProduitB.attributs, donn�esB) ;
		inventaireB.ajouterLigne(formaterProduit(new ProduitB("Voiture","L'Isle Adam",35000.00f,3,2)));
		
		new Tableau("Inventaire des produits de type A", ProduitA.attributs, donn�esA) ;
		
	}
	
	public static String[] formaterProduit(ProduitB produit){
		String[] ligne=new String[5];
		ligne[0]=produit.nom;
		ligne[1]=produit.ville;
		ligne[2]=String.format("%.2f", produit.prix);
		ligne[3]=String.format("%d", produit.quantit�);
		ligne[4]=String.format("%d", produit.r�duction);
		return ligne;
	}
	
	public static String[] formaterProduit(ProduitA produit){
		String[] ligne=new String[5];
		ligne[0]=produit.nom;
		ligne[1]=produit.ville;
		ligne[2]=String.format("%.2f", produit.prix);
		ligne[3]=String.format("%d", produit.quantit�);
		ligne[4]=produit.getQualit�();
		return ligne;
	}
	
	
}


