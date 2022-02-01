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

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listReservations = new ArrayList<>();
		listVoyageurs = new ArrayList<>();

		System.out.println("Bienvenu chez AirBnB");

		scanner = new Scanner(System.in);

		// créer les instances des différentes classes dont certaines en faisant appel au scanner
		init(listHotes, listLogements, listVoyageurs);

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

	private static void init(ArrayList listHotes, ArrayList listLogements, ArrayList listVoyageurs) {
		// instanciation du xml parser qui créé les hotes et les logements
		XmlParser xmlParser = new XmlParser();
		xmlParser.ParseXml(listHotes, listLogements);

		// Création de voyageurs
		Traveller traveller1 = new Traveller("Alain", "Favre", 54);
		Traveller traveller2 = new Traveller("Maxime", "Albert", 29);

		listVoyageurs.add(traveller1);
		listVoyageurs.add(traveller2);
	}

}
