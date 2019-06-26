package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import metier.Client;

public class ClientDao {
	
	private static ArrayList<Client> listeClient = new ArrayList<Client>();
	
	//Création d'un client et ajout à la liste
	public ArrayList<Client> createClient() {
		Client nouveauClient = new Client();
		Scanner scan = new Scanner(System.in); //Initialisation du scanner console
		
		//Nom du nouveau client
		System.out.println("Entrez le nom du client : ");
		nouveauClient.setNom(scan.next());
		
		//Prénom du nouveau client
		System.out.println("Entrez le prénom du client : ");
		nouveauClient.setPrenom(scan.next());
		
		//Age du nouveau client
		System.out.println("Entrez l'age du client");
		nouveauClient.setÂge(scan.nextInt());
		
		//Ville du nouveau client
		System.out.println("Entrez la ville du client : ");
		nouveauClient.setVille(scan.next());
		
		//Ajout du nouveau client dans l'ArrayList
		listeClient.add(nouveauClient);
		System.out.println("\nLe client "+nouveauClient.getNom()+" "+nouveauClient.getPrénom()+" a bien été ajouté.");
		return listeClient;
	}
	
	//Création d'un client et ajout à la liste (par le constructeur)
	public ArrayList<Client> createClient(String prénom, String nom, int âge, String ville){
		Client nouveauClient = new Client(nom.toUpperCase(), prénom, âge, ville);
		listeClient.add(nouveauClient); //ajout du nouveau client dans la liste
		return listeClient;
	}
	
	//Recherche d'un client par son nom
	public Client getClientParMC(String motClé, ArrayList<Client> listeClient) {
		for(Client client : listeClient) {
			if(client.getNom().contains(motClé.toUpperCase())) { //Si le nom du client contient le mot-clé
				return client;
			}
		}
		return null; //Si aucune ocurrence n'a été trouvé
	}
	
	//Suppression des client portant un nom donné
	public ArrayList<Client> deleteClientParMC(String motClé, ArrayList<Client> listeClient) {
		Iterator<Client> iterateur=listeClient.iterator(); //Création d'un itérateur
		while(iterateur.hasNext()) { //Tant que l'arraylist n'a pas été parcouru entièrement
			Client client=iterateur.next();
			if(client.getNom().equals(motClé)) { //Si le client sélectionné par l'itérateur porte le nom recherché
				iterateur.remove(); //Suppression du client
			}
		}
		return listeClient;
	}
	
}
