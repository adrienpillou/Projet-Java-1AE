package projetfinal;

public class Manager {

	public static void main(String[] args) {
		//Cr�ation d'un nouvel objet de type ProduitB
		ProduitB ordinateur = new ProduitB("PC", "Cergy", 999.00f, 10, 25);
		
		//Cr�ation d'un nouvel objet de type ProduitA
		ProduitA collier = new ProduitA("Collier argent", "Eragny", 333.00f, 5, Qualit�.haut_de_gamme);
		
		System.out.println(ordinateur.nom + " x " + ordinateur.quantit� + " : "+ordinateur.calculPrix()+"�");
		System.out.println(collier.nom + " x " + collier.quantit� + " : " + collier.calculPrix() + "�");
	
	}

}
