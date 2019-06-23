package metier;

public class Client {
	
	//Attributs priv�s
	private String nom;
	private String pr�nom;
	private int �ge;
	private String ville;
	
	//Constructeur avec arguments
	public Client(String nom, String pr�nom, int �ge, String ville) {
		this.nom=nom;
		this.pr�nom=pr�nom;
		this.�ge=�ge;
		this.ville=ville;
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
		this.nom = nom;
	}

	public String getPrenom() {
		return pr�nom;
	}

	public void setPrenom(String pr�nom) {
		this.pr�nom = pr�nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int get�ge() {
		return �ge;
	}
	
	public void set�ge(int �ge) {
		this.�ge = �ge;
	}
	
	//Affiche les informations d'un client en une ligne
	public void afficherClient() {
		System.out.printf("%s %s, %d ans de %s \n",this.getNom(), this.getPrenom(), this.get�ge(), this.getVille());
	}
	
	//Ecrasement du nom de l'objet n�cessaire pour la recherche par mot-cl�
	@Override
	public String toString() {
		return this.getClass().getCanonicalName()+"@"+this.getNom()+"_"+this.getPrenom()+"_"+this.get�ge()+"_"+this.getVille();
	}
	

}
