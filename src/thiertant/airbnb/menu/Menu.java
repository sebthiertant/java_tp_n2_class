package thiertant.airbnb.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import thiertant.airbnb.lodgings.Appartment;
import thiertant.airbnb.lodgings.Lodging;
import thiertant.airbnb.lodgings.House;
import thiertant.airbnb.reservations.Reservation;
import thiertant.airbnb.users.Host;
import thiertant.airbnb.users.Traveller;
import thiertant.airbnb.tools.XmlParser;

public class Menu {

	static Scanner scanner;

	static ArrayList<Host> listHotes;
	static ArrayList<Lodging> listLogements;
	static ArrayList<Traveller> listVoyageurs;
	static ArrayList<Reservation> listReservations;

	public static void main(String[] args) {

		ArrayList xmlDataArrayList = new ArrayList();
		// instanciation du xml parser
		XmlParser xmlParser = new XmlParser();
		xmlParser.ParseXml(xmlDataArrayList);

		for (int k = 0; k < xmlDataArrayList.size(); k++) {
			System.out.println(xmlDataArrayList.get(k) instanceof Appartment);
		}

		System.out.println("Bienvenu chez AirBnB");

		scanner = new Scanner(System.in);

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();

		// créer les instances des différentes classes
		init();

		listerMenu();

		scanner.close();
	}

	static void listerMenu() {

		System.out.println("-------------------------------------");
		System.out.println("Saisir une option : ");
		System.out.println("1 : Liste des hôtes");
		System.out.println("2 : Liste des logements");
		System.out.println("3 : Liste des voyageurs");
		System.out.println("4 : Liste des réservations");
		System.out.println("5 : Fermer le programme");

		switch (choix(5)) {
		case 1:
			GestionHotes.listerHotes();
			break;
		case 2:
			GestionLogements.listerLogements();
			break;
		case 3:
			GestionVoyageurs.listerVoyageurs();
			break;
		case 4:
			GestionReservations.listerReservations();
			break;
		case 5:
			System.out.println("A bientôt");
			break;
		}
	}

	static int choix(int maxValue) {

		int choix = 0;
		boolean choixOk = false;

		do {
			try {
				choix = scanner.nextInt();
				if (choix > 0 && choix <= maxValue)
					choixOk = true;
				else {
					System.out.println("Saisir une valeur entre 1 et " + maxValue);
				}
			} catch (InputMismatchException e) {
				System.out.println("Saisir une valeur entre 1 et " + maxValue);
				scanner.next();
			}

		} while (!choixOk);

		return choix;
	}

	private static void init() {

		// Création des Hotes
		Host host1 = new Host("Peter", "Bardu", 28, 12);
		Host host2 = new Host("Patrick", "Martin", 32, 12);
		Host host3 = new Host("Jeanne", "Voisin", 26, 24);
		Host host4 = new Host("Maurice", "Meunier", 46, 12);

		listHotes.add(host1);
		listHotes.add(host2);
		listHotes.add(host3);
		listHotes.add(host4);

		// Création de Logement
		House house1 = new House(host1, 40, "18 Bis rue Romain Rolland, 37230 Fondettes", 140, 2, 500, true);
		House house2 = new House(host1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
		House house3 = new House(host1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
		Appartment appartment1 = new Appartment(host1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
		Appartment appartment2 = new Appartment(host1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);

		listLogements.add(house1);
		listLogements.add(house2);
		listLogements.add(house3);
		listLogements.add(appartment1);
		listLogements.add(appartment2);

		// Création de voyageurs
		Traveller traveller1 = new Traveller("Alain", "Favre", 54);
		Traveller traveller2 = new Traveller("Maxime", "Albert", 29);

		listVoyageurs.add(traveller1);
		listVoyageurs.add(traveller2);
	}

}
