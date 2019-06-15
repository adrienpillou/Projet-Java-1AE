package projetfinal;

public class ProduitA implements Iproduit{
	
	/*Variables de la classe ProduitA*/
	public String nom;
	public String ville;
	public float prix;
	public int quantit�;
	public Qualit� qualit�;
	
	public static String[] attributs= {"Nom","Ville","Prix Unitaire","Quantit�","Qualit�"};
	
	/*Constructeur avec options*/
	public ProduitA (String nom, String ville, float prix, int quantit�, Qualit� qualit�) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantit�=quantit�;
		this.qualit�=qualit�;
	}
	/*Constructeur par d�faut*/
	public ProduitA () {
		this.nom="Nouveau produit";
		this.ville="Non d�finie";
		this.prix=0.0f;
		this.quantit�=0;
		this.qualit�=Qualit�.non_d�finie;
	}
	
	public float calculPrix() {
		return this.quantit�*this.prix;
	}
	
	public String getQualit�() {
		switch(this.qualit�) {
		case bas_de_gamme:
			return "Bas de gamme";
			
		case haut_de_gamme:
			return "Haut de gamme";
			
		default:
			return "Qualit� non d�finie";
		}
	}
	
}

enum Qualit�{
	bas_de_gamme, haut_de_gamme, non_d�finie;
}
