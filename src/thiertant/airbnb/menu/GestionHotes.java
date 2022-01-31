package thiertant.airbnb.menu;

import java.util.Scanner;

import thiertant.airbnb.users.Host;

class GestionHotes {

	static void listerHotes() {

		Menu.scanner = new Scanner(System.in);

		System.out.println("-------------------------------------");
		System.out.println("Liste des hôtes ");

		for (int i = 0; i < Menu.listHotes.size(); i++) {
			System.out.print("Numéro " + i + " : ");
			Menu.listHotes.get(i).display();
		}

		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		try {
			switch (Menu.choix(3)) {
			case 1:
				ajouterHote();
				break;
			case 2:
				supprimerHote();
				break;
			case 3:
				Menu.listerMenu();
				break;
			}
		} catch (Exception e) {
			System.out.println("Une erreur est survenue");
			Menu.scanner.next();
			listerHotes();
		}
	}

	private static void ajouterHote() throws Exception {

		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		System.out.print("Prénom : ");
		String prenom = Menu.scanner.next();
		System.out.print("Nom : ");
		String nom = Menu.scanner.next();
		System.out.print("Age : ");
		int age = Menu.scanner.nextInt();
		System.out.print("Temps de réponse (heure) : ");
		int delaiReponse = Menu.scanner.nextInt();

		Host newHote = new Host(prenom, nom, age, delaiReponse);
		Menu.listHotes.add(newHote);

		System.out.println("Votre hôte a été ajouté avec succès");

		listerHotes();
	}

	/**
	 * @throws Exception
	 */
	private static void supprimerHote() throws Exception {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.print("Numéro : ");
		int numero = Menu.scanner.nextInt();

		try {
			Menu.listHotes.remove(numero);
			System.out.println("Votre hôte a été supprimé avec succès");
		} catch (Exception e) {
			System.out.println("Ce numéro d'hôte n'existe pas");
		}
		
		listerHotes();
	}

}
