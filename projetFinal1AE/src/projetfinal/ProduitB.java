package projetfinal;

public class ProduitB implements Iproduit{
	
	public String nom;
	public String ville;
	public float prix;
	public int quantité;
	public int réduction;
	
	public static String[] attributs= {"Nom","Ville","Prix Unitaire","Quantité","Réduction"};
	
	/*Constructeur*/
	public ProduitB (String nom, String ville, float prix, int quantité, int réduction) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantité=quantité;
		this.réduction=réduction;
	}
	
	public ProduitB() {
		this.nom="Nouveau produit";
		this.ville="Non définie";
		this.prix=0.0f;
		this.quantité=0;
		this.réduction=0;
	}
	
	public float calculPrix() {
		return (this.quantité*this.prix)*(1-(this.réduction*.01f));
	}
}
