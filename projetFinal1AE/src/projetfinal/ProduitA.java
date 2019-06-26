package projetfinal;

public class ProduitA implements Iproduit{
	
	//Variables de la classe ProduitA
	public String nom; //Nom du produit
	public String ville; //Ville de provenance du produit
	public float prix; //Prix unitaire du produit
	public int quantité; //Nombre d'unités
	public String qualité; //Qualité du produit
	
	//Légende des attributs de la classe utilisée pour les colonnes du tableau
	public static String[] attributs= {"Nom","Ville","Prix Unitaire (€)","Quantité","Qualité"};
	
	//Constructeur avec paramètres
	public ProduitA (String nom, String ville, float prix, int quantité, Qualité qualité) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantité=quantité;
		this.qualité=qualité.getQualité(qualité); //Récupérartion d'une String désignant la qualité du produit
	}
	
	//Constructeur par défaut
	public ProduitA () {
		this.nom="Nouveau produit";
		this.ville="Non définie";
		this.prix=0.0f;
		this.quantité=0;
		this.qualité=Qualité.getQualité(Qualité.bas_de_gamme);
	}
	
	//Fonction de l'interface IProduit
	public float calculPrix() {
		return this.quantité*this.prix;
	}

}

//Enumération des qualités
enum Qualité{
	bas_de_gamme, haut_de_gamme, non_définie;
	
	//Convertit les valeur de l'énumération en String
	public static String getQualité(Qualité qualité) {
		switch(qualité) {
		case bas_de_gamme:
			return "Bas de gamme";
			
		case haut_de_gamme:
			return "Haut de gamme";
			
		default:
			return "Erreur : Qualité non définie";
		}
	}
}
