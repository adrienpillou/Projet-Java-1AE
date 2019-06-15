package projetfinal;

import java.util.ArrayList;

public class Manager {
	
	public static void main(String[] args) {
		
		//Création d'objets de type ProduitB
		ProduitB ordinateur = new ProduitB("PC", "Cergy", 999.00f, 10, 25);
		ProduitB smartphone = new ProduitB("Iphone", "Londres", 455.00f, 25, 10);
		ProduitB montre = new ProduitB("Montre", "Paris", 15000.00f, 1, 0);
		
		//Création d'objets de type ProduitA
		ProduitA collier = new ProduitA("Collier en argent", "Eragny", 339.00f, 5, Qualité.haut_de_gamme);
		ProduitA bracelet = new ProduitA("Bracelet", "Rio De Janeiro", 5.00f, 15, Qualité.bas_de_gamme);
		ProduitA pot = new ProduitA("Pot de fleur", "Gif sur Yvette", 30.00f, 10, Qualité.haut_de_gamme);
		
		//Listes de produits
		ArrayList<ProduitA> listeA = new ArrayList<ProduitA>();
		ArrayList<ProduitB> listeB = new ArrayList<ProduitB>();
		
		//Ajouts des produitA dans la listeA
		listeA.add(collier);
		listeA.add(bracelet);
		listeA.add(pot);
		
		//Ajouts des produitB dans la listeB
		listeB.add(ordinateur);
		listeB.add(smartphone);
		listeB.add(montre);
		listeB.add(new ProduitB());
		
		//Instanciation d'un tableau listant les produits de type B
		Tableau inventaire = new Tableau("Inventaire des produits de type B", créerDonnéesTableauB(listeB), ProduitB.attributs) ;
		//new Tableau("Inventaire des produits de type A",créerDonnéesTableauA(listeA), ProduitA.attributs);
	}
	
	//Fonction formatant une liste en données utilisable par le tableau (Produits de type A)
	private static String[][] créerDonnéesTableauA(ArrayList<ProduitA> liste){
		String[][] bufferDonnées= new String[liste.size()][5];
		int index=0;
		for(ProduitA produit:liste) {
			bufferDonnées[index][0]=produit.nom;
			bufferDonnées[index][1]=produit.ville;
			bufferDonnées[index][2]=Float.toString(produit.prix)+"€";
			bufferDonnées[index][3]=Integer.toString(produit.quantité);
			bufferDonnées[index][4]=produit.getQualité();
			index++;
		}
		return bufferDonnées;
	}
	
	//Fonction formatant une liste en données utilisable par le tableau (Produits de type B)
	private static String[][] créerDonnéesTableauB(ArrayList<ProduitB> liste){
		String[][] bufferDonnées= new String[liste.size()][5];
		int index=0;
		for(ProduitB produit:liste) {
			bufferDonnées[index][0]=produit.nom;
			bufferDonnées[index][1]=produit.ville;
			bufferDonnées[index][2]=Float.toString(produit.prix)+"€";
			bufferDonnées[index][3]=Integer.toString(produit.quantité);
			bufferDonnées[index][4]=Integer.toString(produit.réduction)+"%";
			index++;
		}
		return bufferDonnées;
	}

}


