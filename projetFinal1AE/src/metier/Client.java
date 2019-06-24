package metier;

public class Client {
	
	//Attributs privés
	private String nom;
	private String prénom;
	private int âge;
	private String ville;
	
	//Constructeur avec arguments
	public Client(String nom, String prénom, int âge, String ville) {
		this.nom=nom.toUpperCase();
		this.prénom=prénom.substring(0,1).toUpperCase()+prénom.substring(1).toLowerCase();
		this.âge=âge;
		this.ville=ville.substring(0,1).toUpperCase()+ville.substring(1).toLowerCase();
	}
	
	//Constructeur par défaut
	public Client() {
		nom="Nom du client";
		prénom="Prénom du client";
		âge=0;
		ville="Ville du client";
	}

	//Getter - Setter du client générés par Eclipse
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prénom;
	}

	public void setPrenom(String prénom) {
		this.prénom = prénom.substring(0,1).toUpperCase()+prénom.substring(1).toLowerCase();
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville.substring(0,1).toUpperCase()+ville.substring(1).toLowerCase();
	}

	public int getÂge() {
		return âge;
	}
	
	public void setÂge(int âge) {
		this.âge = âge;
	}
	
	//Affiche les informations d'un client en une ligne dans la console
	public void afficherClient() {
		System.out.printf("%s %s, %d ans de %s \n",this.getNom(), this.getPrenom(), this.getÂge(), this.getVille());
	}
	
	/*
	@Override
	public String toString() {
		return this.getClass().getCanonicalName()+"@"+this.getNom()+"_"+this.getPrenom()+"_"+this.getÂge()+"_"+this.getVille();
	}*/
	

}
