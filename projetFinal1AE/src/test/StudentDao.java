package test;

import java.util.ArrayList;
import java.util.Scanner;
import dao.ClientDao;
import metier.Client;

public class StudentDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Création d'un tableau dynamique contenant des clients
		ArrayList<Client> liste = new ArrayList<Client>();
		ClientDao instanceDao = new ClientDao();
		
		System.out.println("-- Ajout d'un client --");
		liste = instanceDao.createClient("Marie","DUBOIS",33,"Nice");
		liste = instanceDao.createClient("Sophie","DUBOIS",30,"Nice");
		liste = instanceDao.createClient("Anne","DUBOIS",66,"Nice");
		liste = instanceDao.createClient("Pierre","DUPONT",65,"Dauville");
		liste = instanceDao.createClient("Germain","DENTIER",23,"Montpellier");
		liste = instanceDao.createClient();//Création d'un client par l'utilisateur depuis la console
		
		//Affichage des clients contenu dans le tableau
		System.out.println("\n-- Tableau des clients --");
		afficherListe(liste);
		
		//Recherche d'un client à l'aide d'un mot-clé
		System.out.println("\n-- Recherche d'un client par son nom  --");
		Scanner scan = new Scanner(System.in);
		String mc = scan.next();
		Client cible = instanceDao.getClientParMC(mc, liste);
		if(cible!=null) {//Si un client correspond au mot-clé
			System.out.println("Première ocurrence trouvée : ");
			cible.afficherClient();
			//System.out.println("Objet trouvé : "+cible.toString());
		}else System.out.println("Aucune occurence trouvée !");
		
		//Tableau des clients ne portant pas le nom DUBOIS
		System.out.println("\n-- Liste des clients ne portant pas le nom DUBOIS --");
		liste = instanceDao.deleteClientParMC("DUBOIS", liste);
		afficherListe(liste);
		scan.close();
	}
	
	//Affiche un arraylist de client
	private static void afficherListe(ArrayList<Client> liste) {
		for(Client client : liste) {
			client.afficherClient();
		}
	}

}
