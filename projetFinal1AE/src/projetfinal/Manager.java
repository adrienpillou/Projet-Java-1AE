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
		String[][] donnéesB = new String[listeB.size()][5];
		for(int i =0;i<listeB.size();i++) {
			donnéesB[i] = formaterProduit(listeB.get(i));
		}
		
		String[][] donnéesA = new String[listeA.size()][5];
		for(int i =0;i<listeB.size();i++) {
			donnéesA[i] = formaterProduit(listeA.get(i));
		}
		
		Tableau inventaireB = new Tableau("Inventaire des produits de type B", ProduitB.attributs, donnéesB) ;
		inventaireB.ajouterLigne(formaterProduit(new ProduitB("Voiture","L'Isle Adam",35000.00f,3,2)));
		
		new Tableau("Inventaire des produits de type A", ProduitA.attributs, donnéesA) ;
		
	}
	
	public static String[] formaterProduit(ProduitB produit){
		String[] ligne=new String[5];
		ligne[0]=produit.nom;
		ligne[1]=produit.ville;
		ligne[2]=String.format("%.2f", produit.prix);
		ligne[3]=String.format("%d", produit.quantité);
		ligne[4]=String.format("%d", produit.réduction);
		return ligne;
	}
	
	public static String[] formaterProduit(ProduitA produit){
		String[] ligne=new String[5];
		ligne[0]=produit.nom;
		ligne[1]=produit.ville;
		ligne[2]=String.format("%.2f", produit.prix);
		ligne[3]=String.format("%d", produit.quantité);
		ligne[4]=produit.getQualité();
		return ligne;
	}
	
	
}


