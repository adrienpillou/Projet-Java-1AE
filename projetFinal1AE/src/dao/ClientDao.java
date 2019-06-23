package dao;

import java.util.ArrayList;
import java.util.Scanner;
import metier.Client;

public class ClientDao {
	
	private static ArrayList<Client> listeClient = new ArrayList<Client>();
	
	//Cr�ation d'un client et ajout � la liste
	public static ArrayList<Client> createClient() {
		Client nouveauClient = new Client();
		Scanner scan = new Scanner(System.in);
		System.out.println("Entrez nom ");
		nouveauClient.setNom(scan.next());
		System.out.println("Entrez pr�nom ");
		nouveauClient.setPrenom(scan.next());
		System.out.println("Entrez age ");
		nouveauClient.set�ge(scan.nextInt());
		System.out.println("Entrez ville ");
		nouveauClient.setVille(scan.next());
		listeClient.add(nouveauClient);
		scan.close();
		return listeClient;
	}
	
	//Cr�ation d'un client et ajout � la liste
	public static ArrayList<Client> createClient(String pr�nom, String nom, int �ge, String ville){
		Client nouveauClient = new Client(nom, pr�nom, �ge, ville);
		listeClient.add(nouveauClient);
		return listeClient;
	}
	
	//Recherche d'un client
	public static Client getClientParMC(String motCl�, ArrayList<Client> listeClient) {
		Client cible = new Client();
		for(Client client : listeClient) {
			if(client.toString().contains(motCl�)) {
				return client;
			}
		}
		return null;
	}
	
	//Extraction des clients ne portant pas un nom donn�
	public static ArrayList<Client> deleteClientParMC(String motCl�, ArrayList<Client> listeClient) {
		ArrayList<Client> listeNonInclus = new ArrayList<Client>();
		for(Client client:listeClient) {
			if(!client.getNom().equals(motCl�))listeNonInclus.add(client);
		}
		return listeNonInclus;
	}
	
}
