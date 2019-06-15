package projetfinal;

import java.util.ArrayList;

public class Manager {
	
	public static void main(String[] args) {
		
		//Cr�ation d'objets de type ProduitB
		ProduitB ordinateur = new ProduitB("PC", "Cergy", 999.00f, 10, 25);
		ProduitB smartphone = new ProduitB("Iphone", "Londres", 455.00f, 25, 10);
		ProduitB montre = new ProduitB("Montre", "Paris", 15000.00f, 1, 0);
		
		//Cr�ation d'objets de type ProduitA
		ProduitA collier = new ProduitA("Collier en argent", "Eragny", 339.00f, 5, Qualit�.haut_de_gamme);
		ProduitA bracelet = new ProduitA("Bracelet", "Rio De Janeiro", 5.00f, 15, Qualit�.bas_de_gamme);
		ProduitA pot = new ProduitA("Pot de fleur", "Gif sur Yvette", 30.00f, 10, Qualit�.haut_de_gamme);
		
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
		Tableau inventaire = new Tableau("Inventaire des produits de type B", cr�erDonn�esTableauB(listeB), ProduitB.attributs) ;
		//new Tableau("Inventaire des produits de type A",cr�erDonn�esTableauA(listeA), ProduitA.attributs);
	}
	
	//Fonction formatant une liste en donn�es utilisable par le tableau (Produits de type A)
	private static String[][] cr�erDonn�esTableauA(ArrayList<ProduitA> liste){
		String[][] bufferDonn�es= new String[liste.size()][5];
		int index=0;
		for(ProduitA produit:liste) {
			bufferDonn�es[index][0]=produit.nom;
			bufferDonn�es[index][1]=produit.ville;
			bufferDonn�es[index][2]=Float.toString(produit.prix)+"�";
			bufferDonn�es[index][3]=Integer.toString(produit.quantit�);
			bufferDonn�es[index][4]=produit.getQualit�();
			index++;
		}
		return bufferDonn�es;
	}
	
	//Fonction formatant une liste en donn�es utilisable par le tableau (Produits de type B)
	private static String[][] cr�erDonn�esTableauB(ArrayList<ProduitB> liste){
		String[][] bufferDonn�es= new String[liste.size()][5];
		int index=0;
		for(ProduitB produit:liste) {
			bufferDonn�es[index][0]=produit.nom;
			bufferDonn�es[index][1]=produit.ville;
			bufferDonn�es[index][2]=Float.toString(produit.prix)+"�";
			bufferDonn�es[index][3]=Integer.toString(produit.quantit�);
			bufferDonn�es[index][4]=Integer.toString(produit.r�duction)+"%";
			index++;
		}
		return bufferDonn�es;
	}

}


