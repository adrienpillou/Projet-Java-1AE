package test;

import java.util.ArrayList;
import java.util.Scanner;
import dao.ClientDao;
import metier.Client;

public class StudentDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Création du tableau dynamique des clients
		ArrayList<Client> liste = new ArrayList<Client>();
		liste = ClientDao.createClient("Marie","DUBOIS",33,"Nice");
		liste = ClientDao.createClient("Sophie","DUBOIS",30,"Nice");
		liste = ClientDao.createClient("Anne","DUBOIS",66,"Nice");
		liste = ClientDao.createClient("Pierre","DUPONT",65,"Dauville");
		liste = ClientDao.createClient("Germain","DENTIER",23,"Montpellier");
		
		//Affichage des clients du tableau
		System.out.println("\n-- Tableau des clients  --");
		for(Client client : liste) {
			client.afficherClient();
		}
		
		//Recherche d'un client à l'aide d'un mot-clé
		System.out.println("\n-- Entrez un mot-clé  --");
		Scanner scan = new Scanner(System.in);
		Client cible = ClientDao.getClientParMC(scan.nextLine(), liste);
		if(cible!=null) {//Si un client correspond au mot-clé
			System.out.println("Première ocurrence trouvée : ");
			cible.afficherClient();
			System.out.println("Objet trouvé : "+cible.toString());
		}else System.out.println("Aucun résultat trouvé !");
		scan.close();
		
		//Extraction des clients ne portant pas le nom DUBOIS
		System.out.println("\n-- Liste des clients ne portant pas le nom DUBOIS --");
		liste = ClientDao.deleteClientParMC("DUBOIS", liste);
		for(Client client:liste) {//Affichage de la nouvelle liste
			client.afficherClient();
		}
	}

}
