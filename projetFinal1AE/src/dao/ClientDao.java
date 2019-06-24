package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import metier.Client;

public class ClientDao {
	
	private static ArrayList<Client> listeClient = new ArrayList<Client>();
	
	//Cr�ation d'un client et ajout � la liste
	public ArrayList<Client> createClient() {
		Client nouveauClient = new Client();
		Scanner scan = new Scanner(System.in);
		//Nom du nouveau client
		System.out.println("Entrez le nom du client : ");
		nouveauClient.setNom(scan.next());
		//Pr�nom du nouveau client
		System.out.println("Entrez le pr�nom du client : ");
		nouveauClient.setPrenom(scan.next());
		//Age du nouveau client
		System.out.println("Entrez l'age du client");
		nouveauClient.set�ge(scan.nextInt());
		//Ville du nouveau client
		System.out.println("Entrez la ville du client : ");
		nouveauClient.setVille(scan.next());
		
		//Ajout du nouveau client � la listearray
		listeClient.add(nouveauClient);
		System.out.println("\nLe client "+nouveauClient.getNom()+" "+nouveauClient.getPrenom()+" a bien �t� ajout�.");
		return listeClient;
	}
	
	//Cr�ation d'un client et ajout � la liste
	public ArrayList<Client> createClient(String pr�nom, String nom, int �ge, String ville){
		Client nouveauClient = new Client(nom.toUpperCase(), pr�nom, �ge, ville);
		listeClient.add(nouveauClient);
		return listeClient;
	}
	
	//Recherche d'un client par son nom
	public Client getClientParMC(String motCl�, ArrayList<Client> listeClient) {
		Client cible = new Client();
		for(Client client : listeClient) {
			if(client.getNom().contains(motCl�.toUpperCase())) {
				return client;
			}
		}
		return null;
	}
	
	//Suppression des client portant un nom donn�
	public ArrayList<Client> deleteClientParMC(String motCl�, ArrayList<Client> listeClient) {
		Iterator<Client> iterateur=listeClient.iterator();//Cr�ation d'un it�rateur
		while(iterateur.hasNext()) {//Tant que l'arraylist n'a pas �t� parcouru
			Client client=iterateur.next();
			if(client.getNom().equals(motCl�)) {
				iterateur.remove();//Suppression du client
			}
		}
		return listeClient;
	}
	
}
