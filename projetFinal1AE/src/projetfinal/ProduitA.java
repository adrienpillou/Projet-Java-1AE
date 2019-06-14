package projetfinal;

public class ProduitA implements Iproduit{
	
	/*Variables de la classe ProduitA*/
	public String nom;
	public String ville;
	public float prix;
	public int quantité;
	public Qualité qualité;
	
	/*Constructeur avec options*/
	public ProduitA (String nom, String ville, float prix, int quantité, Qualité qualité) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantité=quantité;
		this.qualité=qualité;
	}
	/*Constructeur par défaut*/
	public ProduitA () {
		this.nom="Nouveau produit";
		this.ville="Non définie";
		this.prix=0.0f;
		this.quantité=0;
		this.qualité=Qualité.non_définie;
	}
	
	public float calculPrix() {
		return this.quantité*this.prix;
	}
}

enum Qualité{
	bas_de_gamme, haut_de_gamme, non_définie
}
