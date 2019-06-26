package metier;

public class Client {
	
	//Attributs priv�s
	private String nom; //Nom du client
	private String pr�nom; //Pr�nom du client
	private int �ge; //Age du client 
	private String ville; //Ville du client
	
	//Constructeur avec arguments
	public Client(String nom, String pr�nom, int �ge, String ville) {
		this.nom=nom.toUpperCase();
		this.pr�nom=pr�nom.substring(0,1).toUpperCase()+pr�nom.substring(1).toLowerCase();
		this.�ge=�ge;
		this.ville=ville.substring(0,1).toUpperCase()+ville.substring(1).toLowerCase();
	}
	
	//Constructeur par d�faut
	public Client() {
		nom="Nom du client";
		pr�nom="Pr�nom du client";
		�ge=0;
		ville="Ville du client";
	}

	//Getter - Setter du client g�n�r�s par Eclipse
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPr�nom() {
		return pr�nom;
	}

	public void setPrenom(String pr�nom) {
		this.pr�nom = pr�nom.substring(0,1).toUpperCase()+pr�nom.substring(1).toLowerCase();
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville.substring(0,1).toUpperCase()+ville.substring(1).toLowerCase();
	}

	public int get�ge() {
		return �ge;
	}
	
	public void set�ge(int �ge) {
		this.�ge = �ge;
	}
	
	//Affiche les informations d'un client en une ligne dans la console
	public void afficherClient() {
		System.out.printf("%s %s, %d ans de %s \n",this.getNom(), this.getPr�nom(), this.get�ge(), this.getVille());
	}
	
	/*
	@Override
	public String toString() {
		return this.getClass().getCanonicalName()+"@"+this.getNom()+"_"+this.getPrenom()+"_"+this.get�ge()+"_"+this.getVille();
	}*/
	
}
