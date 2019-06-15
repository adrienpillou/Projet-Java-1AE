package projetfinal;

import java.util.ArrayList;

public class Manager {
	
	//Listes de produits
			static ArrayList<ProduitA> listeA = new ArrayList<ProduitA>();
			static ArrayList<ProduitB> listeB = new ArrayList<ProduitB>();
	
	public static void main(String[] args) {
		
		//Création d'objets de type ProduitB
		ProduitB ordinateur = new ProduitB("PC", "Cergy", 999.00f, 10, 25);
		ProduitB smartphone = new ProduitB("Iphone", "Londres", 455.00f, 25, 10);
		ProduitB montre = new ProduitB("Montre", "Paris", 1500.00f, 1, 0);
		
		//Création d'objets de type ProduitA
		ProduitA collier = new ProduitA("Collier en argent", "Eragny", 339.00f, 5, Qualité.haut_de_gamme);
		ProduitA bracelet = new ProduitA("Bracelet", "Rio De Janeiro", 5.00f, 15, Qualité.bas_de_gamme);
		ProduitA pot = new ProduitA("Pot de fleur", "Gif sur Yvette", 30.00f, 10, Qualité.haut_de_gamme);
		
		//Ajouts des produitA dans la listeA
		listeA.add(collier);
		listeA.add(bracelet);
		listeA.add(pot);
		
		//Ajouts des produitB dans la listeB
		listeB.add(ordinateur);
		listeB.add(smartphone);
		listeB.add(montre);
		
		//Instanciation d'un tableau listant les produits de type B
		Tableau inventaireB = new Tableau("Inventaire des produits de type B", listeB, ProduitB.attributs, new ProduitB()) ;
		inventaireB.ajouterLigne(new ProduitB("Voiture","L'Isle Adam",35000.00f,3,2));
		
		Tableau inventaireA = new Tableau("Inventaire des produits de type A", listeA, ProduitA.attributs, new ProduitA()) ;
		
	}
	
	public static void mettreAJourListe(ProduitB produit) {//Mettre à jour la listeB après un ajout
		listeB.add(produit);
	}
	
	public static void mettreAJourListe(ProduitA produit) {//Mettre à jour la listeA après un ajout
		listeA.add(produit);
	}
}


