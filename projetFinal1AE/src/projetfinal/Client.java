package projetfinal;

public class Client {
	
	private String nom;
	private String prenom;
	private int �ge;
	private String ville;
	
	public Client(String nom, String prenom, int age, String ville) {
		this.nom=nom;
		this.prenom=prenom;
		this.�ge=age;
		this.ville=ville;
	}
	
	public Client() {
		nom="Nom du client";
		prenom="Pr�nom du client";
		�ge=0;
		ville="Ville du client";
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public int getAge() {
		return �ge;
	}
	
	public String getVille() {
		return ville;
	}
}
