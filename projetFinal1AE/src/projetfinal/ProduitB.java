package projetfinal;

public class ProduitB implements Iproduit{
	
	public String nom;
	public String ville;
	public float prix;
	public int quantit�;
	public int r�duction;
	
	public static String[] attributs= {"Nom","Ville","Prix Unitaire","Quantit�","R�duction"};
	
	/*Constructeur*/
	public ProduitB (String nom, String ville, float prix, int quantit�, int r�duction) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantit�=quantit�;
		this.r�duction=r�duction;
	}
	
	public ProduitB() {
		this.nom="Nouveau produit";
		this.ville="Non d�finie";
		this.prix=0.0f;
		this.quantit�=0;
		this.r�duction=0;
	}
	
	public float calculPrix() {
		return (this.quantit�*this.prix)*(1-(this.r�duction*.01f));
	}
}
