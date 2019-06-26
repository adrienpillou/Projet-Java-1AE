package projetfinal;

public class ProduitA implements Iproduit{
	
	//Variables de la classe ProduitA
	public String nom; //Nom du produit
	public String ville; //Ville de provenance du produit
	public float prix; //Prix unitaire du produit
	public int quantit�; //Nombre d'unit�s
	public String qualit�; //Qualit� du produit
	
	//L�gende des attributs de la classe utilis�e pour les colonnes du tableau
	public static String[] attributs= {"Nom","Ville","Prix Unitaire (�)","Quantit�","Qualit�"};
	
	//Constructeur avec param�tres
	public ProduitA (String nom, String ville, float prix, int quantit�, Qualit� qualit�) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantit�=quantit�;
		this.qualit�=qualit�.getQualit�(qualit�); //R�cup�rartion d'une String d�signant la qualit� du produit
	}
	
	//Constructeur par d�faut
	public ProduitA () {
		this.nom="Nouveau produit";
		this.ville="Non d�finie";
		this.prix=0.0f;
		this.quantit�=0;
		this.qualit�=Qualit�.getQualit�(Qualit�.bas_de_gamme);
	}
	
	//Fonction de l'interface IProduit
	public float calculPrix() {
		return this.quantit�*this.prix;
	}

}

//Enum�ration des qualit�s
enum Qualit�{
	bas_de_gamme, haut_de_gamme, non_d�finie;
	
	//Convertit les valeur de l'�num�ration en String
	public static String getQualit�(Qualit� qualit�) {
		switch(qualit�) {
		case bas_de_gamme:
			return "Bas de gamme";
			
		case haut_de_gamme:
			return "Haut de gamme";
			
		default:
			return "Erreur : Qualit� non d�finie";
		}
	}
}
