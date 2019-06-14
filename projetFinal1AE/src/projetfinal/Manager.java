package projetfinal;

public class Manager {

	public static void main(String[] args) {
		//Création d'un nouvel objet de type ProduitB
		ProduitB ordinateur = new ProduitB("PC", "Cergy", 999.00f, 10, 25);
		
		//Création d'un nouvel objet de type ProduitA
		ProduitA collier = new ProduitA("Collier argent", "Eragny", 333.00f, 5, Qualité.haut_de_gamme);
		
		System.out.println(ordinateur.nom + " x " + ordinateur.quantité + " : "+ordinateur.calculPrix()+"€");
		System.out.println(collier.nom + " x " + collier.quantité + " : " + collier.calculPrix() + "€");
	
	}

}
