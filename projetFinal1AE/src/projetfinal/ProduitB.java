package projetfinal;

public class ProduitB implements Iproduit{
	
	//Variables de la classe ProduitB
	public String nom; //Nom du produit
	public String ville; //Ville de provenance du produit
	public float prix; //Prix unitaire du produit
	public int quantit�; //Nombre d'unit�s
	public int r�duction; //R�duction applicable au produit
	
	//L�gende des attributs de la classe utilis�e pour les colonnes du tableau
	public static String[] attributs= {"Nom du produit","Ville de provenance","Prix Unitaire (�)","Quantit�","R�duction (%)"};
	
	//Constructeur avec param�tres
	public ProduitB (String nom, String ville, float prix, int quantit�, int r�duction) {
		this.nom=nom;
		this.ville=ville;
		this.prix=prix;
		this.quantit�=quantit�;
		this.r�duction=r�duction;
	}
	
	//Constructeur par d�faut
	public ProduitB() {
		this.nom="Nouveau produit";
		this.ville="Non d�finie";
		this.prix=0.0f;
		this.quantit�=0;
		this.r�duction=0;
	}
	
	//Fonction de l'interface IProduit
	public float calculPrix() {
		return (this.quantit�*this.prix)*(1-(this.r�duction*.01f));
	}
}
