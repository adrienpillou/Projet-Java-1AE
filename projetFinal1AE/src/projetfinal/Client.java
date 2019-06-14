package projetfinal;

public class Client {
	
	private String nom;
	private String prenom;
	private int âge;
	private String ville;
	
	public Client(String nom, String prenom, int age, String ville) {
		this.nom=nom;
		this.prenom=prenom;
		this.âge=age;
		this.ville=ville;
	}
	
	public Client() {
		nom="Nom du client";
		prenom="Prénom du client";
		âge=0;
		ville="Ville du client";
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public int getAge() {
		return âge;
	}
	
	public String getVille() {
		return ville;
	}
}
