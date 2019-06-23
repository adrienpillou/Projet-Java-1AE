package dao;

import java.util.ArrayList;
import java.util.Scanner;
import metier.Client;

public class ClientDao {
	
	private static ArrayList<Client> listeClient = new ArrayList<Client>();
	
	//Création d'un client et ajout à la liste
	public static ArrayList<Client> createClient() {
		Client nouveauClient = new Client();
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez nom ");
		nouveauClient.setNom(scan.next());
		System.out.println("Entrez prénom ");
		nouveauClient.setPrenom(scan.next());
		System.out.println("Entrez age ");
		nouveauClient.setÂge(scan.nextInt());
		System.out.println("Entrez ville ");
		nouveauClient.setVille(scan.next());
		listeClient.add(nouveauClient);
		scan.close();
		return listeClient;
	}
	
	//Création d'un client et ajout à la liste
	public static ArrayList<Client> createClient(String prénom, String nom, int âge, String ville){
		Client nouveauClient = new Client(nom, prénom, âge, ville);
		listeClient.add(nouveauClient);
		return listeClient;
	}
	
	//Recherche d'un client
	public static Client getClientParMC(String motClé, ArrayList<Client> listeClient) {
		Client cible = new Client();
		for(Client client : listeClient) {
			if(client.toString().contains(motClé)) {
				return client;
			}
		}
		return null;
	}
	
	//Extraction des clients ne portant pas un nom donné
	public static ArrayList<Client> deleteClientParMC(String motClé, ArrayList<Client> listeClient) {
		ArrayList<Client> listeNonInclus = new ArrayList<Client>();
		for(Client client:listeClient) {
			if(!client.getNom().equals(motClé))listeNonInclus.add(client);
		}
		return listeNonInclus;
	}
	
}
